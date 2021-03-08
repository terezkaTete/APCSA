package gcd;


public class Main {
    
    public static void main(String[] args) {
        int a; int b;
        a  = 10; b = 105;
        Gcd greatest = new Gcd();
        int result = greatest.find(a, b);
        System.out.println(result);
    }
}
