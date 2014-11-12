import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;


public class Crypt {
	
	public KeyPair createKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
				
		return keyPairGenerator.generateKeyPair();
	}
	
	public void saveKeyPair() {
		
	}
}
