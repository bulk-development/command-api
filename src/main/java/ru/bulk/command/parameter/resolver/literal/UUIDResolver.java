package ru.bulk.command.parameter.resolver.literal;

import ru.bulk.command.Command;
import ru.bulk.command.exception.CommandParseException;
import ru.bulk.command.parameter.resolver.ParameterResolver;

import java.util.UUID;

public class UUIDResolver<S> implements ParameterResolver<S, UUID> {

    @Override
    public UUID resolve(Command<S, ?> command, S sender, String input) throws CommandParseException {
        try {
            return UUID.fromString(input);
        } catch (IllegalArgumentException exception) {
            throw new CommandParseException("§cНедопустимый формат UUID");
        }
    }

}
