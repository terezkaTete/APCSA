package app.unit4polymorhism;

class Dolphin extends AFish{
    Dolphin(){
        super("Cute dolphin");
    }

    @Override
    String showYourself() {
        return super.showYourself()+ ", " + super.breathUnderWater();
    }
}