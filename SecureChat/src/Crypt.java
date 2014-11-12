import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;


public class Crypt {
	
	public KeyPair createKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
				
		return keyPairGenerator.generateKeyPair();
	}
	
	public void saveKeyPair() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		File privateKey = new File("E:/privatekey.txt");
		File publicKey = new File("E:/publickey.txt");
		
		ObjectOutputStream privateOS = new ObjectOutputStream(new FileOutputStream(privateKey));
		ObjectOutputStream publicOS = new ObjectOutputStream(new FileOutputStream(publicKey));
		
		KeyPair keyPair = createKeyPair();
		
		privateOS.writeObject(keyPair.getPrivate());
		publicOS.writeObject(keyPair.getPublic());
		
		privateOS.close();
		publicOS.close();
	}
	
	public KeyPair getKeyPair() throws ClassNotFoundException, IOException, NoSuchAlgorithmException {
		File privateKeyFile = new File("E:/privatekey.txt");
		File publicKeyFile = new File("E:/publickey.txt");
		
		ObjectInputStream privateIS = new ObjectInputStream(new FileInputStream(privateKeyFile));
		ObjectInputStream publicIS = new ObjectInputStream(new FileInputStream(publicKeyFile));
		
		KeyPair keyPair = createKeyPair();
		
		PrivateKey privateKey = (PrivateKey) privateIS.readObject();
		PublicKey publicKey = (PublicKey) publicIS.readObject();
		
		return new KeyPair(publicKey, privateKey);
	}
	
	public static String encryptMessage(String message, PublicKey publicKey) throws Exception {
		Key key = publicKey;
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encrypted = cipher.doFinal(message.getBytes());
		
		String encryptedMessage = new String(encrypted);
		
		return encryptedMessage;
	}
	
	public static String decryptMessage(String message, PrivateKey privateKey) throws Exception {
		Key key = privateKey;
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decrypted = cipher.doFinal(message.getBytes());
		
		String decryptedMessage = new String(decrypted);
		
		return decryptedMessage;
	}
}
