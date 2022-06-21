package ru.jru.zakharov.miniminecraft.exceprion;

public class AppExceprion extends RuntimeException{

    public AppExceprion() {
        super();
    }

    public AppExceprion(String message) {
        super(message);
    }

    public AppExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public AppExceprion(Throwable cause) {
        super(cause);
    }
}
