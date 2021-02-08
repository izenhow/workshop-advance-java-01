package train.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CircularBufferUtilsTest {

    @Test
    public void testGetNextIdx_incrementalIdx() {
        int length = 15;
        int currIdx = 2;
        int expected = 3;

        assertEquals(expected, CircularBufferUtils.getNextIdx(currIdx, length));
    }

    @Test
    public void testGetNextIdx_startOverIdx() {
        int length = 15;
        int currIdx = 14;
        int expected = 0;

        assertEquals(expected, CircularBufferUtils.getNextIdx(currIdx, length));
    }

}
