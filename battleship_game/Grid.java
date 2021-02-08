//generateRandomBoard - momentalne sa mozu lodicky dotykat sikmo
//upravit to printovanie - nech sa hracovi zobrazuje jeho boarda a superova inak -done

import java.util.Random;

public class Grid {
    int board[][] = new int[10][10]; // cislovanie v boarde bude nasledovne: 0 voda, 1 lod, 2 zastrelena voda, 3 zastrelena lod
    private int boats[] = {5,4,3,3,2};
    private Random rand = new Random();
    private int x,y, vodorovne;

    public Grid(){

    }

    void printMe(){
        System.out.println("Your board:"); 
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(this.board[i][j] == 0){
                    System.out.print(".");
                }
                if(this.board[i][j] == 1){
                    System.out.print("B");
                }
                if(this.board[i][j] == 2){
                    System.out.print("*");
                }
                if(this.board[i][j] == 3){
                    System.out.print("x");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    void printOpponent(){
        System.out.println("Opponent's board:"); 
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(this.board[i][j] == 0 || this.board[i][j] == 1){
                    System.out.print("?");
                }
                if(this.board[i][j] == 2){
                    System.out.print("*");
                }
                if(this.board[i][j] == 3){
                    System.out.print("x");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    void generateRandomBoard(){
        for(int i=0;i<boats.length; i++){
            //zatial sa mozu lodicky dotykat rohmi :((
            while(true){ //in theory can last forever but practically won't. Could be done more efficient but that's unnecessary for this case
                this.x = rand.nextInt(10); this.y = rand.nextInt(10); this.vodorovne = rand.nextInt(2);
                boolean mozeByt = true; 
                if(vodorovne == 1){
                    if(this.x+boats[i] <= 10){
                        for(int j=0;j<boats[i];j++){
                            if(board[x+j][y] == 1){ 
                                mozeByt = false;
                            }
                            if(this.x +j -1 >=0){ // out of bounds check
                                if(board[x+j-1][y] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.y -1 >=0){ // out of bounds check
                                if(board[x+j][y-1] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.x +j +1 <10){ // out of bounds check
                                if(board[x+j+1][y] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.y +1 <10){ // out of bounds check
                                if(board[x+j][y+1] == 1){
                                    mozeByt = false;
                                }
                            }
                        }
                        if(mozeByt){
                            for(int j=0;j<boats[i];j++){
                                board[x+j][y] = 1;
                            }
                            break;
                        }
                    }
                }
                else if(vodorovne == 0){
                    if(this.y+boats[i] <= 10){
                        for(int j=0;j<boats[i];j++){
                            if(board[x][y+j] == 1){
                                mozeByt = false;
                            }
                            if(this.x -1 >=0){ // out of bounds check
                                if(board[x-1][y+j] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.y+j -1 >=0){ // out of bounds check
                                if(board[x][y+j-1] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.x +1 <10){ // out of bounds check
                                if(board[x+1][y+j] == 1){
                                    mozeByt = false;
                                }
                            }
                            if(this.y +j +1 <10){ // out of bounds check
                                if(board[x][y+j+1] == 1){
                                    mozeByt = false;
                                }
                            }
                        }
                        if(mozeByt){
                            for(int j=0;j<boats[i];j++){
                                board[x][y+j] = 1;
                            }
                            break;
                        }
                    }
                }
                else{
                    System.out.println("error generate board");
                }
            }
        }
    }

    int whatsAt(int a,int b){
        return this.board[a][b];
    }

    void shotAt(int a,int b){
        if(this.board[a][b] == 0){
            this.board[a][b] = 2;
        }
        else if(this.board[a][b] == 1){
            this.board[a][b] = 3;
        }
        else{
            System.out.print("error shotAt");
        }
    }
}
