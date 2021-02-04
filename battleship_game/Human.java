//skoro hotove, mozno trosku upravit vstup

import java.util.Scanner;

public class Human extends Player{
    private Scanner scan = new Scanner(System.in);
    private int a,b;

    public Human(){

    }

    void makeTurn(){ // choose where you want to strike
        System.out.println("Choose where you want to strike.");
        System.out.println("row:");
        a= scan.nextInt(); a--;
        System.out.println("column:");
        b= scan.nextInt(); b--;

        while(true){
            if(a <10 && b<10 && a>=0 && b>=0){
                if(super.whatsAt(a,b) == 0 || super.whatsAt(a,b) == 1){
                    shoot(a,b);
                    break;
                }
                else{
                    System.out.println("You already shot at this place, please choose a different one.");
                    System.out.println("row:");
                    a= scan.nextInt();
                    System.out.println("column:");
                    b= scan.nextInt();
                }
            }
            else{
                System.out.println("Not a coordinate on the board, please choose a number form 1 to 10.");
                System.out.println("row:");
                a= scan.nextInt();
                System.out.println("column:");
                b= scan.nextInt();
            }
        }
    }
}
