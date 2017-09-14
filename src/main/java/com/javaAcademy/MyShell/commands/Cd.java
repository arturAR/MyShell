package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;

import java.io.File;
import java.util.ArrayList;

public class Cd implements Command {

    private String parameter;

    public Cd(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager myShell) {
        switch (parameter) {
            case (".."):
                selectParentDirectory(myShell);
                break;
            default:
                selectChildDirectory(myShell, parameter);
                break;
        }
    }

    private void selectParentDirectory(ShellManager myShell) {
        if (myShell.getCurrentDirectory().getParentFile() != null) {
            myShell.setCurrentDirectory(myShell.getCurrentDirectory().getParentFile());
        }
    }

    private void selectChildDirectory(ShellManager myShell, String folderName) {
        ArrayList<File> folderContents = myShell.getFolderContents();
        boolean flag = false;
        File file = null;
        for (File f : folderContents) {
            if (f.getName().equals(folderName) && f.isDirectory()) {
                file = f;
                flag = true;
                break;
            }
        }
        if(flag) {
            myShell.setCurrentDirectory(file);
        } else {
            System.out.println("Directory: " + folderName + " not found.");
            throw new WrongCommandException();
        }
    }

}
