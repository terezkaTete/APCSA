import java.util.Scanner;

public class Player {
    private Scanner scan = new Scanner(System.in);
    private int a,b;
    //mozno ze player chce mat svoju boardu
    //chce vediet spravit tah
    public Player(){

    }
    void makeTurn(){ // choose where you want to strike
        System.out.println("Choose where you want to strike.");
        System.out.println("row:");
        a= scan.nextInt();
        System.out.println("column:");
        b= scan.nextInt();
    }
}
