package test.unit;

import java.util.Arrays;

/**
 * 字节数组追加
 * @author xiongyong
 * @date 2022/7/13 11:21
 **/

public class ArrayAppendUtil {
    public static byte[] arrayAppend(byte[] bytes,byte b) {
        if (bytes == null || bytes.length == 0) {
            return bytes;
        }
        int length = bytes.length;
        byte[] newByte = new byte[length + 1];

        for (int i = 0; i < bytes.length; i++) {
            newByte[i] = bytes[i];
        }
        newByte[length] = b;

        return newByte;
    }

    public static void main(String[] args) {

        byte b = 127;
        byte[] bytes = new byte[3];

        System.out.println(Arrays.toString(arrayAppend(bytes, b)));


    }
}
