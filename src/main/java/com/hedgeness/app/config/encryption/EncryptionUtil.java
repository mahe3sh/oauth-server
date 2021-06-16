package com.hedgeness.app.config.encryption;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.*;

@Component
public class EncryptionUtil {
    @Autowired
    private KeyPair keyPair;
    @Autowired
    private Cipher cipher;

    public String encryptText(String msg) throws  UnsupportedEncodingException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

        return Base64.encodeBase64String(cipher.doFinal(msg.getBytes("UTF-8")));
    }

    
    public String decryptText(String msg) throws InvalidKeyException, UnsupportedEncodingException,
            IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(Base64.decodeBase64(msg)), "UTF-8");
    }
}
