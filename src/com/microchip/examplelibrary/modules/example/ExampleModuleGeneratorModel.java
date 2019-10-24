/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microchip.examplelibrary.modules.example;

import com.microchip.mcc.core.generation.IGeneratable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author X00338
 */
public class ExampleModuleGeneratorModel {
    private ExampleModuleController controller;

    public ExampleModuleGeneratorModel(ExampleModuleController controller) {
        this.controller = controller;
    }
    
    protected ExampleModuleController getController() {
        return this.controller;
    }
     
    protected Collection<IGeneratable> getGeneratableItems(){
        List<IGeneratable>  listOfItemsToGenerate = new ArrayList<>();
        ExampleModuleGenerator   generator   = new ExampleModuleGenerator(getController());
        
        generator.setModule(controller.getModule());
       
        listOfItemsToGenerate.addAll(generator.getItems());  
        return listOfItemsToGenerate;
    }
}
