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
        Animal lion = new Animal("lion", "simba", -10, true);
        Animal giraffe = new Animal("Giraffe", "gif", 12, true);
        Animal blobFish = new Animal("Fish", "blobby", -1, false);
        Animal ant = new Animal("Ant", "antisysteme", 3, false);
        Animal horse = new Animal("Horse", "BojackHorseman", 50, true);

        //Instantiating a Zoo
        Zoo myZoo = new Zoo("Zoo", "somewhere");


        // Added a static method in the ZooManagement class to remove redundancy
        addAnimalToZoo(myZoo,blobFish);
        addAnimalToZoo(myZoo,horse);
        addAnimalToZoo(myZoo,ant);
        addAnimalToZoo(myZoo,giraffe);
        addAnimalToZoo(myZoo,lion);


        // Part V && VI

        Penguin ping = new Penguin("peng", "ping",12,true,"igloo", 12);
        Dolphin dolph = new Dolphin("Dolphies", "Dolphy",12,true,"titanic", 12);

        Aquatic penguin = new Penguin("pinng", "ping",12,true,"igloo", 12);
        Aquatic penguin1 = new Penguin("pinng1", "ping",12,true,"igloo", 24);
        Aquatic penguin2 = new Penguin("pinng2", "ping",12,true,"igloo", 34);
        Aquatic penguin3 = new Penguin("pinng2", "ping",12,true,"igloo", 50);


        Aquatic dolphin = new Dolphin("Dolphin", "Dolphin",1,true,"titanic", 12);
        Aquatic dolphin1 = new Dolphin("Dolphin", "Dolphin",1,true,"titanic", 15);


        //Instruction 24
        ping.swim();
        dolph.swim(); // redefinition

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
        zooooo.addAquaticAnimal(penguin3);

        float x = zooooo.maxPenguinSwimmingDepth();
        System.out.println("Max penguin swimming depth is: " + x);
        zooooo.displayNumberOfAquaticByType();
        System.out.println( "is dolphin equal to dolphin1: " + dolphin.equals(dolphin, dolphin1));
        System.out.println( "is dolphin equal to ping: " + dolphin.equals(dolphin, ping));
        System.out.println( "is dolphin equal to ping: " + dolphin.equals(penguin1, penguin2));
    }

    public static void addAnimalToZoo(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
        }
        catch (ZooFullException exception)
        {
            System.out.println("Zoo is Full: " + exception.getMessage());
        }
        catch (InvalidAgeException exception) {
            System.out.println(animal.getFamily() + "'s Age is not Valid: " + exception.getMessage());
        }
        finally {
            System.out.println("Number of Animals in Zoo: " + zoo.getCount());
        }
    }

}