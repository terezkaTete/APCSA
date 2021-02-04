/*todo: sinknutie lodicky - zmenit vsetky policka naokolo
                          - ak su vsetky sinknute, zrusit hru
        jeCelaLodicka prerobit aby bolo krajsie & more useful - aby som vedela sinkovat
*/
import java.util.Vector;

public class Player {
    private Grid myBoard = new Grid(); //realne to je vlastne superov board, treba zmenit printovanie, nech to je skryte
    protected boolean uspesnaStrela = false;
    protected boolean potopilSomPraveLodku = false;
    protected Vector<Integer> momentalnaLodkaX = new Vector<>();
    protected Vector<Integer> momentalnaLodkaY = new Vector<>();
    //mozno ze player chce mat svoju boardu - pssst
    //chce vediet spravit tah
    public Player(){
        myBoard.generateRandomBoard();
        myBoard.printMe();
    }
    
    void shoot(int x,int y){
        if(myBoard.whatsAt(x,y) == 0){ 
            System.out.println("water :(");
            uspesnaStrela = false;
        }
        else if (myBoard.whatsAt(x,y) == 1){
            momentalnaLodkaX.add(x); momentalnaLodkaY.add(y);
            if(jeCelaLodka(x, y)){
                potopilSomPraveLodku = true;
                System.out.println("Congratulations, you sunk the whole ship!");
                //checknut, ci to uz neboli vsetky lodicky
                //chcem zaplavit policka naokolo - na to mi pomoze vector s tou lodickou
                //also chcem vediet, ako dlha je ta lodicka
            }
            else{
                System.out.println("Nice, you hit the ship!");
            }
            uspesnaStrela = true; //mozno este dalsia premenna, ci bola posledne potopena lod
            System.out.println("You can have another try");
        }
        else{
            System.out.println("error shoot");
        }
        myBoard.shotAt(x, y);
    }

    int whatsAt(int a, int b){
        return myBoard.whatsAt(a, b);
    }

    boolean succefulShot(){
        if(uspesnaStrela){return true;}
        else{return false;}
    }

    boolean jeCelaLodka(int x,int y){
        if(momentalnaLodkaX.size()<=1){
            return false;
        }

        boolean celaLodka = true;
        //ak x1 = x2, tak potom lodka je zvislo a naopak
        //ak checknut oba konce - nemusia byt necessary koniec a zaziatok pola
        //ak na jednom z nich je 1 aka nieje voda, tak 

        //toto pod tymto funguje, ale grc
        for(int i=1;i<5;i++){
            if(myBoard.whatsAt(x+i,y) == 3){
                
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
