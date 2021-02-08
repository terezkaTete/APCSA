/*todo: sinknutie lodicky - zmenit vsetky policka naokolo - done okrem tych nasikmo

    fixnut: out of bounds pri checkovani celej lodicky :((
*/
import java.util.Vector;

public class Player {
    protected Grid myBoard = new Grid(); //realne to je vlastne superov board
    protected boolean uspesnaStrela = false;
    protected boolean potopilSomPraveLodku = false;
    protected Vector<Integer> momentalnaLodkaX = new Vector<>();
    protected Vector<Integer> momentalnaLodkaY = new Vector<>();
    private int nSunknutych = 0;
    //mozno ze player chce mat svoju boardu - pssst
    //chce vediet spravit tah
    public Player(){
        myBoard.generateRandomBoard();
    }
    
    void shoot(int x,int y){
        if(myBoard.whatsAt(x,y) == 0){ 
            //System.out.println("water :(");
            uspesnaStrela = false;
        }
        else if (myBoard.whatsAt(x,y) == 1){
            momentalnaLodkaX.add(x); momentalnaLodkaY.add(y);
            if(jeCelaLodka(x, y)){
                potopilSomPraveLodku = true;
                nSunknutych++;
                //System.out.println("Congratulations, you sunk the whole ship!");

                //checknut, ci to uz neboli vsetky lodicky

                // "shooting" at all the adjacent fields
                for(int i=0;i<momentalnaLodkaX.size(); i++){
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i+1), momentalnaLodkaY.elementAt(0)) == 0){
                        myBoard.shotAt(momentalnaLodkaX.elementAt(i+1), momentalnaLodkaY.elementAt(0));
                    }
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i-1), momentalnaLodkaY.elementAt(0)) == 0){
                        myBoard.shotAt(momentalnaLodkaX.elementAt(i-1), momentalnaLodkaY.elementAt(0));
                    }
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i+1)) == 0){
                        myBoard.shotAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i+1));
                    }
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i-1)) == 0){
                        myBoard.shotAt(momentalnaLodkaX.elementAt(0), momentalnaLodkaY.elementAt(i-1));
                    }
                }
            }
            else{
                //System.out.println("Nice, you hit the ship!");
            }
            uspesnaStrela = true; //mozno este dalsia premenna, ci bola posledne potopena lod
            //System.out.println("You can have another try");
        }
        else{
            System.out.println("error shoot");
        }
        myBoard.shotAt(x, y);
    }

    boolean jeSunknuteVsetko(){
        if(nSunknutych == 5){
            return true;
        }
        return false;
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

        if(momentalnaLodkaX.elementAt(0) == momentalnaLodkaX.elementAt(1)){ //lodka je vertikalne
            for(int i=0;i<momentalnaLodkaY.size();i++){
                if(myBoard.whatsAt(momentalnaLodkaX.elementAt(0),momentalnaLodkaY.elementAt(i+1)) == 1 ||
                myBoard.whatsAt(momentalnaLodkaX.elementAt(0),momentalnaLodkaY.elementAt(i-1)) == 1){ //out of bounds
                    celaLodka = false;
                }
            }
        }
        else if(momentalnaLodkaY.elementAt(0) == momentalnaLodkaY.elementAt(1)){ //lodka je vertikalne
            for(int i=0;i<momentalnaLodkaX.size();i++){
                if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i+1),momentalnaLodkaY.elementAt(0)) == 1 ||
                myBoard.whatsAt(momentalnaLodkaX.elementAt(i-1),momentalnaLodkaY.elementAt(0)) == 1){ // out of bounds
                    celaLodka = false;
                }
            }
        }
        else{
            System.out.println("error jeCelaLodka");
        }

        if(celaLodka){
            return true;
        }
        else{
            return false;
        }
        //ak checknut oba konce - nemusia byt necessary koniec a zaziatok pola
        //ak na jednom z nich je 1 aka nieje voda, tak 

        //toto pod tymto funguje, ale grc
        /*for(int i=1;i<5;i++){
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
        */
    }
}
