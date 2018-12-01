package exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException() {
        super();
    }

    public RoomNotFoundException(String msg) {
        super(msg);
    }
}