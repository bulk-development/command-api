package ru.bulk.command.parameter.resolver.literal;

import ru.bulk.command.Command;
import ru.bulk.command.exception.CommandParseException;
import ru.bulk.command.parameter.resolver.ParameterResolver;

public class BooleanResolver<S> implements ParameterResolver<S, Boolean> {

    @Override
    public Boolean resolve(Command<S, ?> command, S sender, String input) throws CommandParseException {
        return input.equalsIgnoreCase("1")
                || input.equalsIgnoreCase("yes")
                || Boolean.parseBoolean(input);
    }

}
