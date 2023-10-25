package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        /*//Part I

        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + "has " + nbrCages + " cages");

        //Part II

        Scanner sc = new Scanner(System.in);

        String zooName1;
        int nbrCages1;

        do {
            System.out.println("What is the Zoo Name? ");
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
        Animal giraffe = new Animal("GirFam", "gif", 12, true);
        Animal blobFish = new Animal("Fish", "blobby", 1, false);
        Animal ant = new Animal("Colony", "antisysteme", 3, false);
        Animal horse = new Animal("Horsingaround", "BojackHorseman", 50, true);

        //Instantiating a Zoo
        Zoo myZoo = new Zoo("Zoo", "somewhere");

        //Instantiating a different Zoo
        Zoo myVoodooZoo = new Zoo("VoodooZoo", "somewhere");

        //Testing the displayZoo()
        myZoo.displayZoo();

        System.out.println(myZoo); // prints name of the object @ memory location of the object
        // System.out.println(myZoo.toString()); // unnecessary (does the same thing as sout)
        // we have to override the "toString" method to make the Sout to print the class attributes

        //Testing the addAnimal()
        /*
        System.out.println("Did I add the Blob? " + myZoo.addAnimal(blobFish));
        System.out.println("Did I add the Blob? " + myZoo.addAnimal(blobFish));
        System.out.println("Did I add the Lion? " + myZoo.addAnimal(lion));
        System.out.println("Did I add the Giraffe? " + myZoo.addAnimal(giraffe));
        System.out.println("Did I add the Ant? " + myZoo.addAnimal(ant));
        System.out.println("Did I add the Horse? " + myZoo.addAnimal(horse));
        System.out.println("Did I add the Horse again? " + myZoo.addAnimal(horse));
        System.out.println("Did I add the Horse To my other zoo? " + myVoodooZoo.addAnimal(horse));
        */

        try {
            myZoo.addAnimal(blobFish);
        }
        catch (ZooFullException exception)
        {
            System.out.println("Zoo is Full");
        }
        finally {
            System.out.println("Number of Animals in Zoo: " + myZoo.getCount());
        }

        try {
            myZoo.addAnimal(lion);
        }
        catch (ZooFullException exception)
        {
            System.out.println("Zoo is Full");
        }
        finally {
            System.out.println("Number of Animals in Zoo: " + myZoo.getCount());
        }

        try {
            myZoo.addAnimal(giraffe);
        }
        catch (ZooFullException exception)
        {
            System.out.println("Zoo is Full");
        }
        finally {
            System.out.println("Number of Animals in Zoo: " + myZoo.getCount());
        }
        try {
            myZoo.addAnimal(ant);
        }
        catch (ZooFullException exception)
        {
            System.out.println("Zoo is Full");
        }
        finally {
            System.out.println("Number of Animals in Zoo: " + myZoo.getCount());
        }


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

        //Testing the isZooFull()
        boolean full = myZoo.isZooFull();
        System.out.println("\n" + full);

        //Testing the CompareZoo()
        System.out.println(myZoo.CompareZoo(myZoo, myVoodooZoo));


        // Part V && VI

        //Instantiating Aquatic Class and its kids
        //Aquatic ack = new Aquatic("acua", "ack", 11, false,"Depth"); // made the aquatic class abstract
        Penguin ping = new Penguin("peng", "ping",12,true,"igloo", 12);
        Dolphin dolph = new Dolphin("Dolphies", "Dolphy",12,true,"titanic", 12);

        Aquatic penguin = new Penguin("pinng", "ping",12,true,"igloo", 12);
        Aquatic penguin1 = new Penguin("pinng1", "ping",12,true,"igloo", 24);
        Aquatic penguin2 = new Penguin("pinng2", "ping",12,true,"igloo", 34);


        Aquatic dolphin = new Dolphin("Dolphin", "Dolphin",1,true,"titanic", 12);
        Aquatic dolphin1 = new Dolphin("Dolphin", "Dolphin",1,true,"titanic", 15);

        // Displaying the Children Classes
        //System.out.println((Animal)dolph);
        //System.out.println((Animal)ping);

        //Instruction 24
        //ack.swim();
        ping.swim();
        dolph.swim(); //redefinition

        System.out.println("\n");


        penguin.swim();
        dolphin.swim();

        Zoo zooooo = new Zoo("Zooooooooooooo", "somewhere");

        zooooo.addAquaticAnimal(dolph);
        zooooo.addAquaticAnimal(ping);
        zooooo.addAquaticAnimal(dolphin);
        zooooo.addAquaticAnimal(dolphin1);
        zooooo.addAquaticAnimal(penguin);
        zooooo.addAquaticAnimal(penguin1);
        zooooo.addAquaticAnimal(penguin2);

        float x = zooooo.maxPenguinSwimmingDepth();
        System.out.println(x);
        zooooo.displayNumberOfAquaticByType();
        System.out.println( "is dolphin equal to dolphin1: " + dolphin.equals(dolphin, dolphin1));
        System.out.println( "is dolphin equal to ping: " + dolphin.equals(dolphin, ping));
        System.out.println( "is dolphin equal to ping: " + dolphin.equals(penguin1, penguin2));
    }
}