package com.koper.recipeapp.controllers;

import com.koper.recipeapp.model.Category;
import com.koper.recipeapp.model.UnitOfMeasure;
import com.koper.recipeapp.repositories.CategoryRepository;
import com.koper.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @RequestMapping({"","/","/index"})
    public String getIndex(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureRepositoryOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is: " + categoryOptional.get().getId());
        System.out.println("Unit Of Measure Id is: " + unitOfMeasureRepositoryOptional.get().getId());
        return "index";
    }

}
