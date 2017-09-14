package com.javaAcademy.MyShell;

import com.javaAcademy.MyShell.commands.Command;
import com.javaAcademy.MyShell.commands.CommandManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;
import com.javaAcademy.MyShell.shell.MyShell;
import com.javaAcademy.MyShell.shell.ShellManager;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main( String[] args ) {
        MyShell shell = new MyShell();
        ShellManager shellManager = new ShellManager(shell);
        do {
            UserInput userInput = getInput(shellManager);
            Command command = CommandManager.getCommand(userInput);
            try{
                command.execute(shellManager);
                updateStatistics(command, true, shellManager);
            } catch(WrongCommandException e) {
                updateStatistics(command, false, shellManager);
            }
        } while (shellManager.isRunning());
    }

    private static UserInput getInput(ShellManager myShell) {
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

    private static void updateStatistics(Command command, Boolean withoutErrors, ShellManager shell) {
        shell.updateStatistics(command, withoutErrors);
    }
}
