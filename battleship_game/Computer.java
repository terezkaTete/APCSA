//todo:strielanie, ak mam prave nejako nefinishnutu lodku
//     krajsi stack, ktory bude davat rozumnejsie guesses

import java.util.Random;
import java.util.Stack;

public class Computer extends Player{
    private Random rand = new Random();
    private boolean prvyTah = true;
    private int a,b; //position where it's going to shoot
    private int lastTurnA, lastTurnB;
    private Stack <Integer> stack1 = new Stack(); 
    private Stack <Integer> stack2 = new Stack();    
    private boolean vybuchnuta5 = false;
    private boolean vybuchnuta4 = true;

    public Computer(){

    }

    void makeTurn(){ //spravit joke superpocitac, ktory vzdy vsetko spravne uhadne, lebo k tomu bude mat pristup
        if(prvyTah){
            a = rand.nextInt(10); //+-1 ci ako?
            b = rand.nextInt(10);
            lastTurnA = a;
            lastTurnB = b;
            shoot(a,b);
        }
        else{
            if(uspesnaStrela && !potopilSomPraveLodku){ //viem celu mapu, co je kinda podvadzanie, ale psst

                if(momentalnaLodkaX.elementAt(0) == momentalnaLodkaX.elementAt(1)){

                }
                
                //checknut tie 4 policka naookolo - ak je jedno z nich uz 3, tak potom do toho opacneho smeru
                // pamatat si lodicku, ktoru strielam - prestat, iba ak je dostrielana, ak je zastrelena voda na jednej strane, tak streilat na druhu
            }
            else{
                if(potopilSomPraveLodku){
                    createNewStack();
                    potopilSomPraveLodku = false;
                }
                shoot(stack1.pop(), stack2.pop());
            }
        }
        //na zaciatku chcem uplne random strelit
        //ak som posledne strelila do lode, tak si to chcem pamatat
        //mam lode s dlzkou 2 az 5 - chcem strielat tak, aby som vytvorila mriezku
        //mriezka1 - strela, 3 volne, strela
        //mriezka2 - strela, volne, strela
    }

    void createNewStack(){
        //chcem ju creatnut, po tom, co zostrelim lod
        //prva chce byt na zaklade toho random spravena, ostatne uz normalne
        stack1.removeAllElements();
        stack2.removeAllElements();
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(whatsAt(i, j) == 0 ){//&& vybuchnuta4 && vybuchnuta5
                    if(i%2 == j%2){
                        stack1.push(i);
                        stack2.push(j);
                    }
                }
                else {//if(whatsAt(i, j) == 0){
                    //todo - nestrielat kazde druhe, ale medzera 3 medzi strelami
                }
            }
        }
    }
}
