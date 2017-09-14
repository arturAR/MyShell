package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;

public class Prompt implements Command {

    private String parameter;

    public Prompt(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager shell) {
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
