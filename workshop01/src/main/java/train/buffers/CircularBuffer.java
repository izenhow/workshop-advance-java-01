package train.buffers;

import train.exceptions.EmptyBufferException;
import train.exceptions.FullBufferException;

public interface CircularBuffer {
    void create();
    void create(int size);
    void write(String input) throws FullBufferException;
    String read() throws EmptyBufferException;
    int getSize();
    boolean isEmpty();
    boolean isFull();
}
