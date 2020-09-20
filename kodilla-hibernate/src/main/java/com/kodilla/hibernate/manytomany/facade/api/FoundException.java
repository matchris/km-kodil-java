package com.kodilla.hibernate.manytomany.facade.api;

public class FoundException extends Exception {
        public static String ERR_TOO_SHORT_PHRASE_PROVIDED = "You should provide at least 1 sign";
    public FoundException(String message) {
        super(message);
    }


}
