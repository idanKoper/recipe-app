package com.koper.recipeapp.bootstrap;

import com.koper.recipeapp.model.*;
import com.koper.recipeapp.repositories.CategoryRepository;
import com.koper.recipeapp.repositories.RecipeRepository;
import com.koper.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipe());
    }


    private List<Recipe> getRecipe(){

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM not Found");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Excepted Category not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Excepted Category not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Guacamole
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");

        Notes guacamoleNote = new Notes();
        guacamoleNote.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"+
                "feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon.\n"+
                "The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole. \n" +
                "\n"+
                "\n"+
                "Read More: https://www.simplyrecipes.com/recipes/perfect_guacamole");
        guacamoleNote.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNote);

        guacamoleRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(0.25), teaSpoonUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tableSpoonUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoonUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUom,guacamoleRecipe));

        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacamoleRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacosRecipe.setCookTime(15);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n"+
                "\n"+
                "\n"+
                "Read More: https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos");
        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(1),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(0.5),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("boneless chicken thighs", new BigDecimal(6),eachUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8),cupUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("ripe avocados, sliced", new BigDecimal(2),eachUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4),eachUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("pint cherry tomatoes, halved", new BigDecimal(0.5),pintUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(0.25),pintUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(1),eachUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(0.5),pintUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(1),eachUom,tacosRecipe));

        recipes.add(tacosRecipe);
        return recipes;


    }

}
