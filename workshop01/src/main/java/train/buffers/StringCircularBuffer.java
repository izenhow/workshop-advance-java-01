package train.buffers;

import train.exceptions.FullBufferException;

/**
 * The basic {@code String} version implementation of {@link CircularBuffer}.
 */
public class StringCircularBuffer implements CircularBuffer {

    @Override
    public void create() {
        // TODO Auto-generated method stub
    }

    @Override
    public void create(int size) {
        // TODO Auto-generated method stub
    }

    @Override
    public void write(String input) throws FullBufferException {
        // TODO Auto-generated method stub

    }

    @Override
    public String read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

}