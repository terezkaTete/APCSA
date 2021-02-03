
public class Player {
    private Grid myBoard = new Grid(); //realne to je vlastne superov board, treba zmenit printovanie, nech to je skryte
    protected boolean uspesnaStrela = false;
    private int dlzkaLodky;
    //mozno ze player chce mat svoju boardu
    //chce vediet spravit tah
    public Player(){
        myBoard.generateRandomBoard();
        myBoard.printMe();
    }
    void makeTurn(){ // choose where you want to strike
    }

    void shoot(int x,int y){
        if(myBoard.whatsAt(x,y) == 0){ //nemoze sa streilat tam, kde sa uz strielalo, ale to checkovat v makeTurn
            System.out.println("water :(");
            uspesnaStrela = false;
        }
        else if (myBoard.whatsAt(x,y) == 1){
            if(jeCelaLodka(x, y)){
                System.out.println("Congratulations, you sunk the whole boat!");
                //chcem zaplavit policka naokolo
                //pocitac to nejako potrebuje vediet - po a ze sa to stalo a po b ze ako dlha bola ta lodicka
            }
            else{
                System.out.println("Nice, you hit the boat!");
            }
            uspesnaStrela = true; //mozno este dalsia premenna, ci bola posledne potopena lod
            System.out.println("You can have another try");
            //je cela lod potopena?
            //ak ano, tak vypisat congrats + dlzka lode & vystrielat policka naokolo
            //ak nie
        }
        else{
            System.out.println("error shoot");
        }
        myBoard.shotAt(x, y);
    }

    int whatsAt(int a, int b){
        return myBoard.whatsAt(a, b);
    }

    boolean jeCelaLodka(int x,int y){
        uspesnaStrela =true;
        dlzkaLodky = 0;
        boolean celaLodka = true;
        for(int i=1;i<5;i++){
            if(myBoard.whatsAt(x+i,y) == 3){
                dlzkaLodky++;
            }
            else{
                if(myBoard.whatsAt(x+i,y) == 1){
                    celaLodka = false;
                }
                break;
            }
        }
        for(int i=1;i<5;i++){
            if(myBoard.whatsAt(x-i,y) == 3){
                dlzkaLodky++;
            }
            else{
                if(myBoard.whatsAt(x-i,y) == 1){
                    celaLodka = false;
                }
                break;
            }
        }
        for(int i=1;i<5;i++){
            if(myBoard.whatsAt(x,y+i) == 3){
                dlzkaLodky++;
            }
            else{
                if(myBoard.whatsAt(x,y+i) == 1){
                    celaLodka = false;
                }
                break;
            }
        }
        for(int i=1;i<5;i++){
            if(myBoard.whatsAt(x,y-i) == 3){
                dlzkaLodky++;
            }
            else{
                if(myBoard.whatsAt(x,y-i) == 1){
                    celaLodka = false;
                }
                break;
            }
        }
        if(celaLodka){return true;}
        else{return false;}
    }
}
