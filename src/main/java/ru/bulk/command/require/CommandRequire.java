package ru.bulk.command.require;

import ru.bulk.command.Command;

import java.util.function.BiPredicate;

public interface CommandRequire<S, T> {

    static <S, T> CommandRequire<S, T> of(String message, BiPredicate<Command<S, T>, S> check) {
        return new FixedCommandRequire<>(message, check);
    }

    boolean check(Command<S, T> command, S sender);

    void notify(Command<S, T> command, S sender);

}
