public abstract class Person {

    private Television tv;

    public Person() {
    }

    public void watchTv() {
        this.tv = buyTv();
        tv.playMovie();
    }

    /**
     * This is the factory method that delegates TV creation to each type of person.
     * The object creation is delegated to the subclass extending this class
     * @return
     */
    abstract protected Television buyTv();

    public static void main(String[] argv) {

        Person a = new PersonOnBudget();
        Person b = new PersonOnQuality();

        a.watchTv();
        b.watchTv();

    }

}
