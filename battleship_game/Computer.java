import java.util.Random;


public class Computer extends Player{
    private Random rand = new Random();
    private boolean prvyTah = true;
    private int a,b;
    private int lastTurnA, lastTurnB;
    

    public Computer(){

    }

    void makeTurn(){ //spravit joke superpocitac, ktory vzdy vsetko spravne uhadne, lebo k tomu bude mat pristup
        if(prvyTah){
            a = rand.nextInt(10);
            b = rand.nextInt(10);
            lastTurnA = a;
            lastTurnB = b;
            shoot(a,b);
        }
        else{
            if(uspesnaStrela == true){
                //viem celu mapu, co je kinda podvadzanie, ale psst
                //checknut tie 4 policka naookolo - ak je jedno z nich uz 3, tak potom do toho opacneho smeru
                // pamatat si lodicku, ktoru strielam - prestat, iba ak je dostrielana, ak je zastrelena voda na jednej strane, tak streilat na druhu
            }
        }
        //this is where the magic happens
        //na zaciatku chcem uplne random strelit
        //ak som posledne strelila do lode, tak si to chcem pamatat
        //mam lode s dlzkou 2 az 5 - chcem strielat tak, aby som vytvorila mriezku
        //mriezka1 - strela, 3 volne, strela
        //mriezka2 - strela, volne, strela
    }
}
