package lamp;

public class lamp{
    private boolean isOn = false; //example of primitive variable
    private String color = "white";
    private float angle = 0;
    private int maxAngle = 180;
    
    public lamp(){
    }

    public lamp(String clr){
        this.color = clr; //we use this because we want to refer to color variable of this class
    }

    public lamp(String clr, int mAngle){
        this.color = clr;
        this.maxAngle = mAngle;
    }

    public void button(){
        this.isOn = !this.isOn;
    }

    public boolean getState(){ //this is accessor
        return isOn;
    }

    public void changeAngle(int chnge){ //this is mutator
        if(angle + (float)chnge > (float)maxAngle){
            System.out.println("not possible to change, exceeds the maximum possible angle");
        }
        else{
            this.angle += (float)chnge;
        }
    }

    public void changeAngle(float chnge){
        if(angle + chnge > maxAngle){
            System.out.println("not possible to change, exceeds the maximum possible angle");
        }
        else{
            this.angle += chnge;
        }
    }

    public float getArmAngle(){
        return this.angle;
    }
}

