import java.util.Random;

public class Grid {
    int board[][] = new int[10][10]; // cislovanie v boarde bude nasledovne: 0 voda, 1 lod, 2 zastrelena voda, 3 zastrelena lod
    private int boats[] = {5,4,3,3,2};
    private Random rand = new Random();
    private int x,y;

    public Grid(){

    }

    void printMe(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(this.board[i][j]); //upravit printovanie, aby to konvertovalo z cisel na znaky
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    void generateRandomBoard(){
        for(int i=0;i<boats.length; i++){
            //toto je bs, len aby mi to nieco robilo
            this.x = rand.nextInt(10); this.y = rand.nextInt(10);
            this.board[x][y] = 1;

            //tuto zgeneruj nejaky board s tym, ze mas lodicky v poli boats pricom tie values su ich dlzky
            //lodicky mozu byt bud vertikalne alebo horizontalne, sikmo je bs
        }
    }

    int whatsAt(int a,int b){
        return this.board[a][b];
    }
}
