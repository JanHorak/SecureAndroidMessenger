/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_test_encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan Horak
 */
public class StringEncryptionTests {
    
    
    private final int AMOUNTTESTS = 10000;
    
    private final int MAXSIZEOFWORD = 25;
    private final int MINSIZEOFWORD = 8;
    
    
    @Test
    public void shouldEncryptAndDecryptRandomWords(){
        for ( int i = 0; i < AMOUNTTESTS; i++ ){
            KeyGenerationTests keyTest = new KeyGenerationTests();
            String randomWord = keyTest.returnRandomWord(MAXSIZEOFWORD, MINSIZEOFWORD);
            
            String key = keyTest.returnShuffledKey();
            System.out.println(key.getBytes().length);
            String encString = new String();
            try {
                encString = aes_encryption.encryption.Encryption.encrypt(randomWord, key);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            }
            String decString = new String();
            try {
                decString = aes_encryption.decryption.Decryption.decrypt(encString, key);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(StringEncryptionTests.class.getName()).log(Level.SEVERE, null, ex);
            }
            assertTrue(decString.equals(randomWord));
        }
    }
    
    
    
}