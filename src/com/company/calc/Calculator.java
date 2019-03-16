package com.company.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {

    private Scanner scanner = new Scanner(System.in);
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();

    public void choseTheType() throws IOException {
        System.out.println("Please chose type of numbers: for Roman Numbers write \"roman\"," +
                " for Arabic Numbers write \"arabic\"");
        String typeOfNumbers = scanner.next();
        if (typeOfNumbers.equals("roman")){
            startForRoman();
        } else if (typeOfNumbers.equals("arabic")){
            startForArabic();
        }
    }

    private void startForArabic() throws IOException {
        /*System.out.println("Enter the first arabic value: ");
        double firstArabicValue = scanner.nextDouble();
        System.out.println("Enter the second arabic value: ");
        double secondArabicValue = scanner.nextDouble();
        System.out.println("Select the operation sign \"+\" for sum, " +
                "\"-\" for minus, \"*\" for multiplication, \"/\" for division: ");
        String operationSign = scanner.next();
        calculatedResult(firstArabicValue, secondArabicValue, operationSign);*/

        System.out.println("Please Enter Your expression in format (first Double number(0.0) math operation " +
                           "(+, -, /, *) second Double number(0.0))");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expressionLine = bufferedReader.readLine();
        System.out.println("Result of your expression is: " + EvaluateString.evaluate(expressionLine));
    }

    private void startForRoman() {
        System.out.println("Enter the first roman value: ");
        String firstValue = scanner.next();
        System.out.println("Enter the second roman value: ");
        String secondValue = scanner.next();
        System.out.println("Select the operation sign \"+\" for sum, " +
                "\"-\" for minus, \"*\" for multiplication, \"/\" for division: ");
        String operationSign = scanner.next();
        calculatedResult(romanToArabicConverter.romanToDecimal(firstValue),
                romanToArabicConverter.romanToDecimal(secondValue), operationSign);
    }

    private double calculatedResult(double firstValue, double secondValue, String operationSing) {
        double result;
        switch (operationSing) {
            case "+":
                result = firstValue + secondValue;
                System.out.println("The result is: " + result);
                break;
            case "-":
                result = firstValue - secondValue;
                System.out.println("The result is: " + result);
            break;
            case "/":
                result = firstValue / secondValue;
                System.out.println("The result is: " + result);
            break;
            case "*":
                result = firstValue * secondValue;
                System.out.println("The result is: " + result);
            break;
            default:
                System.out.println("Not correct type");
                return 0;
        }
        return result;
    }
}
