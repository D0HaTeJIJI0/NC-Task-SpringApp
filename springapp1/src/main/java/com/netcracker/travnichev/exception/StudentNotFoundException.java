package com.netcracker.travnichev.exception;

public class StudentNotFoundException extends Throwable {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
