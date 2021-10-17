package com.bhat.omnicell.challenge.recipe.service.impl;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import com.bhat.omnicell.challenge.recipe.repo.RecipeRepository;
import com.bhat.omnicell.challenge.recipe.util.RecipeMapperUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {
    @InjectMocks
    private RecipeServiceImpl recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeMapperUtil recipeMapperUtil;
    @Test
    void getAllRecipes() {
        Recipe recipe1 = new Recipe(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");
        Recipe recipe2 = new Recipe(2L, "Zucchipakoda", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipes);

        List<RecipeDto> recipeList = recipeService.getAllRecipes();
        assertEquals(2, recipeList.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void addRecipe() {
        RecipeDto recipe1 = new RecipeDto(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");
        recipeService.addRecipe(recipe1);
        verify(recipeRepository, times(1)).save(recipeMapperUtil.dtoToEntity(recipe1));
    }
}