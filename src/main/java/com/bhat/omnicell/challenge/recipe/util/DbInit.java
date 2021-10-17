package com.bhat.omnicell.challenge.recipe.util;

import com.bhat.omnicell.challenge.recipe.model.entity.Recipe;
import com.bhat.omnicell.challenge.recipe.repo.RecipeRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@NoArgsConstructor
@Component
public class DbInit {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RecipeMapperUtil recipeMapperUtil;

    @PostConstruct
    public void runAfterObjectCreated() {
        log.info("Database initiated");
        List<Recipe> recipeList = webClientBuilder.build()
                .get()
                .uri("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json")
                .retrieve()
                .bodyToFlux(Recipe.class)
                .collectList()
                .block();
        recipeRepository.saveAll(recipeList);
    }

}
