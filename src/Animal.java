public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean
            isMammal) {
        this.family = family;
        this.name = name;
        if (age > 0) this.age = age; else this.age = 0;
        this.isMammal = isMammal;
    }

    @Override
    public String toString(){
        return this.family + "\n" + this.name + "\n" + this.age + "\n" + this.isMammal;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age){
        if (age>0) {
            this.age = age;
        }
        else {
            this.age = 0;
        }
    }

    public String getFamily() {
        return this.family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name =name;
    }
    public boolean isMammal(){
        return this.isMammal;
    }
    public void setMammal(boolean isMammal){
        this.isMammal = isMammal;
    }

}
