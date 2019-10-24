package com.microchip.examplelibrary.modules.example;

import com.microchip.examplelibrary.modules.example.ExampleModuleController.Add;
import com.microchip.examplelibrary.modules.example.ExampleModuleController.Div;
import com.microchip.examplelibrary.modules.example.ExampleModuleController.Mul;
import com.microchip.examplelibrary.modules.example.ExampleModuleController.Operand1;
import com.microchip.examplelibrary.modules.example.ExampleModuleController.Operand2;
import com.microchip.examplelibrary.modules.example.ExampleModuleController.Sub;
import com.microchip.mcc.core.annotation.MCCCustomToken;
import com.microchip.mcc.core.module.IModule;
import com.microchip.mcc.core.moduleViewer.BaseViewer;
import com.microchip.mcc.core.moduleViewer.IModuleViewer;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 *
 * @author X00338
 */
public class ExampleModuleViewer extends BaseViewer {

    public final static URL FXML_URL = ExampleModuleViewer.class.getResource("ExampleModuleView.fxml");

    public static IModuleViewer createViewer(IModule module, ClassLoader cl) {
        return BaseViewer.createViewer(new FXMLLoader(FXML_URL), cl);
    }
    
    @MCCCustomToken(Add.KEY_NAME)
    @FXML
    public TextField add;
    
    @MCCCustomToken(Sub.KEY_NAME)
    @FXML
    public TextField sub;
    
    @MCCCustomToken(Mul.KEY_NAME)
    @FXML
    public TextField mul;
    
    @MCCCustomToken(Div.KEY_NAME)
    @FXML
    public TextField div;
    
    @MCCCustomToken(Operand1.KEY_NAME)
    @FXML
    public TextField operand1;
    
    @MCCCustomToken(Operand2.KEY_NAME)
    @FXML
    public TextField operand2;

    @Override
    protected void initialiseView() {

    }

}
