import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

        System.out.println("This is a battleship game.");
        // if you want rules, type rules, else start
        // set difficulty (normal or impossible haha)
        Computer hrac2 = new Computer();
        Human hrac1 = new Human();

        hrac1.makeTurn();
        int lastPlayer = 1;
        while (true) {
            // chce to byt breaknute ked sa sunknu vsetky lode
            if(hrac1.jeSunknuteVsetko()){
                System.out.println("Congratulations, you won the game!");
                break;
            }
            if(hrac2.jeSunknuteVsetko()){
                System.out.println("Computer won the game! Better luck next time ;)");
                break;
            }
            spinkaj();
            if (lastPlayer == 1) {
                if (hrac1.succefulShot()) {
                    hrac1.makeTurn();
                }
                else{
                    hrac2.makeTurn();
                    lastPlayer = 2;
                }
            }
            else{
                if(hrac2.succefulShot()){
                    hrac2.makeTurn();
                }
                else{
                    hrac1.makeTurn();
                    lastPlayer = 1;
                }
            }
        }
    }
    static void spinkaj(){
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
