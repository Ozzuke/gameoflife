import main.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockingExtension.class)
public class MapTests {

    @Test
    public void isAlive_returnsFalse_whenCellIsDead() {
        Map map = new Map(2, 2);
        assertFalse(map.isAlive(1,1));
    }

    @Test
    public void isAlive_returnsTrue_whenCellIsAlive() {
        Map map = new Map(2, 2);
        map.setAlive(1,1);
        assertTrue(map.isAlive(1,1));
    }

    @Test
    public void nextStep_returnsNewMap_withCorrectAliveCells() {
        Map map = new Map(3, 3);
        map.setAlive(1,0);
        map.setAlive(1,1);
        map.setAlive(1,2);
        Map next = Map.nextStep(map);
        assertTrue(next.isAlive(0,1));
        assertTrue(next.isAlive(1,1));
        assertTrue(next.isAlive(2,1));
    }

    @Test
    public void update_updatesMap_withNextStep() {
        Map map = new Map(3, 3);
        map.setAlive(1,0);
        map.setAlive(1,1);
        map.setAlive(1,2);
        map.update();
        assertTrue(map.isAlive(0,1));
        assertTrue(map.isAlive(1,1));
        assertTrue(map.isAlive(2,1));
    }

    @Test
    public void fromString_setsCorrectCellsAlive() {
        Map map = new Map(3, 3);
        map.fromString(" *\n *\n *");
        assertTrue(map.isAlive(1,0));
        assertTrue(map.isAlive(1,1));
        assertTrue(map.isAlive(1,2));
    }
}