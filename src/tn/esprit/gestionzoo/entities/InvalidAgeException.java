package tn.esprit.gestionzoo.entities;

public class InvalidAgeException extends Exception{

    InvalidAgeException(){

    }
    InvalidAgeException(String message){
        super(message);
    }
}
