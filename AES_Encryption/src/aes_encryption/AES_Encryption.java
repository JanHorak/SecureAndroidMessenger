/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_encryption;

import aes_encryption.decryption.Decryption;
import aes_encryption.encryption.Encryption;

/**
 *
 * @author jho
 */
public class AES_Encryption {

    /**
     * @param args the command line arguments
     *
     *
     */
    private static String key  = "72270653D(156D24EE2A093277530142";
    
    
    public static void main (String[] args) throws Exception{
        System.out.println(key.getBytes("UTF-8").length + "Byte- Key");
        System.out.println(new Encryption().encrypt("Test",key));
        System.out.println(new Decryption().decrypt("QSGIrcFFiywz6c9qaUgetg==", key));
    }
    
    
}
