package com.javaAcademy.MyShell.commands;

import com.javaAcademy.MyShell.shell.ShellManager;
import com.javaAcademy.MyShell.exception.WrongCommandException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Tree implements Command {

    private String parameter;

    public Tree(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(ShellManager shell) {
        if(parameter.equals("") || parameter.contains(" ")) {
            getStringTree(shell);
        } else {
            System.out.println("unknown command");
            throw new WrongCommandException();
        }
    }

    private void generateFoldersTree(File file, StringBuilder prefix) {
        File[] filesArray = null;
        try{
            filesArray = file.listFiles();
        } catch (NullPointerException npe){
            //TODO
        }

        if(filesArray!=null) {
            ArrayList<File> files = new ArrayList<>(Arrays.asList(filesArray));
            for(File f: files) {
                if(f.isDirectory()) {
                    prefix.append("-");
                    System.out.println(prefix + f.getName());
                    generateFoldersTree(f, prefix);
                    prefix.delete(prefix.length() - 1, prefix.length());
                }
            }
        }
    }

    private void getStringTree(ShellManager myShell) {
        System.out.println(myShell.getCurrentDirectory().getName());
        generateFoldersTree(myShell.getCurrentDirectory(), new StringBuilder(""));
    }
}
