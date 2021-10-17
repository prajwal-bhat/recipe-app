package com.bhat.omnicell.challenge.recipe.service.impl;

import com.bhat.omnicell.challenge.recipe.exception.ResourceNotFoundException;
import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import com.bhat.omnicell.challenge.recipe.repo.RecipeRepository;
import com.bhat.omnicell.challenge.recipe.service.RecipeService;
import com.bhat.omnicell.challenge.recipe.util.RecipeMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapperUtil recipeMapperUtil;

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipe -> recipeMapperUtil.entityToDto(recipe))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto getRecipe(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isPresent()){
            return recipeMapperUtil.entityToDto(recipeOptional.get());
        } else {
            throw  new ResourceNotFoundException("Recipe", "Id", id);
        }
    }

    @Override
    public String addRecipe(RecipeDto dto) {
        try{
            recipeRepository.save(recipeMapperUtil.dtoToEntity(dto));
            return "Saved";
        } catch (Exception e){
            throw new RuntimeException("Failed to save new Recipe");
        }
    }

    @Override
    public String getRecipeImageUrl(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isPresent()){
            log.info("Image Url fetched: " + recipeOptional.get().getImage());
            return recipeOptional.get().getImage();
        } else {
            throw  new ResourceNotFoundException("Recipe", "Id", id);
        }
    }
}
