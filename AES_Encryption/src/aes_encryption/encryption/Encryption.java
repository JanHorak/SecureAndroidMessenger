/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_encryption.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

/**
 *
 * @author jho
 */
public class Encryption {

    public static String encrypt(String unencryptedString, String key) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, UnsupportedEncodingException {
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES");
        // Set CipherMode
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // Creates the BASE64Encoder
        BASE64Encoder encoder = new BASE64Encoder();
        
        String encryptedTextBytes = encoder.encode(cipher.doFinal(unencryptedString.getBytes("UTF-8")));
        return encryptedTextBytes;
    }
}
