package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jdk.nashorn.api.tree.RegExpLiteralTree;

import java.util.Random;

public class mainScreenController
{
    Random generator = new Random();

    @FXML
    public void generatePassword()
    {
        String is = getNumber();
        is = getSpecialSign();
        String sis = getLetter();
        is = getLower(getLetter());

        labelPassword.setText(is);
    }

    /**
     *  --------------
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
        Random generate = new Random();

        if( (generate.nextInt(100) % 2) == 0 )
        {
            result = result.toLowerCase();
        }

        return result;
    }

    /**
     *  --------------
     */

    @FXML
    Label labelPassword = new Label();
}
