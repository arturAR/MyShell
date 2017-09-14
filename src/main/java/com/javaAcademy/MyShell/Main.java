package com.javaAcademy.MyShell;

import com.javaAcademy.MyShell.commands.Command;
import com.javaAcademy.MyShell.commands.CommandManager;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main( String[] args ) {
        MyShell shell = new MyShell();
        do {
            UserInput userInput = getInput(shell);
            Command command = CommandManager.getCommand(userInput);
            try{
                command.execute(shell);
                updateStatistics(command, true, shell);
            } catch(WrongCommandException e) {
                updateStatistics(command, false, shell);
            }
        } while (shell.isRunning());
    }

    private static UserInput getInput(MyShell myShell) {
        System.out.print("[MyShell] " + myShell.getPrompt());
        scanner = new Scanner(System.in);
        return parseInput(scanner.nextLine());
    }

    private static UserInput parseInput(String input) {
        String parameter = "";
        String[] parsedInput = input.split(" ", 2);
        String command = parsedInput[0];
        if (parsedInput.length > 1) {
            parameter = parsedInput[1];
        }
        return new UserInput(command, parameter);
    }

    private static void updateStatistics(Command command, Boolean withoutErrors, MyShell shell) {
        shell.updateStatistics(command, withoutErrors);
    }
}
