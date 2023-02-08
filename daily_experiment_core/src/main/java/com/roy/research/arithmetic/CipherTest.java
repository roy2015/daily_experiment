package com.roy.research.arithmetic;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CipherTest
{
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        
        SecretKey secretkey = keyGen.generateKey();
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.WRAP_MODE, secretkey);
        byte[] bkey = cipher.wrap(secretkey);
        
        cipher.init(Cipher.UNWRAP_MODE, secretkey);
        Key key = cipher.unwrap(bkey, "AES", Cipher.SECRET_KEY);
        
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] b  = cipher.doFinal(" some thing important ".getBytes());
        System.out.println(new String(b));
        
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        byte[] output = cipher.doFinal(b);
        System.out.println(new String(output));
    }
}