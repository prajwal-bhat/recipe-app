package com.bhat.omnicell.challenge.recipe.controller;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private RecipeService service;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetExample() throws Exception {
        RecipeDto recipeDto1 = new RecipeDto(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");
        RecipeDto recipeDto2 = new RecipeDto(2L, "Zucchipakoda", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");

        List<RecipeDto> recipeDtos = new ArrayList<>();
        recipeDtos.add(recipeDto1);
        recipeDtos.add(recipeDto2);
        Mockito.when(service.getAllRecipes()).thenReturn(recipeDtos);
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Uthappizza")))
                .andExpect(jsonPath("$[1].name", Matchers.equalTo("Zucchipakoda")));
    }

    @Test
    public void testAddRecipe() throws Exception {
        RecipeDto input = new RecipeDto(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");

        Mockito.when(service.addRecipe(input)).thenReturn("Saved");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(input))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Saved");
    }

}