package ru.bulk.command.parameter.resolver;

import ru.bulk.command.Command;
import ru.bulk.command.exception.CommandParseException;

public interface ParameterResolver<S, T> {

    T resolve(Command<S, ?> command, S sender, String input) throws CommandParseException;

}
