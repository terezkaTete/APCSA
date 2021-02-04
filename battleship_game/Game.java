//skoro done, len dorobit break cyklu a mozno blbosti na zaciatok

public class Game {

    public static void main(String[] args) {

        System.out.println("This is battleship game.");
        // if you want rules, type rules, else start
        // set difficulty (normal or impossible haha)
        Human hrac1 = new Human();
        Computer hrac2 = new Computer();

        hrac1.makeTurn();
        int lastPlayer = 1;
        while(true){
            //chce to byt breaknute ked sa sunknu vsetky lode
            if(lastPlayer == 1){
                if(hrac1.succefulShot()){
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
}
