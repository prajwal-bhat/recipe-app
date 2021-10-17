package com.bhat.omnicell.challenge.recipe.util;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapperUtil {

    @Autowired
    private ModelMapper modelMapper;

    public Recipe dtoToEntity(RecipeDto dto){
        Recipe recipe = modelMapper.map(dto, Recipe.class);
        return recipe;
    }

    public RecipeDto entityToDto(Recipe entity){
        RecipeDto dto = modelMapper.map(entity, RecipeDto.class);
        return dto;
    }
}
