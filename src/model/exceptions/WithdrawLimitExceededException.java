package model.exceptions;

public class WithdrawLimitExceededException extends RuntimeException{
    public WithdrawLimitExceededException(String message) {
        super(message);
    }
}
