package com.homihq.db2rest.rest;

import com.homihq.db2rest.MySQLBaseIntegrationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MySQLReadControllerTest extends MySQLBaseIntegrationTest {
    @Test
    @Disabled  // TODO: Need to fix
    @DisplayName("Get all fields.")
    void findAllFilms() throws Exception {

        mockMvc.perform(get("/film")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Accept-Profile", "sakila"))
                .andExpect(status().isOk())
                //.andDo(print())
                .andDo(document("mysql-get-all-films"));
    }

    @Test
    @DisplayName("Get count")
    void findFilmCount() throws Exception {
        mockMvc.perform(get("/film/count")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andDo(print())
                .andDo(document("mysql-get-film-count"));

    }

    @Test
    @DisplayName("Get one")
    void findOneFilm() throws Exception {
        mockMvc.perform(get("/film/one")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("select", "description"))
                .andExpect(status().isOk())
                //.andDo(print())
                .andDo(document("mysql-get-on-film"));
    }
}
