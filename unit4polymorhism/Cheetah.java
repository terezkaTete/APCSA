package app.unit4polymorhism;

public class Cheetah extends ATerestrial{
    Cheetah(){
    super("Big cat");
    }

    @Override
    String sound() {
        return super.sound()+ "meow"; // add sound depending on animal
    }

    @Override
    String showYourself() {
        return super.showYourself()+ ", I'm the fastest mammal.";
    }

}
