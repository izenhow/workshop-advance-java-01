package train.utils;

public class CircularBufferUtils {
    public static int getNextIdx(int idx, int length) {
        return ++idx % length;
    }
}
