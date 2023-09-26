public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal(String family, String name, int age, boolean
            isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    @Override
    public String toString(){
        return this.family + "\n" + this.name + "\n" + this.age + "\n" + this.isMammal;
    }


}
