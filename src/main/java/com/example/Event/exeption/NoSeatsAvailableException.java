package com.example.Event.exeption;

public class NoSeatsAvailableException extends RuntimeException{
    public NoSeatsAvailableException(String message){ super(message);}
}
