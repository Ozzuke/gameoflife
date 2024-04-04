package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
You could use cursor up to delete a line, and erase text, or simply overwrite with the old text with new text.

int count = 1;
System.out.print(String.format("\033[%dA",count)); // Move up
System.out.print("\033[2K"); // Erase line content
or clear screen

System.out.print(String.format("\033[2J"));
This is standard, but according to wikipedia the Windows console don't follow it.

Have a look: http://www.termsys.demon.co.uk/vtansi.htm


System.out.print("hello");
        Thread.sleep(1000); // Just to give the user a chance to see "hello".
        System.out.print("\b\b\b\b\b");
        System.out.print("world");
 */

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Settings settings = new Settings();
        File fail = new File(settings.getFilename());
        if (fail.exists()) {
            int result = settings.loadFromFile();
            if (result == 0) {
                System.out.println("Seaded edukalt failist laetud");
            } else {
                System.out.println("Seadete automaatne laadimine ebaõnnestus");
            }
        }

        Scanner sc = new Scanner(System.in);
        String mapString = "";
        int width = 0;
        int height = 0;
        boolean random = false;
        System.out.println("Tere tulemast!");
        System.out.println("Seadete kuvamiseks kirjuta 'LIST', seadeid saab muuta kujul 'SEADE:VÄÄRTUS'");
        System.out.println("Seadete laadimiseks failist kirjuta 'LOAD' ja salvestamiseks 'SAVE'");
        System.out.println("Mängulaua loomiseks kirjuta selle read, surnud ruudu jaoks tühik ja elava ruudu jaoks mõni muu sümbol");
        System.out.println("Loodud lauaga mängu alustamiseks sisesta lõpuks tühi rida (ka ilma tühikuteta)");
        System.out.println("Kui soovid juhuslikku mängulauda, kirjuta 'RANDOM'");
        System.out.println("Käimas oleva mängu lõpetamiseks vajuta ENTER");
        while (true) {
            String line = sc.nextLine();
            line = line.toLowerCase();
            if (line.isEmpty()) {
                break;
            }
            // Kui rida on seadete jaoks
            boolean onSeade = false;
            for (String setting : settings.getPossibleSettings()) {
                if (line.startsWith(setting)) {
                    onSeade = true;
                    int staatus = settings.changeSetting(line);
                    System.out.println(staatus == 0 ? "Õnnestus" : "Viga");
                    break;
                }
            }
            if (onSeade) {
                continue;
            }

            if (line.startsWith("random")) {
                random = true;
                break;
            }

            if (line.length() > width) {
                width = line.length();
            }
            height++;
            mapString = mapString + line + "\n";
        }
        if ((width == 0 || height == 0) && !random) {
            System.out.println("Viga: kaart on tühi");
            return;
        }
        if (random) {
            width = 20;
            height = 10;
        }
        if (settings.getWidth() > width) {
            width = settings.getWidth();
        }
        if (settings.getHeight() > height) {
            height = settings.getHeight();
        }

        Map map = new Map(width, height);
        if (random) {
            map.randomize(settings.getChance());
        } else {
            map.fromString(mapString);
        }
        while (System.in.available() == 0) {
            map.printMap(settings.getAliveChar(), settings.getDeadChar());
            map.update();
            Thread.sleep((long) (1000 / settings.getFramerate()));
            System.out.println("-".repeat(width));
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
