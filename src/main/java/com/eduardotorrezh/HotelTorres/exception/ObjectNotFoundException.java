package com.eduardotorrezh.HotelTorres.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Long id) {
        super("Could not find object with id = " + id);
    }
    public ObjectNotFoundException(String message) {
        super(message);
    }

}
