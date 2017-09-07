/*
 Project Five Fraction Calculator
 */

import java.util.*;

public class FractionCalculator {
    public static void main(String[] args){
        //Create a new Scanner object
        Scanner input = new Scanner(System.in);

        //Call method to greet the user
        greetings();

        String operator;

        do{
            operator = getOperation(input);
            if (operator.equalsIgnoreCase("q")){
                System.exit(0);
            }
            Fraction FracA = getFraction(input);
            Fraction FracB = getFraction(input);
            switch (operator){
                case "+":
                        System.out.println(FracA + " " + operator + " " + FracB + " = " + FracA.add(FracB));
                    break;
                case "-":
                        System.out.println(FracA + " " + operator + " " + FracB + " = " + FracA.subtract(FracB));
                    break;
                case "*":
                        System.out.println(FracA + " " + operator + " " + FracB + " = " + FracA.multiply(FracB));
                    break;
                case "/":
                        System.out.println(FracA + " " + operator + " " + FracB + " = " + FracA.divide(FracB));
                    break;
                case "=":
                    System.out.println(FracA + " " + operator + " " + FracB + " is " + FracA.equals(FracB));
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------------------------\n");
        } while (!operator.equalsIgnoreCase("q"));




    }

    private static void greetings(){
        //Inform the user the proper usage and purpose
        System.out.println("\nThis program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions.\nUse Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");
        System.out.println("--------------------------------------------------------------------------\n");
    }

    private static String getOperation(Scanner input){
        System.out.print("Please enter an operation (+, -, *, /, = or Q to quit): ");
        while(!input.hasNext("[+-/*=qQ]")){
            System.out.print("Invalid input (+, -, *, /, = or Q to quit): ");
            input.next();
        }
        String operator = input.next();
        input.nextLine();
        return operator;
    }

    private static Fraction getFraction(Scanner input){
        Fraction newFrac = null;
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String firstFrac = input.nextLine();
        while (!validFraction(input, firstFrac)){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integer and b is not zero: ");
            firstFrac = input.nextLine();
        }
        for (int i = 0; i < firstFrac.length(); i++){
            if (firstFrac.charAt(i) == '/'){
                int numerator = Integer.parseInt(firstFrac.substring(0, i));
                int denominator = Integer.parseInt(firstFrac.substring(i + 1));
                newFrac = new Fraction(numerator, denominator);
                return newFrac;
            }
        }
        int wholeNum = Integer.parseInt(firstFrac);
        newFrac = new Fraction(wholeNum);
        return newFrac;
    }

    private static boolean validFraction(Scanner input, String FracNum){
        int  oneChar = 0;
        boolean truNume = false, truDeno = false;
        for (int i = 0; i < FracNum.length(); i++){
            if (oneChar == 2){
                return false;
            }
            else {
                if (FracNum.charAt(i) == '/'){
                    oneChar++;
                    String numerator = FracNum.substring(0, i);
                    truNume = isNum(numerator);
                    String denominator = FracNum.substring(i + 1);
                    truDeno = isNum(denominator);

                }
            }
        }
        if (oneChar == 0){
           return isNum(FracNum);
        }
        return (truNume && truDeno);
    }

    private static boolean isNum(String num){
        if (num.startsWith("-")){
            num = num.substring(1);
            if (num.matches("[0-9]+")){
                return true;
            }

        }
        else {
            if (num.matches("[0-9]+")){
                return true;
            }
        }
        return false;
    }

}
