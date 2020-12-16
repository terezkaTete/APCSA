package app.unit4polymorhism;

abstract class ATerestrial extends AAnimal implements iRunable{
    ATerestrial() {

    }

    ATerestrial(String name) {
        super(name);
    }

    @Override
    String sound() {
        return super.sound(); // add sound depending on animal
    }

    @Override
    String born() {
        return super.born() + "mammal";
    }
    @Override
    String move() {
        return super.move() + running();
    }
    @Override
    public String running() {
        return "Run";
    }
}
