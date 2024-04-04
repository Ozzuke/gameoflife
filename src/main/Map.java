package main;

import java.util.BitSet;

public class Map {
    private final int width;
    private final int height;
    private BitSet map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new BitSet(width * height);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setAlive(int x, int y) {
        map.set(y * width + x);
    }
    public void setDead(int x, int y) {
        map.clear(y * width + x);
    }
    public boolean isAlive(int x, int y) {
        return map.get(y * width + x);
    }

    public void printMap(char aliveChar, char deadChar) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(isAlive(x, y) ? aliveChar : deadChar);
            }
            System.out.println();
        }
    }

    public static Map nextStep(Map last) {
        Map next = new Map(last.getWidth(), last.getHeight());
        // Kõik uued ruudud läbi käia
        for (int y = 0; y < last.getHeight(); y++) {
            for (int x = 0; x < last.getWidth(); x++) {
                int aliveNeighbours = 0;
                // Kõik naaberruudud läbi käia
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        if (dx == 0 && dy == 0) {
                            // Ruut ise vahele jätta
                            continue;
                        }
                        // Naaberruudu koordinaadid
                        int nx = x + dx;
                        int ny = y + dy;
                        if (nx < 0 || nx >= last.getWidth() || ny < 0 || ny >= last.getHeight()) {
                            // Veenduda, et naaberruut on kaardil
                            continue;
                        }
                        if (last.isAlive(nx, ny)) {
                            aliveNeighbours++;
                        }
                    }
                }
                if (last.isAlive(x, y)) {
                    if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        next.setAlive(x, y);
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        next.setAlive(x, y);
                    }
                }
            }
        }
        return next;
    }

    public void update() {
        this.map = nextStep(this).map;
    }

    public void fromString(String mapString) {
        int x = 0;
        int y = 0;
        for (char c : mapString.toCharArray()) {
            if (c == '\n') {
                x = 0;
                y++;
            } else {
                if (c != ' ') {
                    setAlive(x, y);
                } else {
                    setDead(x, y);
                }
                x++;
            }
        }
    }
}
