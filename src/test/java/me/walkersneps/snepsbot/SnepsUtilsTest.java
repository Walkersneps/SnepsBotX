package me.walkersneps.snepsbot;


import junit.framework.TestCase;

import static me.walkersneps.sneps.utils.convert.PrimitiveConverter.intToString;
import static me.walkersneps.sneps.utils.convert.PrimitiveConverter.stringToInt;
import static me.walkersneps.sneps.utils.random.Randomizer.randomNumber;

public class SnepsUtilsTest extends TestCase{


    public SnepsUtilsTest (String name) {
        super(name);
    }


    public void testStringToInt () throws Exception {
        assertEquals(1, stringToInt("1"));
        assertEquals(325, stringToInt("325"));
    }

    public void testIntToString () throws Exception {
        assertEquals("123", intToString(123));
        assertEquals("9384", intToString(9384));
    }

    public void testRandomNumber () throws Exception {
        assertEquals(0, randomNumber(1));
        int r = randomNumber(4);
        assertTrue(r == 0 | r == 1 | r == 2| r == 3);
    }



}
