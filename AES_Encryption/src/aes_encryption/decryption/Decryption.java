/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_encryption.decryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;

/**
 *
 * @author jho
 */
public class Decryption {

    public static String decrypt(String encryptedString, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
         SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        // Instantiate the cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(cipher.doFinal(decoder.decodeBuffer(encryptedString)));
        } catch (IOException ex) {
            Logger.getLogger(Decryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cant decrypt!!";
    }
}
