/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microchip.examplelibrary.modules.example;

import com.microchip.mcc.core.generation.BaseGenerator;
import com.microchip.mcc.core.generation.IGeneratable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author X00338
 */
public class ExampleModuleGenerator extends BaseGenerator {

    private Map<String, Object> mproperties = new HashMap<>();
    private final ExampleModuleController controller;

    public ExampleModuleGenerator(ExampleModuleController controller) {
        this.controller = controller;
    }

    public Collection<IGeneratable> getItems() {
        List<IGeneratable> listOfFilesToGenerate = new ArrayList<>();
        return listOfFilesToGenerate;
    }

    private ExampleModuleController getController() {
        return this.controller;
    }

    @Override
    protected void addModel(Map<String, Object> properties) {
        super.addModel(properties);
        properties.putAll(mproperties);
    }

    public void addItem(String item, Object value) {
        mproperties.put(item, value);
    }

}
