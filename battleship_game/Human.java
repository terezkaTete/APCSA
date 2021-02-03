import java.util.Scanner;

public class Human extends Player{
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

        while(true){
            if(super.whatsAt(a,b) == 0 || super.whatsAt(a,b) == 1){ //hmm
                super.shoot(a,b);
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
        
    }
}
