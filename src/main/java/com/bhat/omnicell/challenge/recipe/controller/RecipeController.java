package com.bhat.omnicell.challenge.recipe.controller;

import com.bhat.omnicell.challenge.recipe.model.dtos.RecipeDto;
import com.bhat.omnicell.challenge.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity getAllRecipes(){
        return ResponseEntity.ok()
                .body(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecipe(@PathVariable("id") Long id){
        return ResponseEntity.ok()
                .body(recipeService.getRecipe(id));
    }

    @PostMapping
    public ResponseEntity addRecipe(@RequestBody RecipeDto dto){
        return ResponseEntity.ok()
                .body(recipeService.addRecipe(dto));
    }

    @GetMapping("/{id}/show")
    public ResponseEntity getRecipeImageUrl(@PathVariable("id") Long id){
        return ResponseEntity.ok()
                .body(recipeService.getRecipeImageUrl(id));
    }
}
