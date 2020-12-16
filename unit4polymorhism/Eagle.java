package app.unit4polymorhism;

/**
 * Concrete class of Golden eagle
 */
class Eagle extends ABirds {
    Eagle() {
        super("Golden Eagle");
    }

    /**
     * Adding interesting feature
     */
    @Override
    String showYourself() {
        // TODO Auto-generated method stub
        return super.showYourself()+", Max Speed 320 km/h";
    }
}
