package me.walkersneps.snepsbot;


import junit.framework.TestCase;
import me.walkersneps.snepsbotx.utils.SnepsUtils;

public class SnepsUtilsTest extends TestCase{


    public SnepsUtilsTest (String name) {
        super(name);
    }


    public void testStringToInt () throws Exception {
        assertEquals(1, SnepsUtils.stringToInt("1"));
        assertEquals(325, SnepsUtils.stringToInt("325"));
    }

    public void testIntToString () throws Exception {
        assertEquals("123", SnepsUtils.intToString(123));
        assertEquals("9384", SnepsUtils.intToString(9384));
    }

    public void testRandomNumber () throws Exception {
        assertEquals(0, SnepsUtils.randomNumber(1));
        int r = SnepsUtils.randomNumber(4);
        assertTrue(r == 0 | r == 1 | r == 2| r == 3);
    }



}
