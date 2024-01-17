package com.progiizohari.ozdravi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uspjesnoRegistriranje() throws Exception {
        String jsonPayload = "{\n" +
                "  \"name\": \"Andrej\",\n" +
                "  \"surname\": \"Panković\",\n" +
                "  \"oib\": \"12345678910\",\n" +
                "  \"dateOfBirth\": \"1970-04-08\",\n" +
                "  \"placeOfResidence\": \"Zagreb\",\n" +
                "  \"postalCode\": \"10000\",\n" +
                "  \"phoneNumber\": \"0991234567\",\n" +
                "  \"emailAddress\": \"andrej.pankovic@yahoo.hr\",\n" +
                "  \"username\": \"najOsoba\",\n" +
                "  \"password\": \"najOsoba\",\n" +
                "  \"employerEmailAddress\": \"kebabShop@gmail.hr\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoRegistriranjeJerNekiOdPodatakaNijeUskladuSaBazinimRestrikcijama() throws Exception {
        String jsonPayload = "{\n" +
                "  \"name\": \"Andrej\",\n" +
                "  \"surname\": \"Panković\",\n" +
                "  \"oib\": \"0\",\n" +
                "  \"dateOfBirth\": \"1970-04-08\",\n" +
                "  \"placeOfResidence\": \"Zagreb\",\n" +
                "  \"postalCode\": \"10000\",\n" +
                "  \"phoneNumber\": \"0991234567\",\n" +
                "  \"emailAddress\": \"andrej.pankovic@yahoo.hr\",\n" +
                "  \"username\": \"najOsoba\",\n" +
                "  \"password\": \"najOsoba\",\n" +
                "  \"employerEmailAddress\": \"kebabShop@gmail.hr\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void pokusajRegistracijeVecPostojecegRoditelja() throws Exception {
        String jsonPayload = "{\n" +
                "  \"name\": \"Petra\",\n" +
                "  \"surname\": \"Horvat\",\n" +
                "  \"oib\": \"12345678901\",\n" +
                "  \"dateOfBirth\": \"1980-12-04\",\n" +
                "  \"placeOfResidence\": \"Zagreb\",\n" +
                "  \"postalCode\": \"10000\",\n" +
                "  \"phoneNumber\": \"0971234567\",\n" +
                "  \"emailAddress\": \"petra.horvat@gmail.com\",\n" +
                "  \"username\": \"petraHorvat\",\n" +
                "  \"password\": \"petraHorvat\",\n" +
                "  \"employerEmailAddress\": \"telekom@t-com.hr\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}