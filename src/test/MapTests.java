package test;

import main.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class MapTests {
    @Test
    public void isAlive(){
        Map map = new Map(2, 2);
        boolean a = map.isAlive(2,2);
        Assertions.assertEquals(false, a);

    }
}
