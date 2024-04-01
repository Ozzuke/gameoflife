import java.util.BitSet;

public class Map {
    private final int width;
    private final int height;
    private BitSet map;
    private BitSet nextMap;

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
}
