public class Zoo {
    Animal[] animals;
    String name;
    String city;
    //final int nbrCages = 25;
    int count;
    final int NBR_MAX_CAGES =25;


    //Had to remove the nbrCages from constructor (constant)
    public Zoo(String name, String city) {
        animals = new Animal[NBR_MAX_CAGES];
        this.name = name;
        this.city = city;
        //this.nbrCages = nbrCages; // Instruction 14 (prosit3) made this unnecessary
    }

    void displayZoo(){
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

    boolean addAnimal(Animal animal) {
        int test = searchSecond(animal);

        System.out.println("Animal Number: " + test);

        for (int i=0; i < animals.length; i++) {

            if (animals[i] == null)
            {

                if (count >= NBR_MAX_CAGES) {
                    System.out.println("No more Cages :')");
                }
                else {
                    if (test != -1) {
                    animals[count] = animal;
                    count++;
                    return true;
                    }
                    else
                    {
                        System.out.println("Animal already exists in Animals");
                        break;
                    }

                }

            }
        }

        return false;
    }



    //Basic Search (finds the first occ)
    int searchAnimal(Animal animal) {
        for (int i = 0; i < count; i++) {
            if (animal.name.equals(animals[i].name))
                return i;
        }
        return -1;
    }


    //finds the last occ
    int searchSecond(Animal animal) {
        int i=0;

        while (i<count && !animals[i].name.equals(animal.name))
        {
            i++;
        }
        if (i >= count)
        {
            return i;
        }
        return -1;

    }


    //comment 2
    boolean removeAnimal(Animal animal) {

        int index = searchAnimal(animal);
        System.out.println("\nRemoving Animal Number: " + index);
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

    boolean isZooFull() {
        return count >= NBR_MAX_CAGES;
    }

    Zoo CompareZoo(Zoo z1, Zoo z2) {
        if (z1.count > z2.count) {
            return z1;
        }
        return z2;
    }
}
