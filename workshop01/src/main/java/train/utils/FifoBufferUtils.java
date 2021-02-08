package train.utils;

public class FifoBufferUtils {
    public static int getNextIdx(int idx, int length) {
        return ++idx % length;
    }
}
