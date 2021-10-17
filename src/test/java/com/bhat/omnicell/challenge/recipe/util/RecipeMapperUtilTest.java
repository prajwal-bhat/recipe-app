package com.bhat.omnicell.challenge.recipe.util;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RecipeMapperUtilTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testModelMapperToEntity(){
        RecipeDto dto = new RecipeDto(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");
        Recipe entity = modelMapper.map(dto, Recipe.class);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getCategory(), dto.getCategory());
        assertEquals(entity.getImage(), dto.getImage());
        assertEquals(entity.getPrice(), dto.getPrice());
    }

    @Test
    public void testModelMapperToDto(){
        Recipe entity = new Recipe(1L, "Uthappizza", "https://i.imgur.com/tDnjTXf.jpg", "mains", "Hot", "4.99", "A unique combination of Indian Uthappam (pancake) and Italian pizza");
        RecipeDto dto = modelMapper.map(entity, RecipeDto.class);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getCategory(), dto.getCategory());
        assertEquals(entity.getImage(), dto.getImage());
        assertEquals(entity.getPrice(), dto.getPrice());
    }

}