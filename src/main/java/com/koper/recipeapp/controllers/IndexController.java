package com.koper.recipeapp.controllers;

import com.koper.recipeapp.model.Category;
import com.koper.recipeapp.model.UnitOfMeasure;
import com.koper.recipeapp.repositories.CategoryRepository;
import com.koper.recipeapp.repositories.UnitOfMeasureRepository;
import com.koper.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }

}
