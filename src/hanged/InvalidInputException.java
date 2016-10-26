package hanged;

class InvalidInputException extends Exception {

    public InvalidInputException(PlayerInput input) {
        super("Illegal input: " + input);
    }
    
}
