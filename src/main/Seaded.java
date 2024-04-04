package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Seaded {
    private double kaadrisagedus;
    private char elusTäht;
    private char surnudTäht;
    private int laius;
    private int pikkus;
    private double võimalus;
    private String failinimi;
    private final String[] possibleSeaded = {"kaadrisagedus", "elusTäht", "surnudTäht", "laius", "pikkus", "võimalus", "failinimi", "load", "save", "list"};

    public Seaded() {
        this.kaadrisagedus = 2.5;
        this.elusTäht = '█';
        this.surnudTäht = ' ';
        this.laius = 0;
        this.pikkus = 0;
        this.võimalus = 0.5;
        this.failinimi = "seaded.txt";
    }


    public int muudaSätte(String line) throws FileNotFoundException {
        String[] osad = line.split(":");
        switch (osad[0]) {
            case "kaadrisagedus":
                this.setKaadrisagedus(Double.parseDouble(osad[1]));
                break;
            case "elustäht":
                this.setelusTäht(osad[1].charAt(0));
                break;
            case "surnudtäht":
                this.setsurnudTäht(osad[1].charAt(0));
                break;
            case "laius":
                this.setLaius(Integer.parseInt(osad[1]));
                break;
            case "pikkus":
                this.setKõrgus(Integer.parseInt(osad[1]));
                break;
            case "võimalus":
                this.setVõimalus(Double.parseDouble(osad[1]));
                break;
            case "failinimi":
                this.setFailinimi(osad[1]);
                break;
            case "load":
                return this.laeFailist();
            case "save":
                return this.salvestaFaili();
            case "list":
                this.listSeaded();
                break;
            default:
                return 1;
        }
        return 0;
    }

    public int laeFailist() throws FileNotFoundException {
        File fail = new File(this.getFailinimi());
        int staatus = 0;
        if (!fail.exists()) {
            return -1;
        }
        Scanner sc = new Scanner(fail);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int stat = this.muudaSätte(line);
            if (stat != 0) {
                System.err.println("Viga seade laadimisel: " + line);
                staatus += 1;
            }
        }
        return staatus;
    }

    public int salvestaFaili() {
        File fail = new File(this.getFailinimi());
        try {
            PrintWriter pw = new PrintWriter(fail);
            pw.println("kaadrisagedus:" + this.getKaadrisagedus());
            pw.println("elusTäht:" + this.getelusTäht());
            pw.println("surnudTäht:" + this.getsurnudTäht());
            pw.println("laius:" + this.getLaius());
            pw.println("pikkus:" + this.getKõrgus());
            pw.println("võimalus:" + this.getVõimalus());
            pw.close();
        } catch (IOException e) {
            System.err.println("Viga seadete salvestamisel: " + e.getMessage());
            return 1;
        }
        return 0;
    }

    public void listSeaded() {
        System.out.println("kaadrisagedus: " + this.getKaadrisagedus());
        System.out.println("elusTäht: " + this.getelusTäht());
        System.out.println("surnudTäht: " + this.getsurnudTäht());
        System.out.println("laius: " + this.getLaius());
        System.out.println("pikkus: " + this.getKõrgus());
        System.out.println("võimalus: " + this.getVõimalus());
        System.out.println("failinimi: " + this.getFailinimi());
    }

    public double getKaadrisagedus() {
        return kaadrisagedus;
    }

    public void setKaadrisagedus(double kaadrisagedus) {
        this.kaadrisagedus = kaadrisagedus;
    }

    public char getelusTäht() {
        return elusTäht;
    }

    public void setelusTäht(char elusTäht) {
        this.elusTäht = elusTäht;
    }

    public char getsurnudTäht() {
        return surnudTäht;
    }

    public void setsurnudTäht(char surnudTäht) {
        this.surnudTäht = surnudTäht;
    }

    public int getLaius() {
        return laius;
    }

    public void setLaius(int laius) {
        this.laius = laius;
    }

    public int getKõrgus() {
        return pikkus;
    }

    public void setKõrgus(int pikkus) {
        this.pikkus = pikkus;
    }

    public double getVõimalus() {
        return võimalus;
    }

    public void setVõimalus(double võimalus) {
        this.võimalus = võimalus;
    }

    public String getFailinimi() {
        return failinimi;
    }

    public void setFailinimi(String failinimi) {
        this.failinimi = failinimi;
    }

    public String[] getVõimalikudSeaded() {
        return possibleSeaded;
    }
}
