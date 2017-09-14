package com.javaAcademy.MyShell.commands;


import com.javaAcademy.MyShell.MyShell;
import com.javaAcademy.MyShell.WrongCommandException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Cd implements Command {

    private String parameter;

    public Cd(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(MyShell myShell) {
        switch (parameter) {
            case (".."):
                selectParentDirectory(myShell);
                break;
            default:
                selectChildDirectory(myShell, parameter);
                break;
        }
    }

    private void selectParentDirectory(MyShell myShell) {
        if (myShell.getCurrentDirectory().getParentFile() != null) {
            myShell.setCurrentDirectory(myShell.getCurrentDirectory().getParentFile());
        }
    }

    private void selectChildDirectory(MyShell myShell, String folderName) {
        ArrayList<File> folderContents = myShell.getFolderContents(myShell);
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
