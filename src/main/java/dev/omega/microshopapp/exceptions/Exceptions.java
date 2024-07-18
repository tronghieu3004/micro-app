package dev.omega.microshopapp.exceptions;

import dev.omega.microshopapp.configuration.GlobalErrorCode;

public class Exceptions {
    public static class EntityNotFoundException extends SimpleGlobalException {
        public EntityNotFoundException() {
            super();
        }

        public EntityNotFoundException(String message) {
            super(message, GlobalErrorCode.GeneralCode.NOT_FOUND);
        }
    }
    public static class UserAlreadyExistException extends SimpleGlobalException {
        public UserAlreadyExistException(String message) {
            super(message, GlobalErrorCode.UserCode.USER_ALREADY_EXIST);
        }
    }
}
