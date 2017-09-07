/*
    Fraction object
 */

import javax.management.ObjectInstance;
import java.math.*;
public class Fraction {
    private int numerator;
    private int denominator;

    //Constructors

    //Constructor that accepts two parameters to initialize denominator and numerator
    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            throw new IllegalArgumentException();
        }
        else if (numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        }
        else if (numerator > 0 && denominator < 0){
            this.numerator = numerator * -1;
            this.denominator = Math.abs(denominator);
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    //Second constructor that accepts only numerator and set denominator to 1
    public Fraction(int numerator){
        this(numerator, 1);
    }

    //Third constructor that accepts nothing, sets numerator to 0 and denominator to 1
    public Fraction(){
        this(0, 1);
    }

    //Start of Object's methods

    //Returns de value of the numerator
    public int getNumerator(){
        return this.numerator;
    }

    //Returns the value of the denominator
    public int getDenominator(){
        return this.denominator;
    }

    //Converts the fraction to a string
    public String toString(){
        if (this.denominator == 1){
            return "" + numerator;
        }
        else {
            return this.numerator + "/" + this.denominator;
        }
    }

    //Returns the division with decimals
    public double toDouble(){
        return numerator/denominator;
    }

    //Adds two fractions
    public Fraction add(Fraction other){
        int otherNumerator = other.numerator * this.denominator;
        int numerator = this.numerator * other.denominator;
        numerator += otherNumerator;
        int denominator = other.denominator * this.denominator;
        Fraction addFrac = new Fraction(numerator, denominator);
        addFrac.toLowestTerms();
        return addFrac;
    }

    //Subtracts two fractions
    public Fraction subtract(Fraction other){
        int otherNumerator = other.numerator * this.denominator;
        int numerator = this.numerator * other.denominator;
        numerator -= otherNumerator;
        int denominator = other.denominator * this.denominator;
        Fraction subFrac = new Fraction(numerator, denominator);
        subFrac.toLowestTerms();
        return subFrac;
    }

    //Multiply two fractions
    public Fraction multiply(Fraction other){
        int numerator = this.numerator * other.numerator;
        int denominator = other.denominator * this.denominator;
        Fraction mulFrac = new Fraction(numerator, denominator);
        mulFrac.toLowestTerms();
        return mulFrac;
    }

    //Divides two fractions
    public Fraction divide(Fraction other){
        if (this.numerator == 0){
            throw new IllegalArgumentException("Can not divide by 0");
        }
        int numerator = this.numerator * other.denominator;
        int denominator = other.numerator * this.denominator;
        Fraction divideFrac = new Fraction(numerator, denominator);
        divideFrac.toLowestTerms();
        return divideFrac;
    }

    //Checks if two fractions are equal
    public boolean equals(Fraction other){
        if(this.numerator % other.numerator == 0){
            if(this.denominator % other.denominator == 0){
                return true;
            }
        }
        else if (other.numerator % this.numerator == 0){
            if(other.denominator % this.denominator  == 0){
                return true;
            }
        }
        return false;

    }

    public void toLowestTerms(){
        int divisor = gcd(this.numerator, this.denominator);
        this.numerator /= divisor;
        this.denominator /= divisor;
    }

    private static int gcd(int num, int den){
        while (num != 0 && den != 0){
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
}
