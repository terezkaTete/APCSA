package lamp;

public class createLamp {
    public static void main(String[] args) {
        lamp L1 = new lamp(); //example of reference variable
        lamp L2 = new lamp("red", 180); //L2 is class instance
        lamp L3 = L2; //the angle of the arms is the same since L3 has now everything same as L2
        float idk;
        idk = 0;
        idk += 1.5;
        L2.changeAngle(idk); //the degree of L2 changes from 0 to 1.5 and L3 stays at 0
    }
}
