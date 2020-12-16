package app.unit4polymorhism;

/**
 * This is abstract group of species with ability to fly
 */
abstract class ABirds extends AAnimal implements iFlyable {

    ABirds() {

    }

    ABirds(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    // From Abstract Animal
    @Override
    String sound() {
        // TODO Auto-generated method stub
        return super.sound() + "chirp";
    }

    // From Abstract Animal
    @Override
    String born() {
        return super.born() + nesting();
    }

    // From Abstract Animal
    @Override
    String move() {
        // TODO Auto-generated method stub
        return super.move() + flying();
    }

    // From interface iFlyable
    @Override
    public String flying() {
        // TODO Auto-generated method stub
        return "Flight";
    }

    // From interface iFlyable
    @Override
    public String nesting() {
        // TODO Auto-generated method stub
        return "Nest";
    }
}
