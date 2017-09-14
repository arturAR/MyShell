package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;

public class Statistics implements Command {

    private String parameter;

    public Statistics(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager shell) {
        if(parameter.equals("")) {
            shell.showStatistics();
        } else {
            System.out.println("unknown command");
            throw new WrongCommandException();
        }
    }
}
