package com.koper.recipeapp.controllers;

import com.koper.recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        log.debug("Getting Index Page");
        return "index";
    }

}
