package com.bhat.omnicell.challenge.recipe.repo;

import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

    @Override
    List<Recipe> findAll();
}
