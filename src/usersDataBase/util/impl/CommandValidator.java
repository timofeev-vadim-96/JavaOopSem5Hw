package usersDataBase.util.impl;

import usersDataBase.util.Commands;
import usersDataBase.util.Validator;

public class CommandValidator implements Validator<String> {
    public boolean validation(String action) {
        try {
            Enum.valueOf(Commands.class, action);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unexpected command! ");
        }
    }
}
