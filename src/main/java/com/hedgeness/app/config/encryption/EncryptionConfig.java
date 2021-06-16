package com.hedgeness.app.config.encryption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.*;

@Configuration
public class EncryptionConfig {

    @Value("${hedgeapp.encryption.key.filepath}")
    private String filePath;
    @Value("${hedgeapp.encryption.key.alias}")
    private String alias;
    @Value("${hedgeapp.encryption.key.keystorepassword}")
    private String keystorepassword;
    @Value("${hedgeapp.encryption.key.keypassword}")
    private String keypass;
    @Value("${hedgeapp.encryption.key.keystoretype}")
    private String keystoretype;
    @Value("${hedgeapp.encryption.key.algorithm}")
    private String algorithm;
    @Value("${hedgeapp.encryption.key.enabled}")
    private String enabled;
    
    
    @Bean
    public  KeyPair getKeyPairFromKeyStore() throws Exception {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        KeyStore keyStore = KeyStore.getInstance(keystoretype);
        keyStore.load(inputStream, keystorepassword.toCharArray());   //Keystore password
        KeyStore.PasswordProtection keyPassword =       //Key password
                new KeyStore.PasswordProtection(keypass.toCharArray());
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, keyPassword);
        java.security.cert.Certificate cert = keyStore.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
        return new KeyPair(publicKey, privateKey);
    }
    @Bean
    public Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        return cipher;
    }
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
    
    
}
