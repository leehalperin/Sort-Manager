package com.sparta.lh.exceptions;

public class ChildNotFoundException extends Throwable{

    public ChildNotFoundException() { super("This node has no child in that direction");}
    public ChildNotFoundException(String message) {super(message);}
}
