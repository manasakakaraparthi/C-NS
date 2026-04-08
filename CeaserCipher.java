import java.util.*;

class CeaserCipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypt = "";
        String decrypt = "";

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encrypt += (char)((ch - base + shift) % 26 + base);
            } else {
                encrypt += ch;
            }
        }

        // Decryption
        for (int i = 0; i < encrypt.length(); i++) {
            char ch = encrypt.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                decrypt += (char)((ch - base - shift + 26) % 26 + base);
            } else {
                decrypt += ch;
            }
        }

        System.out.println("Encrypted text: " + encrypt);
        System.out.println("Decrypted text: " + decrypt);
    }
}