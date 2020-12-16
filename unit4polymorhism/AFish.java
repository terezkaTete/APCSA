package app.unit4polymorhism;

abstract class AFish extends AAnimal implements iSwimable{
    AFish() {

    }

    AFish(String name) {
        super(name);
    }

    @Override
    String sound() {
        return super.sound() + "no sound";
    }

    @Override
    String born() {
        return super.born() + "eggs in water";
    }

    @Override
    String move() {
        return super.move() + swimming();
    }

    @Override
    public String swimming() {
        return "Swim";
    }

    @Override
    public String breathUnderWater() {
        return "Nest";
    }
}
