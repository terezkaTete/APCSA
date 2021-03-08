package gcd;


public class Gcd {
    Gcd(){

    }
    public int find(int a, int b){
        if(b==0){
            return a;
        }
        return (find(b,a%b));
    }
}
