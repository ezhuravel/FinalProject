package main.State;

import main.Factory.*;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class PlayerAliveStateTest {

    @Test
    public void testTransition() {
        Tank tank = Tank.getTankInstance();
        tank.setHealth(-101);
        tank.getGameStatus();
        assertThat(tank.getCurrentState(), instanceOf(PlayerDeadState.class));

    }

    @Test
    public void testTransition2() {
        Tank tank = Tank.getTankInstance();
        tank.setHealth(0);
        assertThat(tank.getCurrentState(), instanceOf(PlayerAliveState.class));
    }
}