package com.microchip.examplelibrary.modules.example;

import com.microchip.mcc.core.annotation.MCCOnSetFunction;
import com.microchip.mcc.core.moduleController.BaseSoftwareController;
import com.microchip.mcc.core.tokenManager.BaseCustomKeyDefinition;
import com.microchip.mcc.core.tokenManager.ITokenKey;

/**
 *
 * @author X00338
 */
public class ExampleModuleController extends BaseSoftwareController  {

    public ExampleModuleController myController;
    
    protected final BaseCustomKeyDefinition add = new Add();
    protected final BaseCustomKeyDefinition sub = new Sub();
    protected final BaseCustomKeyDefinition mul = new Mul();
    protected final BaseCustomKeyDefinition div = new Div();
    protected final BaseCustomKeyDefinition operand1 = new Operand1();
    protected final BaseCustomKeyDefinition operand2 = new Operand2();

    
    public ExampleModuleController getController()
    {
        return this;
    }

    @Override
    protected void createCustomKeys() {
        add.createKey(getTokenManager());
        sub.createKey(getTokenManager());
        mul.createKey(getTokenManager());
        div.createKey(getTokenManager());
        operand1.createKey(getTokenManager());
        operand2.createKey(getTokenManager());
    }
    

    @Override
    protected void load() {
        super.load();
    }
    
    @MCCOnSetFunction(custom = Operand1.KEY_NAME)
    public void handleOperand1(ITokenKey key) {
        String num1 = tokenStore.getValue(key);
        String num2 = operand2.getValue();
        handleOperation(num1, num2);

    }

    @MCCOnSetFunction(custom = Operand2.KEY_NAME)
    public void handleOperand2(ITokenKey key) {
        String num2 = tokenStore.getValue(key);
        String num1 = operand1.getValue();
        handleOperation(num1, num2);
    }
    
    private void handleOperation(String num1, String num2) {
        double intNum1 = Double.parseDouble(num1);
        double intNum2 = Double.parseDouble(num2);
        double sum = addition(intNum1, intNum2);
        double diff = substraction(intNum1, intNum2);
        double multi = multiplication(intNum1, intNum2);
        double divi  = 0.0;
        if (intNum2 != 0) {
            divi = division(intNum1, intNum2);
        }

        String result = Double.toString(sum);
        tokenStore.setValue(add.getKey(), result);
        result = Double.toString(diff);
        tokenStore.setValue(sub.getKey(), result);
        result = Double.toString(multi);
        tokenStore.setValue(mul.getKey(), result);
        result = Double.toString(divi);
        tokenStore.setValue(div.getKey(), result);

    }
    
    
    protected double addition(double num1, double num2)
    {
        return num1+num2;
    }
    
    protected double substraction(double num1, double num2)
    {
        return num1-num2;
    }
    
    protected double multiplication(double num1, double num2)
    {
        return num1*num2;
    }
    
    protected double division(double num1, double num2) {
        return num1 / num2;
    }
    

    
    public static class Operand1 extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "operand1";
        public static final String DEFAULT = "0";

        public Operand1() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
    
    public static class Operand2 extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "operand2";
        public static final String DEFAULT = "0";

        public Operand2() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
    
    public static class Add extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "add";
        public static final String DEFAULT = "0.0";

        public Add() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
    
    
    public static class Sub extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "sub";
        public static final String DEFAULT = "0.0";

        public Sub() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
    
    public static class Mul extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "mul";
        public static final String DEFAULT = "0.0";

        public Mul() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
    
    public static class Div extends BaseCustomKeyDefinition {

        public static final String KEY_NAME = "div";
        public static final String DEFAULT = "0.0";

        public Div() {
            super(KEY_NAME);
            this.setDefaultOption(DEFAULT);
        }
    }
     

}
