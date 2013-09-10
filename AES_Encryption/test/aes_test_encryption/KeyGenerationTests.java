/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes_test_encryption;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan Horak
 */
public class KeyGenerationTests {
    
    private char[] charBib = {  'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D',
                                'e', 'E', 'f', 'F','g', 'G', 'h', 'H',
                                'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L',
                                'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P',
                                'q', 'Q', 'r', 'R', 's', 'S', 't', 'T',
                                'u', 'U',
                                'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y',
                                'z', 'Z'};
    
    private char[] xTraChars = {'!', '"', '%', '&', '/', '(', ')',
                                '?', '=', '`','+', '*', '~', '#',
                                '<', '>', '|', ';', ',', '.', ':', '-',
                                '_', '@', '^'};
    
    private char[] numbers = {  '1', '2', '3', '4', '5', '6', '7', '8', 
                                '9', '0' };
    
    // Attention: § ´ ° have a Bytesize of 2
    
    private final int KEYSIZE = 32;
    
    private int random = 0;
    
    private final int KEYTESTS = 100000;
    
    private boolean debugOutput = false;
    
    @Test
    public void shouldReturnedA32ByteKey(){
        for ( int i = 0; i < KEYTESTS; i++ ){
            String key = returnShuffledKey();
            try {
                assertTrue(key.getBytes("UTF-8").length == 32);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(KeyGenerationTests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String generateKey(){
        int sizeBuffer = 0;
        int counter = 0;
        String result = "";
        int amountChars = (int) (Math.random()*(25-20)+20);
        sizeBuffer = KEYSIZE-amountChars;

        int amountXtraChars = (int) (Math.random()*(sizeBuffer-sizeBuffer)+5);
        sizeBuffer -= amountXtraChars;
        
        int amountNumbers = (int) (Math.random()*(sizeBuffer-sizeBuffer)+sizeBuffer);
        sizeBuffer -= amountNumbers;
        assertTrue(sizeBuffer == 0);

        while ( counter < amountChars ){
            random = (int) (Math.random()*charBib.length-1+0);
            result+= charBib[random];
            counter++;
        }
        sizeBuffer += counter;
        counter = 0;
        while ( counter < amountXtraChars ){
            random = (int) (Math.random()*xTraChars.length-1+0);
            result+= xTraChars[random];
            counter++;
        }
        sizeBuffer += counter;
        counter = 0;
        while ( counter < amountNumbers ){
            random = (int) (Math.random()*numbers.length-1+0);
            result += numbers[random];
            counter++;
        }
        if ( debugOutput ){
            System.out.println(result);
        }
        return result;
    }
    
    
    public String returnShuffledKey(){
        String key = generateKey();
        StringBuilder finalKey = new StringBuilder(key.length());
        List<Character> chars = new ArrayList<>();
        for ( char c : key.toCharArray()){
            chars.add(c);
        }
        while(!chars.isEmpty()){
            int randPicker = (int)(Math.random()*chars.size());
            finalKey.append(chars.remove(randPicker));
        }
        if ( debugOutput ){
            System.out.println(finalKey.toString());
        }
        return finalKey.toString();
    }
    
    
    public String returnRandomWord(int sizeMax, int sizeMin){
        int counter = 0;
        String result = "";
        while (counter < sizeMax){
            random = (int) (Math.random()*(sizeMax-sizeMin)+sizeMin);
            result+= charBib[random];
            counter++;
        }
        return result;
    }
    
}