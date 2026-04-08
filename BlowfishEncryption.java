import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class BlowfishEncryption {

    public static void main(String[] args) {
        try {
            String plaintext = "Hello World";
            String keyString = "MySecretKey";   // Your own key

            // Create key
            SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), "Blowfish");

            // Create cipher
            Cipher cipher = Cipher.getInstance("Blowfish");

            // Initialize for encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // Encrypt
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

            // Convert to Base64 for readable output
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Original Text: " + plaintext);
            System.out.println("Encrypted Text: " + encryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}