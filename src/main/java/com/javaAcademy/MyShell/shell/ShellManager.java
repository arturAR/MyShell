package com.javaAcademy.MyShell.shell;

import com.javaAcademy.MyShell.commands.Command;
import com.javaAcademy.MyShell.shell.MyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShellManager {

    private MyShell myShell;
    private HashMap<String, Integer[]> statistics;

    public ShellManager(MyShell myShell) {
        this.myShell = myShell;
        this.statistics = myShell.getStatistics();
    }

    public void setPrompt(String prompt) {
        myShell.setPrompt(prompt);
    }

    public ArrayList<File> getFolderContents() {
        ArrayList<File> files = new ArrayList<>();
        File[] filesArray = null;

        try {
            filesArray = myShell.getCurrentDirectory().listFiles();
        } catch (NullPointerException e) {
            //TODO
        }

        if(filesArray != null) {
            files = new ArrayList<>(Arrays.asList(filesArray));
        }
        return files;
    }

    public void showStatistics() {
        for(Map.Entry<String, Integer[]> el: statistics.entrySet()) {
            System.out.println("["+el.getKey()+"]: " + el.getValue()[0] + " : " + el.getValue()[1]);
        }
    }

    private void incrementValue(String className, Boolean withoutErrors) {
        if(withoutErrors) {
            myShell.getStatistics().get(className)[0]++;
        } else {
            myShell.getStatistics().get(className)[1]++;
        }
    }

    public void updateStatistics(Command command, Boolean withoutErrors) {
        Integer[] tab = null;
        String className = command.getClass().getSimpleName();
        for(Map.Entry<String, Integer[]> el: statistics.entrySet()) {
            if(className.equals(el.getKey())) {
                tab = el.getValue();
            }
        }
        if(tab == null) {
            statistics.put(className, new Integer[]{0, 0});
        }
        incrementValue(className, withoutErrors);
    }

    public void setCurrentDirectory(File currentDirectory) {
        myShell.setCurrentDirectory(currentDirectory);
    }

    public File getCurrentDirectory() {
        return myShell.getCurrentDirectory();
    }

    public void setRunning(boolean running) {
        myShell.setRunning(running);
    }

    public void exitShell() {
        myShell.setRunning(false);
        System.out.println("Bye");
    }

     public boolean isRunning() {
        return myShell.isRunning();
    }

    public String getPrompt() {
        return myShell.getPrompt();
    }
}
