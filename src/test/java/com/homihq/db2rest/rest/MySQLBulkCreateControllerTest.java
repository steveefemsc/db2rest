package com.homihq.db2rest.rest;

import com.homihq.db2rest.MySQLBaseIntegrationTest;
import com.homihq.db2rest.utils.ITestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class MySQLBulkCreateControllerTest extends MySQLBaseIntegrationTest {

    @Test
    @DisplayName("Create many films.")
    void create() throws Exception {

        mockMvc.perform(post("/film/bulk")
                        .characterEncoding(UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .header("Content-Profile", "sakila")
                        .content(ITestUtil.BULK_CREATE_FILM_REQUEST))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows", hasSize(2)))
                .andExpect(jsonPath("$.rows", hasItem(1)))
                .andExpect(jsonPath("$.rows", hasItem(1)))
                .andExpect(jsonPath("$.generated_keys").isArray())
                .andExpect(jsonPath("$.generated_keys", hasSize(2)))
                .andExpect(jsonPath("$.generated_keys", allOf(notNullValue())))
                //.andDo(print())
                .andDo(document("mysql-bulk-create-films"));

    }

    @Test
    @DisplayName("Create many films with CSV type.")
    void createCSV() throws Exception {

        mockMvc.perform(post("/film/bulk")
                        .characterEncoding(UTF_8)
                        .contentType("text/csv")
                        .accept(APPLICATION_JSON)
                        .content(ITestUtil.CREATE_FILM_REQUEST_CSV))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rows", hasSize(2)))
                .andExpect(jsonPath("$.rows", hasItem(1)))
                .andExpect(jsonPath("$.generated_keys", hasSize(2)))
                .andExpect(jsonPath("$.generated_keys", allOf(notNullValue())))
                //.andDo(print())
                .andDo(document("mysql-bulk-create-films-csv"));

    }

    @Test
    @DisplayName("Create many films with CSV type resulting error.")
    void createCSVWithError() throws Exception {

        mockMvc.perform(post("/film/bulk")
                        .characterEncoding(UTF_8)
                        .contentType("text/csv")
                        .accept(APPLICATION_JSON)
                        .content(ITestUtil.CREATE_FILM_BAD_REQUEST_CSV))
                .andExpect(status().isBadRequest())
                //.andDo(print())
                .andDo(document("mysql-bulk-create-films-csv-error"));

    }

    @Test
    @DisplayName("Create many films with failure.")
    void createError() throws Exception {

        mockMvc.perform(post("/film/bulk")
                        .characterEncoding(UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .header("Content-Profile", "sakila")
                        .content(ITestUtil.BULK_CREATE_FILM_BAD_REQUEST))
                .andExpect(status().isBadRequest())
                // .andDo(print())
                .andDo(document("mysql-bulk-create-films-error"));

    }

    @Test
    @DisplayName("Create many directors.")
    void createDirector() throws Exception {

        mockMvc.perform(post("/director/bulk")
                        .characterEncoding(UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .header("Content-Profile", "sakila")
                        .param("tsid", "director_id")
                        .param("tsidType", "number")
                        .content(ITestUtil.BULK_CREATE_DIRECTOR_REQUEST))
                .andExpect(status().isCreated())
                //.andDo(print())
                .andDo(document("mysql-bulk-create-directors"));

    }

    @Test
    @DisplayName("Create many directors with wrong tsid type.")
    void createDirectorWithWrongTsidType() throws Exception {

        mockMvc.perform(post("/director/bulk")
                        .characterEncoding(UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .param("tsid", "director_id")
                        .param("tsidType", "string")
                        .header("Content-Profile", "sakila")
                        .content(ITestUtil.BULK_CREATE_DIRECTOR_BAD_REQUEST))
                .andExpect(status().isBadRequest())
                //.andDo(print())
                .andDo(document("mysql-bulk-create-directors-with-wrong-tsid-type"));

    }

    @Test
    @DisplayName("Create reviews with default tsid type.")
    void createReviewWithDefaultTsidType() throws Exception {

        mockMvc.perform(post("/review/bulk")
                        .characterEncoding(UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .header("Content-Profile", "sakila")
                        .param("tsid", "review_id")
                        .content(ITestUtil.BULK_CREATE_REVIEW_REQUEST))
                .andExpect(status().isCreated())
                //.andDo(print())
                .andDo(document("mysql-bulk-create-reviews-with-default-tsid-type"));

    }

}
