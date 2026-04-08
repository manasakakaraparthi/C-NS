import java.util.*;

class SubstituteCipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        String ctext = "";
        String dtext = "";

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                ctext += " ";
            } else {
                int index = alphabet.indexOf(ch);
                ctext += key.charAt(index);
            }
        }

        System.out.println("Cipher text: " + ctext);

        // Decryption
        for (int i = 0; i < ctext.length(); i++) {
            char ch = ctext.charAt(i);

            if (ch == ' ') {
                dtext += " ";
            } else {
                int index = key.indexOf(ch);
                dtext += alphabet.charAt(index);
            }
        }

        System.out.println("Decrypted text: " + dtext);
    }
}