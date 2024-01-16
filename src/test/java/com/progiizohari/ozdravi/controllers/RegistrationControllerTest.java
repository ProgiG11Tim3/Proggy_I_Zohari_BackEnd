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
                "  \"oib\": \"12345678910\",\n" +
                "  \"nameParent\": \"Andrej\",\n" +
                "  \"lastNameParent\": \"Panković\",\n" +
                "  \"dateOfBirthParent\": \"1970-04-08\",\n" +
                "  \"usernameParent\": \"najOsoba\",\n" +
                "  \"passwordParent\": \"najOsoba\",\n" +
                "  \"phoneNumberParent\": \"0991234567\",\n" +
                "  \"emailParent\": \"andrej.pankovic@yahoo.hr\",\n" +
                "  \"postalCode\": \"10000\",\n" +
                "  \"placeOfResidence\": \"Zagreb\",\n" +
                "  \"employerEmail\": \"kebabShop@gmail.hr\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void neUspjesnoRegistriranjeJerNekiOdPodatakaNijeUskladuSaBazinimRestrikcijama() throws Exception {
        String jsonPayload = "{\n" +
                "  \"oib\": \"0\",\n" +
                "  \"nameParent\": \"Andrej\",\n" +
                "  \"lastNameParent\": \"Panković\",\n" +
                "  \"dateOfBirthParent\": \"1970-04-08\",\n" +
                "  \"usernameParent\": \"najOsoba\",\n" +
                "  \"passwordParent\": \"najOsoba\",\n" +
                "  \"phoneNumberParent\": \"0991234567\",\n" +
                "  \"emailParent\": \"andrej.pankovic@yahoo.hr\",\n" +
                "  \"postalCode\": \"10000\",\n" +
                "  \"placeOfResidence\": \"Zagreb\",\n" +
                "  \"employerEmail\": \"kebabShop@gmail.hr\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}