package com.javaAcademy.MyShell.commands;


import com.javaAcademy.MyShell.MyShell;

public class WrongCommand implements Command {

    @Override
    public void execute(MyShell shell) {
        System.out.println("unknown command");
    }
}
