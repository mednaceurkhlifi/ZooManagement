package tn.esprit.gestionzoo.entities;

public class Aquatic extends Animal{
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

    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }
}
