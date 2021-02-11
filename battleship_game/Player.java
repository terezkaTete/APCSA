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
            myBoard.shotAt(x, y);
            uspesnaStrela = false;
        }
        else if (myBoard.whatsAt(x,y) == 1){
            momentalnaLodkaX.add(x); momentalnaLodkaY.add(y); 
            myBoard.shotAt(x, y);
            if(jeCelaLodka(x, y)){
                potopilSomPraveLodku = true;
                nSunknutych++;

                //checknut, ci to uz neboli vsetky lodicky

                // "shooting" at all the adjacent fields
                for(int i=0;i<momentalnaLodkaX.size(); i++){
                    if(momentalnaLodkaX.elementAt(i)+1 < 10){
                        if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i)+1, momentalnaLodkaY.elementAt(i)) == 0){ //boa out of bounds
                            myBoard.shotAt(momentalnaLodkaX.elementAt(i)+1, momentalnaLodkaY.elementAt(i));
                        }
                    }
                    if(momentalnaLodkaX.elementAt(i)-1 >= 0){
                        if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i)-1, momentalnaLodkaY.elementAt(i)) == 0){
                            myBoard.shotAt(momentalnaLodkaX.elementAt(i)-1, momentalnaLodkaY.elementAt(i));
                        }
                    }
                    if(momentalnaLodkaY.elementAt(i)+1 < 10){
                        if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i), momentalnaLodkaY.elementAt(i)+1) == 0){
                            myBoard.shotAt(momentalnaLodkaX.elementAt(i), momentalnaLodkaY.elementAt(i)+1);
                        }
                    }
                    if(momentalnaLodkaY.elementAt(i)-1 >= 0){
                        if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i), momentalnaLodkaY.elementAt(i)-1) == 0){
                            myBoard.shotAt(momentalnaLodkaX.elementAt(i), momentalnaLodkaY.elementAt(i)-1);
                        }
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

    boolean jeCelaLodka(int x,int y){ //nieco nefunguje
        if(momentalnaLodkaX.size()<=1){
            return false;
        }

        boolean celaLodka = true;

        if(momentalnaLodkaX.elementAt(0) == momentalnaLodkaX.elementAt(1)){ //lodka je vertikalne
            for(int i=0;i<momentalnaLodkaY.size();i++){
                if(momentalnaLodkaY.elementAt(i)+1 <10){ //out of bounds check
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(0),momentalnaLodkaY.elementAt(i)+1) == 1){
                        celaLodka = false;
                    }
                }
                if(momentalnaLodkaY.elementAt(i)-1 >= 0){
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(0),momentalnaLodkaY.elementAt(i)-1) == 1){
                        celaLodka = false;
                    }
                }
            }
        }
        else if(momentalnaLodkaY.elementAt(0) == momentalnaLodkaY.elementAt(1)){ //lodka je vertikalne
            for(int i=0;i<momentalnaLodkaX.size();i++){
                if(momentalnaLodkaX.elementAt(i)+1 < 10){
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i)+1,momentalnaLodkaY.elementAt(0)) == 1){
                        celaLodka = false;
                    }
                }
                if(momentalnaLodkaX.elementAt(i)-1 >= 0){
                    if(myBoard.whatsAt(momentalnaLodkaX.elementAt(i)-1,momentalnaLodkaY.elementAt(0)) == 1){
                        celaLodka = false;
                    }
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
    }
}
