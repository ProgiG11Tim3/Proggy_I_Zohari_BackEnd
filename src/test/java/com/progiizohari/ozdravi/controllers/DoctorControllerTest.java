package com.progiizohari.ozdravi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uspjesnoUlogiravanje() throws Exception {
        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void ulogiravanjeSaKrivimPodacima() throws Exception {
        String jsonPayload = "{\n" +
                "  \"username\": \"kriviPodaci\",\n" +
                "  \"password\": \"kriviPodaci\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void uspjesnoDohvacanjeSvihPacijenata() throws Exception {
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getAllPatients")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoDohvacanjeSvihPacijenataZbogKrivihLoginPodataka() throws Exception {
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"kriviPodaci\",\n" +
                "  \"password\": \"kriviPodaci\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getAllPatients")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void uspjesnoDohvacanjePacijentaPoOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatient/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoDohvacanjePacijentaPoNeispravnomOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatient/00000000000")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void neUspjesnoDohvacanjePacijentaPoOIBjerNijeNjegovPacijent() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatient/34567890123")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void uspjesnoDohvacanjeKartonaPacijentaPoOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientRecord/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoDohvacanjeKartonaPacijentaPoNeispravnomOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientRecord/00000000000")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void pacijentNemaKartonPaSeStvaraNoviKarton() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"jelenaKovac\",\n" +
                "  \"password\": \"jelenaKovac\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientRecord/48249825043")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoDohvacanjeKartonaJerNijeNjegovPacijent() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientRecord/48249825043")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void neUspjesnoDohvacanjeKartonaJerSeDoktorIliPedijatarNijeUlogirao() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientRecord/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void neUspjesnoDohvacanjeNalazaJerSeDoktorIliPedijatarNijeUlogirao() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void neUspjesnoDohvacanjeNalazaJerNijeNjegovPacijent() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/48249825043")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void neUspjesnoDohvacanjeNalazaPacijentaPoNeispravnomOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/00000000000")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void uspjesnoDohvacanjeNalazaPacijentaPoOIB() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void pacijentNemaKartonPaSeStvaraNoviKartonISaljePraznaListaNalaza() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"jelenaKovac\",\n" +
                "  \"password\": \"jelenaKovac\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/48249825043")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void uspjesnoDohvacanjeNalaza() throws Exception{
        MockHttpSession session = new MockHttpSession();

        String jsonPayload = "{\n" +
                "  \"username\": \"anaIvanovic\",\n" +
                "  \"password\": \"anaIvanovic\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .session(session)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/getPatientReports/12345678901")
                        .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}










