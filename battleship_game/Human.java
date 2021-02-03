import java.util.Scanner;

public class Human{
    private Scanner scan = new Scanner(System.in);
    private int a,b;

    public Human(){

    }

    void makeTurn(){ // choose where you want to strike
        System.out.println("Choose where you want to strike.");
        System.out.println("row:");
        a= scan.nextInt();
        System.out.println("column:");
        b= scan.nextInt();
        check(a,b); //todo, tot moze by spolocne pre human aj pc
    }
}
