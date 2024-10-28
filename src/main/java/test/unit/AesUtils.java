package test.unit;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @Author xiongyong
 * @Date 2022/4/22
 */

public class AesUtils {
    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    // key 必须是16的倍数
    private static final String BASE64STRING = "123456789abcdefg123456789abcdefg";
    private static final byte[] KEY = BASE64STRING.getBytes();

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * encrypt ： 加密数据
     */
    public static String encrypt(String context) throws Exception {
        return Base64.encodeBase64String(encrypt(context.getBytes("UTF-8"), KEY));
    }

    /**
     * decrypt : 解密数据
     */
    public static String decrypt(String context) throws Exception {
        return new String(decrypt(Base64.decodeBase64(context), KEY));
    }

    /**
     * encrypt ： 加密数据
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 还原密钥
        SecretKey k = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * decrypt : 解密数据
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 欢迎密钥
        SecretKey k = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }


    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("24424%#@%@^DEGFf4564fafa4535");
        System.out.println(decrypt(encrypt));


    }
}
