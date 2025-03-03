package com.homihq.db2rest.rest.delete;

import com.homihq.db2rest.rest.delete.dto.DeleteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface DeleteRestApi {
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{tableName}")
    DeleteResponse delete(@PathVariable String tableName,
                          @RequestParam(name = "schemaName", required = false) String schemaName,
                          @RequestParam(name = "filter", required = false, defaultValue = "") String filter);
}
