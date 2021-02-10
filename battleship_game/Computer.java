//todo:strielanie, ak mam prave nejako nefinishnutu lodku - asi done
//     krajsi stack, ktory bude davat rozumnejsie guesses - also randomiznut ho

import java.util.Random;
import java.util.Stack;

public class Computer extends Player{
    private Random rand = new Random();
    private boolean prvyTah = true;
    private int a,b; //position where it's going to shoot
    private Stack <Integer> stack1 = new Stack(); 
    private Stack <Integer> stack2 = new Stack();

    public Computer(){
        myBoard.printMe();
    }

    void makeTurn(){ //spravit joke superpocitac, ktory vzdy vsetko spravne uhadne, lebo k tomu bude mat pristup
        if(prvyTah){
            a = rand.nextInt(10); //+-1 ci ako?
            b = rand.nextInt(10);
            shoot(a,b);
            prvyTah = false;
            createNewStack();
        }
        else{            
            if(momentalnaLodkaX.size() > 0 && !potopilSomPraveLodku){ //predtym bola uspesnaStrela && !potopilSomPraveLodku
                if(momentalnaLodkaX.size() == 1){ //strialanie po prvom hite, ked este neviem ci je lodka vertikalna alebo horizontalna
                    boolean uzSomStrelila = false;
                    if(momentalnaLodkaY.elementAt(0)-1 >= 0){
                        if(whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)-1) != 2 
                        && whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)-1) != 3 ) {
                            shoot(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)-1);
                            uzSomStrelila = true;
                        }
                    }
                    if(momentalnaLodkaY.elementAt(0)+1 < 10 && !uzSomStrelila){
                        if(whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)+1) != 2 
                        && whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)+1) != 3 ) {
                            shoot(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(0)+1);
                            uzSomStrelila = true;
                        }
                    }
                    if(momentalnaLodkaX.elementAt(0)-1 >= 0 && !uzSomStrelila){
                        if(whatsAt(momentalnaLodkaX.elementAt(0)-1, momentalnaLodkaY.elementAt(0)) != 2 
                        && whatsAt(momentalnaLodkaX.elementAt(0)-1, momentalnaLodkaY.elementAt(0)) != 3 ) {
                            shoot(momentalnaLodkaX.elementAt(0)-1, momentalnaLodkaY.elementAt(0));
                            uzSomStrelila = true;
                        }
                    }
                    if(momentalnaLodkaX.elementAt(0)+1 < 10 && !uzSomStrelila){
                        if(whatsAt(momentalnaLodkaX.elementAt(0)+1, momentalnaLodkaY.elementAt(0)) != 2 
                        && whatsAt(momentalnaLodkaX.elementAt(0)+1, momentalnaLodkaY.elementAt(0)) != 3 ) {
                            shoot(momentalnaLodkaX.elementAt(0)+1, momentalnaLodkaY.elementAt(0));
                            uzSomStrelila = true;
                        }
                    }
                }
                else if(momentalnaLodkaX.elementAt(0) == momentalnaLodkaX.elementAt(1)){
                    for(int i=0;i<momentalnaLodkaY.size(); i++){
                        if(momentalnaLodkaY.elementAt(i)-1 >= 0){
                            if(whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)-1) != 2 
                            && whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)-1) != 3 ) {
                                shoot(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)-1);
                                break;
                            }
                        }
                        if(momentalnaLodkaY.elementAt(i)+1 < 10){
                            if(whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)+1) != 2 
                            && whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)+1) != 3 ) {
                                shoot(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i)+1);
                                break;
                            }
                        }
                    }
                }
                else{
                    for(int i=0;i<momentalnaLodkaX.size(); i++){
                        if(momentalnaLodkaX.elementAt(i)-1 >= 0){
                            if(whatsAt(momentalnaLodkaX.elementAt(i)-1, momentalnaLodkaY.elementAt(0)) != 2 
                            && whatsAt(momentalnaLodkaX.elementAt(i)-1, momentalnaLodkaY.elementAt(0)) != 3 ) {
                                shoot(momentalnaLodkaX.elementAt(i)-1, momentalnaLodkaY.elementAt(0));
                                break;
                            }
                        }
                        if(momentalnaLodkaX.elementAt(i)+1 < 10){
                            if(whatsAt(momentalnaLodkaX.elementAt(i)+1, momentalnaLodkaY.elementAt(0)) != 2 
                            && whatsAt(momentalnaLodkaX.elementAt(i)+1, momentalnaLodkaY.elementAt(0)) != 3 ) {
                                shoot(momentalnaLodkaX.elementAt(i)+1, momentalnaLodkaY.elementAt(0));
                                break;
                            }
                        }
                    }
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
                if(whatsAt(i, j) == 0 || whatsAt(i, j) == 1){//&& vybuchnuta4 && vybuchnuta5
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

    void shoot(int x,int y){
        super.shoot(x, y);
        if(!uspesnaStrela){
            System.out.printf("Computer shot at [%d, %d] and didn't hit your ship :)\n", x, y);
        }
        else{
            if(potopilSomPraveLodku){
                System.out.printf("Computer shot at [%d, %d] and sunk your whole ship :((\n", x, y);
            }
            else{
                System.out.printf("Computer shot at [%d, %d] and hit your ship :(\n", x, y);
            }
        }

        myBoard.printMe();
    }
}
