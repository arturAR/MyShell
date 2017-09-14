package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;

public interface Command {

    void execute(ShellManager shellManager);
}
