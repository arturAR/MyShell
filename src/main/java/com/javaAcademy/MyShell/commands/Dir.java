package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;

import java.io.File;
import java.util.List;

public class Dir implements Command {

    private String parameter;

    public Dir(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager shell) {
        if(parameter.equals("")) {
            System.out.println(displayCurrentDirectoryContents(shell));
        } else {
            System.out.println("unknown command");
            throw new WrongCommandException();
        }
    }

    private String displayCurrentDirectoryContents(ShellManager myShell) {
        List<File> contents = myShell.getFolderContents();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ")
                .append(myShell.getCurrentDirectory().getAbsolutePath())
                .append("\n");

        for (File f : contents) {
            if (f.isDirectory()) {
                stringBuilder.append("DIR\t\t")
                        .append(f.getName())
                        .append("\n");
            } else {
                stringBuilder.append("FILE\t")
                        .append(f.getName())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
