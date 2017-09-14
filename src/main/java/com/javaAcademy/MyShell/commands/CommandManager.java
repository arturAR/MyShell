package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.UserInput;

public class CommandManager {

    private static final String CD = "cd";
    private static final String PROMPT = "prompt";
    private static final String TREE = "tree";
    private static final String EXIT = "exit";
    private static final String STATISTICS = "statistics";
    private static final String DIR = "dir";

    public static Command getCommand(UserInput userInput) {
        Command command;
        switch (userInput.getCommand()) {
            case CD:
                command = new Cd(userInput.getParameter());
                break;
            case DIR:
                command = new Dir(userInput.getParameter());
                break;
            case PROMPT:
                command = new Prompt(userInput.getParameter());
                break;
            case TREE:
                command = new Tree(userInput.getParameter());
                break;
            case EXIT:
                command = new Exit(userInput.getParameter());
                break;
            case STATISTICS:
                command = new Statistics(userInput.getParameter());
                break;
            default:
                command = new WrongCommand();
                break;
        }
        return command;
    }
}