package tn.esprit.gestionzoo.entities;

public class Terrestial extends Animal{
        protected int nbrLegs;


        public Terrestial()
        {

        }
        public Terrestial(String family, String name, int age, boolean isMammal,int nbrLegs) {
                super(family,name,age,isMammal);
                this.nbrLegs = nbrLegs;
        }
        @Override
        public String toString(){
                return this.family + "\n" + this.name + "\n" + this.age + "\n" + this.isMammal + "\n"
                        + this.nbrLegs;
        }
}
