package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.MyShell;
import com.javaAcademy.MyShell.WrongCommandException;

public class Statistics implements Command {

    private String parameter;

    public Statistics(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(MyShell shell) {
        if(parameter.equals("")) {
            shell.showStatistics();
        } else {
            System.out.println("unknown command");
            throw new WrongCommandException();
        }
    }
}
