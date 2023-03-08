package ru.bulk.command.parameter.resolver.literal;

import lombok.Data;
import ru.bulk.command.Command;
import ru.bulk.command.exception.CommandParseException;
import ru.bulk.command.parameter.resolver.ParameterResolver;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class EnumResolver<S, E extends Enum<E>> implements ParameterResolver<S, E> {

    protected final Class<E> enumClass;

    @Override
    public E resolve(Command<S, ?> command, S sender, String input) throws CommandParseException {
        try {
            return Enum.valueOf(enumClass, input.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new CommandParseException(String.format(
                    "§cНедопустимое значение. Возможные: §e%s",
                    Arrays.stream(enumClass.getEnumConstants()).map(E::name).collect(Collectors.joining(", "))
            ));
        }
    }

}
