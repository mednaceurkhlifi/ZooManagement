package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal{
    protected String habitat;

    public Aquatic() {

    }

    public Aquatic(String family, String name, int age, boolean isMammal,String habitat) {
        super(family,name,age,isMammal);
        this.habitat = habitat;
    }

    @Override
    public String toString(){
        return this.family + "\n" + this.name + "\n" + this.age + "\n" + this.isMammal + "\n"
                + this.habitat;
    }

    abstract public void swim();


    public boolean equals(Aquatic aquatic1, Aquatic aquatic2) {
        return aquatic1.name == aquatic2.name
                && aquatic1.age == aquatic2.age
                && aquatic1.habitat == aquatic2.habitat;
    }
}
