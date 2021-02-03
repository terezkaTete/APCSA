
public class Game {
    public static void main(String[] args) {
        System.out.println("This is battleship game.");
        //if you want rules, type rules, else start
        Player hrac1 = new Player();
        hrac1.makeTurn();

        //zatial random rozhodenie, potom si moze clovek vybrat
        //vyberanie tak, ze zada prve policko a posledne a ak mam taku lodku, tak ok
        Grid pcBoard = new Grid();
        pcBoard.generateRandomBoard();
        pcBoard.printMe();

        Grid myBoard = new Grid();
        myBoard.generateRandomBoard();
        myBoard.printMe();

        //strielanie - ak trafis, ides znovu, ak trafis celu lod, tak ti to da vediet 
        //a vystrikuje to vsetky prazdne policka naookolo
    }
}
