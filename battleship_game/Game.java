
public class Game {
    public static void main(String[] args) {
        System.out.println("This is battleship game.");
        //if you want rules, type rules, else start
        Human hrac1 = new Human();
        Computer hrac2 = new Computer();
        hrac1.makeTurn();

        //zatial random rozhodenie, potom si moze clovek vybrat
        //vyberanie tak, ze zada prve policko a posledne a ak mam taku lodku, tak ok
        
        
        //strielanie - ak trafis, ides znovu, ak trafis celu lod, tak ti to da vediet 
        //a vystrikuje to vsetky prazdne policka naookolo
    }
}
