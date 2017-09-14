package com.javaAcademy.MyShell.shell;

import java.io.File;
import java.util.HashMap;

public class MyShell {

    private String prompt = "$";
    private boolean running = true;
    private File currentDirectory;
    private HashMap<String, Integer[]> statistics;

    public MyShell() {
        currentDirectory = new File(new File("").getAbsolutePath());
        statistics = new HashMap<>();
    }

    void setRunning(boolean running) {
        this.running = running;
    }

    boolean isRunning() {
        return running;
    }

    void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    String getPrompt() {
        if (prompt.equals("$cwd")) {
            return getWorkingDirectory() + ">";
        } else {
            return prompt + ">";
        }
    }

    File getCurrentDirectory() {
        if(currentDirectory != null) {
            return currentDirectory;
        } else {
            return new File("");
        }
    }

    private String getWorkingDirectory() {
        return currentDirectory.getAbsolutePath();
    }

    void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    HashMap<String,Integer[]> getStatistics() {
        return statistics;
    }
}
