package train.buffers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import train.exceptions.EmptyBufferException;
import train.exceptions.FullBufferException;

public class StringCircularBufferTest {

    private static int DEFAULT_BUFFER_SIZE = 10;
    private static int USE_DEFAULT = -1;

    private CircularBuffer buffer;

    @BeforeEach
    public void setup() {
        buffer = new StringCircularBuffer();
    }

    @AfterEach
    public void teardown() {
        buffer = null;
    }

    @Test
    public void testCreate_default() {
        prepareTestBuffer(USE_DEFAULT);
        assertEquals(buffer.getSize(), DEFAULT_BUFFER_SIZE);
    }

    @Test
    public void testCreate_sized() {
        int size = 5;
        prepareTestBuffer(size);
        assertEquals(buffer.getSize(), size);
    }

    @Test
    public void testIsEmpty_empty() {
        prepareTestBuffer(USE_DEFAULT);
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void testIsEmpty_nonEmpty() throws FullBufferException {
        prepareTestBuffer(USE_DEFAULT);
        buffer.write("A");
        assertFalse(buffer.isEmpty());
    }

    @Test
    public void testIsFull_full() throws FullBufferException {
        prepareTestBuffer(1);
        buffer.write("A");
        assertTrue(buffer.isFull());
    }

    @Test
    public void testIsFull_nonFull() {
        prepareTestBuffer(USE_DEFAULT);
        assertFalse(buffer.isFull());
    }

    @Test
    public void testReadWrite_anInput_pass() throws FullBufferException, EmptyBufferException {
        String inputA = "A";
        prepareTestBuffer(USE_DEFAULT);
        buffer.write(inputA);
        assertEquals(inputA, buffer.read());
    }

    @Test
    public void testReadWrite_multipleInputs_pass() throws FullBufferException, EmptyBufferException {
        String inputA = "A";
        String inputB = "B";
        String inputC = "C";

        prepareTestBuffer(USE_DEFAULT);
        buffer.write(inputA);
        buffer.write(inputB);
        buffer.write(inputC);

        assertEquals(inputA, buffer.read());
        assertEquals(inputB, buffer.read());
        assertEquals(inputC, buffer.read());
    }

    private void prepareTestBuffer(int size) {
        buffer = new StringCircularBuffer();

        int argSize = size == USE_DEFAULT ? DEFAULT_BUFFER_SIZE : size;
        buffer.create(argSize);
    }

}
