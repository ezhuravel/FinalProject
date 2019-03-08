package main.Singleton;

import main.Factory.Tank;
import org.junit.Test;

import static org.junit.Assert.*;

public class TankTest {

    @Test
    public void testSingleton () {
        Tank t1 = Tank.getTankInstance();
        Tank t2 = Tank.getTankInstance();

        assertEquals(t1, t2);

    }
}