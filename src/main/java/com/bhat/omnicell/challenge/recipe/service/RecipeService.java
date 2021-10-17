package com.bhat.omnicell.challenge.recipe.service;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> getAllRecipes();

    RecipeDto getRecipe(Long id);

    String addRecipe(RecipeDto dto);

    String getRecipeImageUrl(Long id);
}
