package train.buffers;

import train.exceptions.EmptyBufferException;
import train.exceptions.FullBufferException;
import train.utils.CircularBufferUtils;

/**
 * The basic {@code String} version implementation of {@link CircularBuffer}.
 */
public class StringCircularBuffer implements CircularBuffer {

    private static int DEFAULT_BUFFER_SIZE = 10;

    private String[] buffer;
    private int readPtr;
    private int writePtr;

    private boolean isFull;
    private boolean isEmpty;

    @Override
    public void create() {
        create(DEFAULT_BUFFER_SIZE);
    }

    @Override
    public void create(int size) {
        buffer = new String[size];

        readPtr = 0;
        writePtr = 0;
        isFull = false;
        isEmpty = true;
    }

    @Override
    public void write(String input) throws FullBufferException {
        if (isFull()) {
            throw new FullBufferException();
        }

        buffer[writePtr] = input;
        writePtr = nextWrite();
        setWriteState();
    }

    @Override
    public String read() throws EmptyBufferException {
        if (isEmpty()) {
            throw new EmptyBufferException();
        }

        String bufferElem = buffer[readPtr];
        readPtr = nextRead();
        setReadState();

        return bufferElem;
    }

    @Override
    public int getSize() {
        return buffer.length;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public boolean isFull() {
        return isFull;
    }

    private int nextRead() {
        return CircularBufferUtils.getNextIdx(readPtr, buffer.length);
    }

    private int nextWrite() {
        return CircularBufferUtils.getNextIdx(writePtr, buffer.length);
    }

    private boolean isPtrOverlap() {
        return writePtr == readPtr;
    }

    private void setReadState() {
        isFull = false;
        if (isPtrOverlap()){
            isEmpty = true;
        }
    }

    private void setWriteState() {
        isEmpty = false;
        if (isPtrOverlap()){
            isFull = true;
        }
    }

}
