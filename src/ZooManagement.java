import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ZooManagement {

    public static void main(String[] args) {


        /*
        //Part I

        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + "has " + nbrCages + " cages");

        //Part II

        Scanner sc = new Scanner(System.in);

        String zooName1;
        int nbrCages1;

        do {
            System.out.println("Zoo Name? ");
            zooName1 = sc.nextLine();
        } while (zooName1.length()<3);


        do {
            System.out.println("How many cages? ");
            nbrCages1 = sc.nextInt();
        } while (nbrCages1 < 3 || nbrCages1>20);

        System.out.println(zooName1 + " has " + nbrCages1 + " cages");


         */

        // PART III

        //Instantiating Animal Objects
        Animal lion = new Animal("lions", "simba", 10, true);
        Animal giraffe = new Animal("whateverfamilygiraffesare", "gif", 12, true);
        Animal blobFish = new Animal("Fish", "blobby", 1, false);
        Animal ant = new Animal("workersofworldunite", "antisysteme", 3, false);
        Animal horse = new Animal("Horsingaround", "BojackHorseman", 50, true);

        //Instantiating a Zoo
        Zoo myZoo = new Zoo("Zoo", "somewhere", 25);

        myZoo.displayZoo();

        System.out.println(myZoo); // prints name of the object @ memory location of the object
        System.out.println(myZoo.toString()); // same thing
        // we have to override the "toString" method to make the Sout to print the class attributes

        //Testing the addAnimal()
        System.out.println("Did I add the Blob? " + myZoo.addAnimal(blobFish));
        System.out.println("Did I add the Blob? " + myZoo.addAnimal(blobFish));
        System.out.println("Did I add the Lion? " + myZoo.addAnimal(lion));
        System.out.println("Did I add the Giraffe? " + myZoo.addAnimal(giraffe));
        System.out.println("Did I add the Ant? " + myZoo.addAnimal(ant));
        System.out.println("Did I add the Horse? " + myZoo.addAnimal(horse));

        //Testing searchAnimal()
        System.out.println("\nlion location:" + myZoo.searchAnimal(lion));

        System.out.println("\nblob-fish location:" + myZoo.searchAnimal(blobFish));

        //Testing toString()
        System.out.println(myZoo);


        //Testing removeAnimal()
        boolean removeBlob = myZoo.removeAnimal(blobFish);
        System.out.println("\n\ndid i remove the blob? " + removeBlob);

        boolean removeLion = myZoo.removeAnimal(lion);
        System.out.println("\n\ndid i remove the Lion? " + removeLion);

        boolean removeHorse = myZoo.removeAnimal(horse);
        System.out.println("\n\ndid i remove the Horse? " + removeHorse + "\n\n");

        //The final result
        System.out.println(myZoo);
    }
}