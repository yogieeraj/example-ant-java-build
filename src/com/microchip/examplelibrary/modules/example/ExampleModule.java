/*
 *  © 2018 Microchip Technology Inc. and its subsidiaries.  
 *
 *  You may use this software and any derivatives exclusively with Microchip products. 
 *
 *  THIS SOFTWARE IS SUPPLIED BY MICROCHIP "AS IS".  NO WARRANTIES, WHETHER EXPRESS, 
 *  IMPLIED OR STATUTORY, APPLY TO THIS SOFTWARE, INCLUDING ANY IMPLIED WARRANTIES OF 
 *  NON-INFRINGEMENT, MERCHANTABILITY, AND FITNESS FOR A PARTICULAR PURPOSE, OR ITS 
 *  INTERACTION WITH MICROCHIP PRODUCTS, COMBINATION WITH ANY OTHER PRODUCTS, OR USE 
 *  IN ANY APPLICATION. 
 *
 *  IN NO EVENT WILL MICROCHIP BE LIABLE FOR ANY INDIRECT, SPECIAL, PUNITIVE, INCIDENTAL 
 *  OR CONSEQUENTIAL LOSS, DAMAGE, COST OR EXPENSE OF ANY KIND WHATSOEVER RELATED TO 
 *  THE SOFTWARE, HOWEVER CAUSED, EVEN IF MICROCHIP HAS BEEN ADVISED OF THE POSSIBILITY 
 *  OR THE DAMAGES ARE FORESEEABLE.  TO THE FULLEST EXTENT ALLOWED BY LAW, MICROCHIP'S 
 *  TOTAL LIABILITY ON ALL CLAIMS IN ANY WAY RELATED TO THIS SOFTWARE WILL NOT EXCEED 
 *  THE AMOUNT OF FEES, IF ANY, THAT YOU HAVE PAID DIRECTLY TO MICROCHIP FOR THIS SOFTWARE.
 *
 *  MICROCHIP PROVIDES THIS SOFTWARE CONDITIONALLY UPON YOUR ACCEPTANCE OF THESE TERMS.
 */
package com.microchip.examplelibrary.modules.example;


import com.microchip.mcc.core.module.AModule;
import com.microchip.mcc.core.module.SupportLevel;
import com.microchip.mcc.core.moduleViewer.IModuleViewer;
import java.util.Optional;

public class ExampleModule extends AModule {

//    public ExampleModule() {
//        group = "Examples";
//        controllerClass = ExampleModuleController.class;
//        viewerClass = ExampleModuleViewer.class;
//    }
    
    @Override
    public IModuleViewer getViewer() {
        throw new UnsupportedOperationException("This module does not produce viewers using the legacy getViewer method.");
    }

    @Override
    public Optional<String> getShortDisplayName() {
        return Optional.of(getDisplayName());
    }

    @Override
    public int getSupportLevel() {
        return SupportLevel.GREEN;
    }
    
    @Override
    public String getGroup() {
        return "Examples";
    }

    @Override
    public String getDefaultCategory() {
        return "Examples/Calc";
    }

    @Override
    public String getDisplayName() {
        return "Calc";
    }

    @Override
    public String getName() {
        return "Calc"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
