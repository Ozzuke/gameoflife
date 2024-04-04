package main;

import java.util.BitSet;

public class Map {
    private final int laius;
    private final int pikkus;
    private BitSet map;

    public Map(int laius, int pikkus) {
        this.laius = laius;
        this.pikkus = pikkus;
        this.map = new BitSet(laius * pikkus);
    }

    public int getLaius() {
        return laius;
    }
    public int getKõrgus() {
        return pikkus;
    }

    public void setAlive(int x, int y) {
        map.set(y * laius + x);
    }
    public void setDead(int x, int y) {
        map.clear(y * laius + x);
    }
    public boolean isAlive(int x, int y) {
        return map.get(y * laius + x);
    }

    public void printMap(char elusTäht, char surnudTäht) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < pikkus; y++) {
            for (int x = 0; x < laius; x++) {
                sb.append(isAlive(x, y) ? elusTäht : surnudTäht);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static Map nextStep(Map last) {
        Map next = new Map(last.getLaius(), last.getKõrgus());
        // Kõik uued ruudud läbi käia
        for (int y = 0; y < last.getKõrgus(); y++) {
            for (int x = 0; x < last.getLaius(); x++) {
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
                        if (nx < 0 || nx >= last.getLaius() || ny < 0 || ny >= last.getKõrgus()) {
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

    public void värskenda() {
        this.map = nextStep(this).map;
    }

    public void randomize(double võimalus) {
        for (int i = 0; i < laius * pikkus; i++) {
            if (Math.random() < võimalus) {
                map.set(i);
            } else {
                map.clear(i);
            }
        }
    }

    public void olekSõnest(String mapString) {
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
