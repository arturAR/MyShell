package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.MyShell;

public class Prompt implements Command {

    private String parameter;

    public Prompt(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(MyShell shell) {
        switch (parameter) {
            case "reset":
                shell.setPrompt("$");
                break;
            case "$cwd":
                shell.setPrompt("$cwd");
                break;
            default:
                shell.setPrompt(parameter);
                break;
        }
    }
}
