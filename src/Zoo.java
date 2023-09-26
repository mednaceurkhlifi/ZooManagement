public class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;
    int count;
    final int NBR_MAX_CAGES =25;

    public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[NBR_MAX_CAGES];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }

    void displayZoo(){
        System.out.println(name);
        System.out.println(city);
        System.out.println(nbrCages);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0; i <count;i++) {
            str.append(animals[i].toString());
        }

        return name + "\n" + city + "\n" + nbrCages + "\n" + str;
    }

    boolean addAnimal(Animal animal) {
        int test = searchSecond(animal);

        System.out.println("Animal Number: " + test);

        for (int i =0; i < animals.length; i++) {

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



    //Basic Search (shows the first occ)
    int searchAnimal(Animal animal) {

        for (int i = 0; i < count; i++) {
            if (animal.name.equals(animals[i].name))
                return i;
        }
        return -1;
    }

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

}
