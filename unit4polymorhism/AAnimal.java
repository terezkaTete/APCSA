package app.unit4polymorhism;

/**
 * This is top Abstract class of all animals
 */
abstract class AAnimal {
    private String name;

    AAnimal() {
        this.name = "Name unknown";
    }

    AAnimal(String name) {
        this.name = name;
    }

    /**
     * Show features
     * @return Description of all basic features
     */
    String showYourself(){
        return this+", "+this.sound()+", "+this.move()+", "+this.born();
    }

    /**
     * Dummy frame for place of born
     * @return
     */
    String born() {
        return "Borned: ";
    }

    /**
     * Dummy frame for making sound
     * @return
     */
    String sound() {
        // https://www.fluentu.com/blog/english/animal-sounds-in-english/
        return "Sound: ";
    }

    /**
     * Dummy frame for moving information
     * @return
     */
    String move() {
        return "Movement: ";
    }

    /**
     * Dummy frame for eating composition
     * @return
     */
    String eat() {
        return "Eating: ";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name;
    }
}
