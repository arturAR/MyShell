package com.javaAcademy.MyShell;


import com.javaAcademy.MyShell.commands.Command;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyShell {

    private String prompt = "$";
    private boolean running = true;
    private File currentDirectory;
    private HashMap<String, Integer[]> statistics;

    public MyShell() {
        currentDirectory = new File(new File("").getAbsolutePath());
        statistics = new HashMap<>();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        if (prompt.equals("$cwd")) {
            return getWorkingDirectory() + ">";
        } else {
            return prompt + ">";
        }
    }

    public File getCurrentDirectory() {
        if(currentDirectory!=null) {
            return currentDirectory;
        } else {
            return new File("");
        }
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath();
    }

    public void exitShell() {
        this.running = false;
        System.out.println("Bye");
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public ArrayList<File> getFolderContents(MyShell myShell) {
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

    private void incrementValue(String className, Boolean withoutErrors) {
        if(withoutErrors) {
            statistics.get(className)[0]++;
        } else {
            statistics.get(className)[1]++;
        }
    }
}
