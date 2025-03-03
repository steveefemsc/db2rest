package com.homihq.db2rest.rest.read.processor;

import com.homihq.db2rest.rest.read.dto.ReadContextV2;
import com.homihq.db2rest.rest.read.processor.post.ReadPostProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static org.mybatis.dynamic.sql.select.SelectDSL.select;

@Component
@Slf4j
@RequiredArgsConstructor
public class QueryCreatorTemplate {

    private final List<ReadPostProcessor> postProcessors;

    public void createQuery(ReadContextV2 readContextV2) {
        QueryExpressionDSL<SelectModel> queryExpressionDSL = createProjection(readContextV2);

        if(Objects.nonNull(readContextV2.getWhereCondition())) {
            queryExpressionDSL.where(readContextV2.getWhereCondition());
        }

        addSort(queryExpressionDSL, readContextV2.getSorts());

        for(ReadPostProcessor processor : postProcessors) {
            processor.process(queryExpressionDSL, readContextV2);
        }

        SelectStatementProvider selectStatementProvider =  queryExpressionDSL.build().render(RenderingStrategies.SPRING_NAMED_PARAMETER);

        log.info("SQL - {}", selectStatementProvider.getSelectStatement());
        log.info("Bind Variables - {}", selectStatementProvider.getParameters());

    }

    private void addSort(QueryExpressionDSL<SelectModel> queryExpressionDSL, List<String> sorts) {
    }


    protected QueryExpressionDSL<SelectModel> createProjection(ReadContextV2 readContextV2) {
       return
                select(readContextV2.getColumns())
                        .from(readContextV2.getRootTable(), readContextV2.getRootTable().getAlias());
    }
}
