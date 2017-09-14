package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;

public class WrongCommand implements Command {

    @Override
    public void execute(ShellManager shell) {
        System.out.println("unknown command");
    }
}
