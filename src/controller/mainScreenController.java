package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class mainScreenController
{
    Random generator = new Random();

    boolean isSpecialSign;
    boolean isUpperCase;
    boolean isLowerCase;
    boolean isNumber;

    @FXML
    public void generatePassword()
    {
        String password = "";
        try {
            if (checkboxPrefix.isSelected()) password += getFix(Integer.parseInt(amountPrefix.getText()));
            password += textPassword.getText();
            if (checkboxPostfix.isSelected()) password += getFix(Integer.parseInt(amountPostfix.getText()));

            StringSelection selection = new StringSelection(password);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        } catch (Exception e) {
            password = "Błąd danych!";
        }

        labelPassword.setText(password);
        textResultPassword.setText(password);
        setSignToGenerate();
    }
    /**
     *  Tworzenie hasła
     */

    private String getFix(int amountOfSign)
    {
        String result = "";

        for(int i = amountOfSign; i > 0; i--)
        {
            result += getSign();
        }

        return result;
    }

    private String getSign()
    {
        String result = "0";

        int amountOfOpiton = 1;
        if(checkNumber.isSelected()) amountOfOpiton += 1;
        if(checkLowCase.isSelected()) amountOfOpiton += 1;
        if(checkUpperCase.isSelected()) amountOfOpiton += 1;
        if(checkSpecialSign.isSelected()) amountOfOpiton += 1;

        String[] option = new String[amountOfOpiton + 1];

        amountOfOpiton = 0;
        option[0] = "zero";
        if (checkNumber.isSelected()) {
            amountOfOpiton += 1;
            option[amountOfOpiton] = "Number";
        }
        if (checkLowCase.isSelected()) {
            amountOfOpiton += 1;
            option[amountOfOpiton] = "LowCase";
        }
        if (checkUpperCase.isSelected()) {
            amountOfOpiton += 1;
            option[amountOfOpiton] = "UpperCase";
        }
        if (checkSpecialSign.isSelected()) {
            amountOfOpiton += 1;
            option[amountOfOpiton] = "SpecialSign";
        }

        Random generator = new Random();

        int test = generator.nextInt(amountOfOpiton + 1);
        if(test == 0 && amountOfOpiton > 0) test ++;

        switch(option[test])
        {
            case "Number":{
                if(!isNumber){
                    isNumber = true;
                    result = getNumber();
                }
                else if(isAllSignNeeded()){
                    result = getNumber();
                }
                else{
                    result = getSignNeed();
                }
            }break;
            case "LowCase":{
                if(!isLowerCase){
                    isLowerCase = true;
                    result = getLower(getLetter());
                }
                else if(isAllSignNeeded()){
                    result = getLower(getLetter());
                }
                else{
                    result = getSignNeed();
                }
            }break;
            case "UpperCase":{
                if(!isUpperCase){
                    isUpperCase = true;
                    result = getLetter();
                }
                else if(isAllSignNeeded()){
                    result = getLetter();
                }
                else{
                    result = getSignNeed();
                }
            }break;
            case "SpecialSign":{
                if(!isSpecialSign){
                    isSpecialSign = true;
                    result = getSpecialSign();
                }
                else if(isAllSignNeeded()){
                    result = getSpecialSign();
                }
                else{
                    result = getSignNeed();
                }
            }break;

            default:{
                result = "0";
            }
        }

        return result;
    }

    private boolean isAllSignNeeded()
    {
        boolean result = false;
        if(isNumber && isLowerCase && isSpecialSign && isUpperCase) {
            result = true;
        }

        return result;
    }

    private String getSignNeed()
    {

        if(!isNumber){
            isNumber = true;
            return getNumber();
        }
        else if(!isUpperCase){
            isUpperCase = true;
            return getLetter();
        }
        else if(!isSpecialSign){
            isSpecialSign = true;
            return getSpecialSign();
        }
        else if(!isLowerCase){
            isLowerCase = true;
            return getLower(getLetter());
        }
        else return "0";
    }


    /**
     *  Generatory
     */

    private String getNumber()
    {
        int result = generator.nextInt(9);
        return Integer.toString(result);
    }

    private String getSpecialSign()
    {
        int rand = generator.nextInt(9);
        String sign = "!";

        switch (rand)
        {
            case 1:{
                sign = "@";
            }break;
            case 2:{

            }break;
            case 3:{
                sign = "#";
            }break;
            case 4:{
                sign = "$";
            }break;
            case 5:{
                sign = "%";
            }break;
            case 6:{
                sign = "^";
            }break;
            case 7:{
                sign = "*";
            }break;
            case 8:{
                sign = "-";
            }break;
            case 9:{
                sign = "+";
            }break;
        }

        return sign;
    }

    private String getLetter()
    {
        Random generate = new Random();
        String result = "A";

        switch (generate.nextInt(26))
        {
            case 1:{
                result = "A";
            }break;
            case 2:{
                result = "B";
            }break;
            case 3:{
                result = "C";
            }break;
            case 4:{
                result = "D";
            }break;
            case 5:{
                result = "E";
            }break;
            case 6:{
                result = "F";
            }break;
            case 7:{
                result = "G";
            }break;
            case 8:{
                result = "H";
            }break;
            case 9:{
                result = "I";
            }break;
            case 10:{
                result = "J";
            }break;
            case 11:{
                result = "K";
            }break;
            case 12:{
                result = "L";
            }break;
            case 13:{
                result = "M";
            }break;
            case 14:{
                result = "N";
            }break;
            case 15:{
                result = "O";
            }break;
            case 16:{
                result = "P";
            }break;
            case 17:{
                result = "R";
            }break;
            case 18:{
                result = "S";
            }break;
            case 19:{
                result = "T";
            }break;
            case 20:{
                result = "U";
            }break;
            case 21:{
                result = "V";
            }break;
            case 22:{
                result = "W";
            }break;
            case 23:{
                result = "X";
            }break;
            case 24:{
                result = "Y";
            }break;
            case 25:{
                result = "Z";
            }break;
            case 26:{
                result = "Q";
            }break;
        }
        return result;
    }

    private String getLower(String result)
    {
        return result.toLowerCase();
    }

    /**
     *  --------------
     */

    public void initialize()
    {
        amountPrefix.setText("0");
        amountPostfix.setText("5");

        checkboxPostfix.setSelected(true);
        checkSpecialSign.setSelected(true);
        checkUpperCase.setSelected(true);
        checkNumber.setSelected(true);
        checkLowCase.setSelected(true);

        textPassword.setText("Pwd");

        isUpperCase = true;
        isLowerCase = true;
        isNumber = true;
        isSpecialSign = true;

        setSignToGenerate();

        generatePassword();


    }

    @FXML
    public void setSignToGenerate()
    {
        if(checkLowCase.isSelected()) { isLowerCase = false; }
        if(checkSpecialSign.isSelected()) { isSpecialSign = false; }
        if(checkNumber.isSelected()) { isNumber = false; }
        if(checkUpperCase.isSelected()) { isUpperCase = false; }
    }


    @FXML
    Label labelPassword = new Label();

    @FXML
    CheckBox checkboxPrefix = new CheckBox();
    @FXML
    CheckBox checkboxPostfix = new CheckBox();
    @FXML
    CheckBox checkLowCase = new CheckBox();
    @FXML
    CheckBox checkUpperCase = new CheckBox();
    @FXML
    CheckBox checkNumber = new CheckBox();
    @FXML
    CheckBox checkSpecialSign = new CheckBox();

    @FXML
    TextField textPassword = new TextField();
    @FXML
    TextField amountPrefix = new TextField();
    @FXML
    TextField amountPostfix = new TextField();
    @FXML
    TextField textResultPassword = new TextField();
}
