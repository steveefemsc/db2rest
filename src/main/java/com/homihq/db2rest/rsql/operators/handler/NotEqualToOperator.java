package com.homihq.db2rest.rsql.operators.handler;

import com.homihq.db2rest.rsql.operators.Operator;
import org.mybatis.dynamic.sql.ColumnAndConditionCriterion;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlCriterion;
import static org.mybatis.dynamic.sql.SqlBuilder.isNotEqualTo;

public class NotEqualToOperator implements Operator {

    @Override
    public SqlCriterion handle(SqlColumn<Object> column, String value, Class<?> type) {

        return ColumnAndConditionCriterion.withColumn(column)
                .withCondition(isNotEqualTo(value)).build();

    }

}
