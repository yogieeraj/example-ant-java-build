/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microchip.examplelibrary;

import com.microchip.examplelibrary.modules.example.ExampleModule;
import com.microchip.mcc.core.device.DeviceDescription;
import com.microchip.mcc.core.library.ALibrary;
import com.microchip.mcc.core.module.IModule;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This method returns a list of all the modules which this library supports
 * which are compatible with the device passed in. If you want to work with all
 * devices then just instantiate your module and return the instance.
 *
 * You can also check the device description to determine if your library is
 * compatible with this device and only return an instance of the modules which
 * are compatible with the device supplied.
 *
 * @author C14674
 */
public class ExampleLibrary extends ALibrary {

    @Override
    public Collection<IModule> getModules(DeviceDescription device) {
        ArrayList<IModule> modules = new ArrayList<>();
        // Uncomment the following lines to add your module to the MCC GUI
        // Make sure the module class name is correct when instantiating the instance
        // Add your modules to the list of modules suppported by this library
        ExampleModule newModule = new ExampleModule();
        modules.add(newModule);

        return modules;
    }

}
