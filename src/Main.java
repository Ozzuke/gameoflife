import java.io.File;
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
    public static void main(String[] args) throws InterruptedException {
        Settings settings = new Settings();
        File fail = new File(settings.getFilename());
        if (fail.exists()) {
            int result = settings.loadFromFile();
            if (result == 0) {
                System.out.println("Seaded edukalt laetud");
            } else {
                System.out.println("Seadete laadimine ebaõnnestus");
            }
        }


        Scanner sc = new Scanner(System.in);
        String mapString = "";
        int width = 0;
        int height = 0;
        System.out.println("Sisesta ükshaaval read (tühik surnud ruut, muu täht elus ruut, tühi rida lõpetab) või säte mida muuta:");
        while (true) {
            String line = sc.nextLine();
            line = line.toLowerCase();
            if (line.isEmpty()) {
                break;
            }
            for (String setting : settings.getPossibleSettings()) {
                if (line.startsWith(setting)) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        switch (setting) {
                            case "framerate":
                                settings.setFramerate(Double.parseDouble(parts[1]));
                                break;
                            case "aliveChar":
                                settings.setAliveChar(parts[1].charAt(0));
                                break;
                            case "deadChar":
                                settings.setDeadChar(parts[1].charAt(0));
                                break;
                            case "width":
                                width = Integer.parseInt(parts[1]);
                                break;
                            case "height":
                                height = Integer.parseInt(parts[1]);
                                break;
                            case "filename":
                                settings.setFilename(parts[1]);
                                break;
                            case "load":
                                settings.loadFromFile();
                                break;
                        }
                    }
                }
            }
        }
    }
}
