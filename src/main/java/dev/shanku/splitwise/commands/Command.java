package dev.shanku.splitwise.commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
