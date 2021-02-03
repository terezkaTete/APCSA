
public class Player {
    private Grid myBoard = new Grid();
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
        }
        else if (myBoard.whatsAt(x,y) == 1){
            //je cela lod potopena?
            //ak ano, tak vypisat congrats + dlzka lode & vystrielat policka naokolo
            //ak nie
        }
    }

    int whatsAt(int a, int b){
        return myBoard.whatsAt(a, b);
    }
}
