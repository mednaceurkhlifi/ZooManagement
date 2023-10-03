public class Zoo {
    Animal[] animals;
    private String name;
    String city;
    int count;
    final int NBR_MAX_CAGES =25;


    //Had to remove the nbrCages from constructor (constant)
    public Zoo(String name, String city) {
        animals = new Animal[NBR_MAX_CAGES];
        this.name = name;
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

                if (isZooFull()) {
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
            if (animal.getName().equals(animals[i].getName()))
                return i;
        }
        return -1;
    }


    //finds the last occ
    int searchSecond(Animal animal) {
        int i=0;

        while (i<count && !animals[i].getName().equals(animal.getName()))
        {
            i++;
        }
        if (i >= count)
        {
            return i;
        }
        return -1;

    }

    boolean removeAnimal(Animal animal) {

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

    boolean isZooFull() {
        return count >= NBR_MAX_CAGES;
    }

    Zoo CompareZoo(Zoo z1, Zoo z2) {
        return (z1.count > z2.count) ? z1 : z2;
    }
}
