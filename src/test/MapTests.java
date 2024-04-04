package test;

import main.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapTests {
    @Test
    public void isAlive(){
        Map map = new Map(2, 2);
        boolean a = map.isAlive(2,2);
        Assertions.assertEquals(true, a);
    }
}
