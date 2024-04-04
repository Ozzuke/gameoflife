public class Settings {
    private double framerate;
    private char aliveChar;
    private char deadChar;
    private int width;
    private int height;
    private String filename;
    private final String[] possibleSettings = {"framerate", "aliveChar", "deadChar", "width", "height", "filename", "load"};

    public Settings() {
        this.framerate = 2.5;
        this.aliveChar = '█';
        this.deadChar = ' ';
        this.width = 0;
        this.height = 0;
        this.filename = "settings.txt";
    }

    public int loadFromFile() {
        // TODO
        return 0;
    }

    public void saveToFile() {
        // TODO
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
