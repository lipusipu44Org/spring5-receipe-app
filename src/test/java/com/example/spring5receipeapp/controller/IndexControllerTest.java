package com.example.spring5receipeapp.controller;

import com.example.spring5receipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String index=indexController.getIndexPage(model);
        assertEquals("index",index);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("receipes"),anySet());
    }
}