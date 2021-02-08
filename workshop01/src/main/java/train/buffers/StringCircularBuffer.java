package train.buffers;

import train.exceptions.EmptyBufferException;
import train.exceptions.FullBufferException;
import train.utils.FifoBufferUtils;

/**
 * The basic {@code String} version implementation of {@link CircularBuffer}.
 */
public class StringCircularBuffer implements CircularBuffer {

    private static int DEFAULT_BUFFER_SIZE = 10;

    private String[] buffer;
    private int readPtr;
    private int writePtr;

    @Override
    public void create() {
        create(DEFAULT_BUFFER_SIZE);
    }

    @Override
    public void create(int size) {
        buffer = new String[size];

        readPtr = 0;
        writePtr = 0;
    }

    @Override
    public void write(String input) throws FullBufferException {
        buffer[writePtr] = input;
        writePtr = nextWrite();
    }

    @Override
    public String read() throws EmptyBufferException {
        String bufferElem = buffer[readPtr];
        readPtr = nextRead();
        return bufferElem;
    }

    @Override
    public int getSize() {
        return buffer.length;
    }

    @Override
    public boolean isEmpty() {
        return readPtr == writePtr;
    }

    @Override
    public boolean isFull() {
        return nextWrite() == readPtr;
    }

    private int nextRead() {
        return FifoBufferUtils.getNextIdx(readPtr, buffer.length);
    }

    private int nextWrite() {
        return FifoBufferUtils.getNextIdx(writePtr, buffer.length);
    }

}
