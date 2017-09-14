package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;

public class Exit implements Command {

    private String parameter;

    public Exit(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager shell) {
        if(parameter.equals("") || parameter.contains(" ")) {
            System.out.println("Bye");
            shell.setRunning(false);
        } else {
            System.out.println("unknown command");
            throw new WrongCommandException();
        }
    }
}
