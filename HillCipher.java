
import java.util.Scanner;

class HillCipherSimple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String key;
        String text;

        int[][] keyMatrix = new int[2][2];

        System.out.print("Enter 4 letter key: ");
        key = sc.next().toUpperCase();

        int k = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = key.charAt(k) - 'A';
                k++;
            }
        }

        System.out.print("Enter text (even letters): ");
        text = sc.next().toUpperCase();

        if (text.length() % 2 != 0) {
            text = text + "X";
        }

        String cipher = "";

        for (int i = 0; i < text.length(); i += 2) {

            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i + 1) - 'A';

            int c1 = (keyMatrix[0][0] * p1 + keyMatrix[0][1] * p2) % 26;
            int c2 = (keyMatrix[1][0] * p1 + keyMatrix[1][1] * p2) % 26;

            cipher += (char) (c1 + 'A');
            cipher += (char) (c2 + 'A');
        }

        System.out.println("Cipher Text: " + cipher);
    }
}

