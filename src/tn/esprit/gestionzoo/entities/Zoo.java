package tn.esprit.gestionzoo.entities;

public class Zoo {
    Animal[] animals;
    private String name;
    String city;
    private int count;
    final int NBR_MAX_CAGES =3;
    final int AQUATIC_ANIMALS = 10;
    Animal[] aquaticAnimals;
    int aquaticCount = 0;

    //Had to remove the nbrCages from constructor (constant)
    public Zoo(String name, String city) {
        animals = new Animal[NBR_MAX_CAGES];
        aquaticAnimals = new Aquatic[AQUATIC_ANIMALS];
        if (!name.isEmpty()) this.name = name;
        this.city = city;
        //this.nbrCages = nbrCages; // Instruction 14 (prosit3) made this unnecessary
    }


    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public void displayZoo(){
        System.out.println(name);
        System.out.println(city);
        System.out.println(NBR_MAX_CAGES);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0; i <count;i++) {
            str.append(animals[i].toString());
        }

        return name + "\n" + city + "\n" + NBR_MAX_CAGES + "\n" + str;
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException{
        if (isZooFull()) {
            throw new ZooFullException("No more Cages :')");
        }
        if(animal.getAge() < 0) {
            throw new InvalidAgeException(animal.getName() + "'s age is negative");
        }
        if (searchSecond(animal) == -1) {
            System.out.println("Animal already exists in Animals");
            return;
        }
        animals[count] = animal;
        count++;
    }



    //Basic Search (finds the first occ)
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < count; i++) {
            if (animal.getName().equals(animals[i].getName()))
                return i;
        }
        return -1;
    }


    //finds the last occ
    public int searchSecond(Animal animal) {
        int i=0;
        while (i<count && !animals[i].getName().equals(animal.getName()))
            i++;
        if (i >= count)
            return i;
        return -1;
    }

    public boolean removeAnimal(Animal animal) {

        int index = searchAnimal(animal);
        System.out.println("\nRemoving Animal Number: " + index);
        if (index == 24) {
            animals[24]=null;
            return true;
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                animals[i] = animals[i + 1];
            }
            animals[count - 1] = null;
            count--;
            System.out.println("Animal is free");
            return true;
        }
        return false;

    }

    public boolean isZooFull() {
        return count >= NBR_MAX_CAGES;
    }

    public Zoo CompareZoo(Zoo z1, Zoo z2) {
        return (z1.count > z2.count) ? z1 : z2;
    }

    public boolean isAquaticFull() {
        return aquaticCount >= AQUATIC_ANIMALS;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (isAquaticFull()) {
            System.out.println("Aquatic is Full :'(");
            return;
        }
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;

        // Testing if adding works as intended or not
        if (aquatic instanceof Penguin)
            System.out.println("Added a Penguin to Aquatic Animals");
        if (aquatic instanceof Dolphin)
            System.out.println("Added a Dolphin to Aquatic Animals");
    }

    public float maxPenguinSwimmingDepth(){
        float max = 0;
        for(int i = 0; i < count ; i++){
            if (aquaticAnimals[i] instanceof Penguin &&
                    max < ((Penguin) aquaticAnimals[i]).getSwimmingDepth()){
                    max = ((Penguin) aquaticAnimals[i]).getSwimmingDepth();
            }
        }
        return max;
    }

    public void displayNumberOfAquaticByType(){
        int dolphin = 0, penguin = 0;
        for(int i = 0; i < count ; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                penguin++;
            }
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphin++;
            }
        }
        System.out.println("Number of penguins = " + penguin + "\n"
        + "Number of Dolphins = " + dolphin + "\n" );
    }

}
