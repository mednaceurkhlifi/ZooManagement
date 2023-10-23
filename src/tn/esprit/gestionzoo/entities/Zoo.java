package tn.esprit.gestionzoo.entities;

public class Zoo {
    Animal[] animals;
    private String name;
    String city;
    int count;
    final int NBR_MAX_CAGES =25;
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

    public boolean addAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++)
        {
            if (animals[i] != null){
              i++;
            }
            if (isZooFull()) {
                System.out.println("No more Cages :')");
                break;
            }
            if (searchSecond(animal) == -1) {
                System.out.println("Animal already exists in Animals");
                break;
            }
            animals[count] = animal;
            count++;
            return true;
        }
        return false;
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
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] != null) {
                i++;
            }
            if (isAquaticFull()) {
                System.out.println("Aquatic is Full :'(");
                break;
            }
            aquaticAnimals[aquaticCount] = aquatic;
            aquaticCount++;
            // Testing if adding works as intended or not
            if (aquatic instanceof Penguin)
                System.out.println("Added a Penguin to Aquatic Animals");
            if (aquatic instanceof Dolphin)
                System.out.println("Added a Dolphin to Aquatic Animals");
            // if you don't return here it will continue to add aquatic to every column of aquaticAnimals
            // Or we can implement this method with a return type (boolean for example)
            return;
        }
    }

    public float maxPenguinSwimmingDepth(){
        float max = 0;
        for (Animal animal : aquaticAnimals){
            if (animal instanceof Penguin &&
                    max < ((Penguin) animal).getSwimmingDepth()){
                    max = ((Penguin) animal).getSwimmingDepth();
            }
        }
        return max;
    }

    public void displayNumberOfAquaticByType(){
        int dolphin = 0, penguin = 0;
        for(Animal animal : aquaticAnimals) {
            if (animal instanceof Penguin) {
                penguin++;
            }
            if (animal instanceof Dolphin) {
                dolphin++;
            }
        }
        System.out.println("Number of penguins = " + penguin + "\n"
        + "Number of Dolphins = " + dolphin + "\n" );
    }

}
