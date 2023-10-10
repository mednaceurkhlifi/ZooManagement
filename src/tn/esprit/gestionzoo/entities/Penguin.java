package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic{
    private float swimmingDepth;


    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public Penguin()
    {

    }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth)
    {
        super(family,name,age,isMammal,habitat);
        this.swimmingDepth = swimmingDepth;

    }

    @Override
    public String toString(){
        return this.family + "\n" + this.name + "\n" + this.age + "\n" + this.isMammal + "\n"
                + this.habitat + "\n" + swimmingDepth;
    }


}
