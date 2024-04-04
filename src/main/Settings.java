package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Settings {
    private double framerate;
    private char aliveChar;
    private char deadChar;
    private int width;
    private int height;
    private String filename;
    private final String[] possibleSettings = {"framerate", "alivechar", "deadchar", "width", "height", "filename", "load", "save", "list"};

    public Settings() {
        this.framerate = 2.5;
        this.aliveChar = '█';
        this.deadChar = ' ';
        this.width = 0;
        this.height = 0;
        this.filename = "settings.txt";
    }

    public int changeSetting(String line) throws FileNotFoundException {
        String[] parts = line.split(":");
        switch (parts[0]) {
            case "framerate":
                this.setFramerate(Double.parseDouble(parts[1]));
                break;
            case "alivechar":
                this.setAliveChar(parts[1].charAt(0));
                break;
            case "deadchar":
                this.setDeadChar(parts[1].charAt(0));
                break;
            case "width":
                this.setWidth(Integer.parseInt(parts[1]));
                break;
            case "height":
                this.setHeight(Integer.parseInt(parts[1]));
                break;
            case "filename":
                this.setFilename(parts[1]);
                break;
            case "load":
                return this.loadFromFile();
            case "save":
                return this.saveToFile();
            case "list":
                this.listSettings();
                break;
            default:
                return 1;
        }
        return 0;
    }

    public int loadFromFile() throws FileNotFoundException {
        File fail = new File(this.getFilename());
        int staatus = 0;
        if (!fail.exists()) {
            return -1;
        }
        Scanner sc = new Scanner(fail);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int stat = this.changeSetting(line);
            if (stat != 0) {
                System.err.println("Viga seade laadimisel: " + line);
                staatus += 1;
            }
        }
        return staatus;
    }

    public int saveToFile() {
        File fail = new File(this.getFilename());
        try {
            PrintWriter pw = new PrintWriter(fail);
            pw.println("framerate:" + this.getFramerate());
            pw.println("alivechar:" + this.getAliveChar());
            pw.println("deadchar:" + this.getDeadChar());
            pw.println("width:" + this.getWidth());
            pw.println("height:" + this.getHeight());
            pw.close();
        } catch (IOException e) {
            System.err.println("Viga seadete salvestamisel: " + e.getMessage());
            return 1;
        }
        return 0;
    }

    public void listSettings() {
        System.out.println("framerate: " + this.getFramerate());
        System.out.println("alivechar: " + this.getAliveChar());
        System.out.println("deadchar: " + this.getDeadChar());
        System.out.println("width: " + this.getWidth());
        System.out.println("height: " + this.getHeight());
        System.out.println("filename: " + this.getFilename());
    }

    public double getFramerate() {
        return framerate;
    }

    public void setFramerate(double framerate) {
        this.framerate = framerate;
    }

    public char getAliveChar() {
        return aliveChar;
    }

    public void setAliveChar(char aliveChar) {
        this.aliveChar = aliveChar;
    }

    public char getDeadChar() {
        return deadChar;
    }

    public void setDeadChar(char deadChar) {
        this.deadChar = deadChar;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String[] getPossibleSettings() {
        return possibleSettings;
    }
}
