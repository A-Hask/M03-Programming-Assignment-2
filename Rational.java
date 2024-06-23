import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational>{
    //Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;


    //Construct a rational with default properties
    public Rational(){
        this(BigInteger.ZERO,BigInteger.ONE);
    }

    //Construct a rational with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator){
        BigInteger gcd = gcd(numerator,denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.valueOf(-1)).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    //find GCD of two numbers
    private static BigInteger gcd (BigInteger n, BigInteger d) {
        return n.gcd(d);
    }

    //return numerator
    public BigInteger getNumerator(){
        return numerator;
    }

    //return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    //add a rational number to this rational
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator).multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    //Subtract a rational number from this rational
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator).multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    //multiply a rational number by this rational
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    //divide a rational number by this rational
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n,d);
    }

    @Override
    public String toString(){
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else 
            return numerator + "/" + denominator;
    }

    // Override the equals method in the Object class
    @Override
    public boolean equals(Object other) {
        return this.subtract((Rational) other).getNumerator().equals(BigInteger.ZERO);
    }

    // Implement the abstract intValue method in Number
    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        return this.subtract(o).getNumerator().compareTo(BigInteger.ZERO);
    }

    public static void main (String[] args){
        //Data fields for numerator and denominator
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first rational number: ");
        BigInteger numerator1 = sc.nextBigInteger();
        BigInteger denominator1 = sc.nextBigInteger();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the second rational number: ");
        BigInteger numerator2 = sc2.nextBigInteger();
        BigInteger denominator2 = sc2.nextBigInteger();

        Rational r1 = new Rational(numerator1, denominator1);
        Rational r2 = new Rational(numerator2, denominator2);
        
        System.out.println(r1.add(r2));
        System.out.println(r1.subtract(r2));
        System.out.println(r1.multiply(r2));
        System.out.println(r1.divide(r2));



}
}
