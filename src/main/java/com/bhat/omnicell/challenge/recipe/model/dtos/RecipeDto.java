package com.bhat.omnicell.challenge.recipe.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private Long id;
    private String name;
    private String image;
    private String category;
    private String label;
    private String price;
    private String description;
}
