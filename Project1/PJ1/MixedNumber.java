package PJ1;
// Melissa Estrada CSC 220 MW 8:00 am

/**
 *********************************************************************************
 *
 * This class represents a mixed number which consist of sign (+ or -),integer 
 * and fraction parts of a number. Example: -10 3/5, 0 1/2, -0 3/4, 4 5/6
 * 
 * Requirements:
 * 1. Implement interfaces: MixedNumberInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Must work for both positive and negative mixed numbers
 *    Example: -3 5/6, -3 -5/-6, 0 -4/5, 0 4/-5
 *             are valid mixed numbers, all with sign '-'
 *             -3 -5/6, 3 -4/5, 3 4/-5 are invalid mixed numbers
 * 4. Must reduce to mixed number to lowest term, e.g. -3 14/4 --> -6 1/2 
 * 5. Must reduce result mixed number to lowest term for operations 
 *    add, subtract, multiply and divide, e.g. see test cases
 * 6. For input such as -2 -3/-10,  2 -3/-10 and 0 -4/-5 must convert them to 
 *    -2 3/10, 2 3/10 and 0 4/5 respectively 
 * 7. Must throw only Project1Exception in case of errors or invalid mixed numbers
 * 8. Must not add new or modify existing data fields
 * 9. Must not add new public methods
 * 10.May add private methods
 *
 * Hints:
 *
 * 1. You need to downcast reference parameter MixedNumberInterface to 
 *    MixedNumber if you want to use it as MixedNumber. 
 *    See add, subtract, multiply and divide methods
 *
 * 2. You need to downcast reference parameter FractionInterface to Fraction if  
 *    you want to use it as Fraction. 
 *
 * 3. Use "this" to access this object if it is needed
 *
 * 4. Use given Fraction class to simplify MixedNumber class implementations
 *    4.1 Fraction class always reduce fraction object to lowest term. 
 *        12/8 --> 3/2
 *    4.2 Fraction class always set denominator to > 0 and 
 *        numerator to +/- values.  Example: 3/-2 or -3/2 --> -3/2
 *    4.3 Look at Fraction interface for operations
 *    4.4 Additional Operations:
 *
 *        public Fraction()
 *        public Fraction(int num, int den)
 *        public boolean equals(Object other)
 *        public int compareTo(Fraction other)
 *        public String toString()    
 *
 ************************************************************************************/




public class MixedNumber implements MixedNumberInterface, Comparable<MixedNumber>
{
        // Fields:

    // both integer and fraction parts are forced to >= 0
    // sign of a mixed number is stored as '+' or '-'
    private char sign;      // '+' or '-'
    private int  integerPart;  // whole number portion >= 0
    private FractionInterface fraction; // fraction portion in lowest terms >= 0
    public int integer;

        // Methods:

    public MixedNumber()
    {
        setMixedNumber(0, 0, 1);
    }   // end default constructor


    public MixedNumber(int integerPart, int fractionNumerator, 
               int fractionDenominator)
    {
        setMixedNumber(integerPart, fractionNumerator, fractionDenominator);
    }   // end constructor

    public MixedNumber(int integerPart, FractionInterface fractionPart)
    {
        setMixedNumber(integerPart, fractionPart);
        
    }   // end constructor


    public void setMixedNumber(int integerPart, FractionInterface fractionPart)
    {
                // add statements
                // set this object to the given values
                // make sure to reduce to lowest term
                // check for exception cases
                this.integer = integerPart;
                Fraction f = (Fraction)fractionPart;
                this.fraction = new Fraction(f.getNumerator(), f.getDenominator());
                reduceToLowestForm();
                adjustSigns();
        }       // end setMixedNumber


    // check for exception cases
    public void setMixedNumber(int integerPart, 
        int fractionNumerator, int fractionDenominator)
    {
                // add statements
                // set this object to the given values
                // make sure to reduce to lowest term
                // check for exception cases
                this.integer = integerPart;
                this.fraction = new Fraction(fractionNumerator, fractionDenominator);
                reduceToLowestForm();
                adjustSigns();
        }       // end setMixedNumber

    public int getIntegerPart()
    {
                // add statements
            // retrieve integer portion with correct (+ or -) sign 
        if(sign == '+')
        {
         return this.integer;   
        }
        else
        {
          return - this.integer;
          }
           // return fraction;
    }   // end getInteger

    public FractionInterface getFractionPart()
    {
                // add statements
            // retrieve fraction portion, always + sign
        return fraction;
    }   // end getFraction

    public MixedNumberInterface addMixedNumber(MixedNumberInterface operand)
    {
                // add statements
                // convert MixedNumber object to Fraction object
                // Use Fraction's add() method to obtain Fraction result
                // convert result to a new lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
                Fraction fraction1 = (Fraction)this.getFractionalEquivalent();
                Fraction fraction2 = (Fraction)((MixedNumber)operand).getFractionalEquivalent();
                FractionInterface result = fraction1.add(fraction2);
                
                return new MixedNumber(0, result); // change it
        } // end add


    public MixedNumberInterface subtractMixedNumber(MixedNumberInterface operand)
    {
                // add statements
                // convert MixedNumber object to Fraction object
                // Use Fraction's substrct() method to obtain Fraction result
                // convert result to a new lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
                Fraction fraction1 = (Fraction)this.getFractionalEquivalent();
                Fraction fraction2 = (Fraction)((MixedNumber)operand).getFractionalEquivalent();
                FractionInterface result = fraction1.subtract(fraction2);
                return new MixedNumber(0, result); // change it
    }   // end subtract

    public MixedNumberInterface multiplyMixedNumber(MixedNumberInterface multiplier)
    {
                // add statements
        // convert MixedNumber objects to Fraction objects
        // Use Fraction's multiply() method to obtain Fraction result
        // convert result to lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
                Fraction fraction1 = (Fraction)this.getFractionalEquivalent();
                Fraction fraction2 = (Fraction)((MixedNumber)multiplier).getFractionalEquivalent();
                FractionInterface result = fraction1.multiply(fraction2);
                return new MixedNumber(0, result); // change it
    }   // end multiply

    public MixedNumberInterface divideMixedNumber(MixedNumberInterface divisor)
    {
                // add statements
        // convert MixedNumber objects to Fraction objects
        // Use Fraction's divide() method to obtain Fraction result
            // convert result to lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
                Fraction fraction1 = (Fraction)this.getFractionalEquivalent();
                Fraction fraction2 = (Fraction)((MixedNumber)divisor).getFractionalEquivalent();
                FractionInterface result = fraction1.divide(fraction2);
                return new MixedNumber(0, result); // change it
    }   // end divide


    public boolean equals(Object other)
    {
                // add statements
                // possible solution:
                // convert MixedNumber objects to Fraction objects
                // Use Fraction's equals() method to obtain boolean result
                if ((other == null) || (getClass() != other.getClass()))
                return false; // change it
                
                MixedNumber otherMixedNumber = (MixedNumber) other;
                
                if(this.fraction.equals(otherMixedNumber.fraction)&& this.integer == otherMixedNumber.integer)
                { return true;
                }
                return false;
      } // end if


    public int compareTo(MixedNumber other)
    {
                // add statements
                // possible solution:
                // convert MixedNumber objects to Fraction objects
                // Use Fraction's compareTo() method to obtain result
                Fraction fraction1 = (Fraction)this.getFractionalEquivalent();
                Fraction fraction2 = (Fraction)other.getFractionalEquivalent();
                return fraction1.compareTo(fraction2); // change it
    } // end compareTo

    public String toString()
    {
                // possible solution:
                // together with sign, integer and Fraction's toString() method
                // to obtain string value
                // add statements
                return String.valueOf(this.sign)+this.integer+" "+this.fraction; // change it
    } // end toString

    
    // Useful private methods:

    // reduce this MixedNumber object to lowest term MixedNumber 
        // object. E.g. 0 -50/7 --> -7 1/7; 4 25/8 --> 7 1/8
    private void reduceToLowestForm()
    {
                int num = Math.abs(this.fraction.getNumerator());
                int den = Math.abs(this.fraction.getDenominator());
                int integerPart = Math.abs(this.integer);
                int newNum = (den* integerPart)+num;
                int quot = newNum / den;
                int rem = newNum % den;
                this.integer = quot;
                this.fraction = new Fraction(rem, den);
                
    }   // end reduceToLowestForm


    // convert this MixedNumber object to a new Fraction object
        // object. E.g. -7 1/7 --> -50/7;  3 1/8 --> 25/8
    private FractionInterface getFractionalEquivalent()
    {
                int num = Math.abs(this.fraction.getNumerator());
                int den = Math.abs(this.fraction.getDenominator());
        return new Fraction((den * integerPart) + num,den);
    }   // end getFractionalEquivalent

   
    private void adjustSigns()
    {
       if (((integer < 0) && (fraction.getSign()=='-')) || ((integer > 0) && (fraction.getSign()=='+')))
       {
           sign = '+';
       }
       else if (((integer <0)&& (fraction.getSign() == '+')) || ((integer > 0) && (fraction.getSign() == '-')))
       {
           sign = '-';
       }
        }
    
} // end MixedNumber

