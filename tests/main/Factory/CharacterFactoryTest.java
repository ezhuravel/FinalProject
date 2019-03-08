package main.Factory;

import main.State.PlayerState;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class CharacterFactoryTest {

    @Test
    public void createTankCharacter() {
        CharacterFactory cf = new CharacterFactory();
        Character tank = cf.CreateCharacter("Player");
        assertThat(tank, instanceOf(Tank.class));
    }

    @Test
    public void createHealthUpCharacter() {
        CharacterFactory cf = new CharacterFactory();
        Character healthup = cf.CreateCharacter("Health");
        assertThat(healthup, instanceOf(HealthUp.class));
    }

    @Test
    public void createEnemyCharacter() {
        CharacterFactory cf = new CharacterFactory();
        Character enemy = cf.CreateCharacter("Enemy");
        assertThat(enemy, instanceOf(Enemy.class));
    }

    @Test
    public void invalidCharacter(){
        CharacterFactory cf = new CharacterFactory();
        Character invalid = cf.CreateCharacter("invalid");
        assertNull(invalid);
    }
}