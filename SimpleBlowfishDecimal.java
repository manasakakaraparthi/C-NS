public class SimpleBlowfishDecimal {

    static final int ROUNDS = 16;

    // P-array (18 subkeys) – DECIMAL VALUES ONLY
    static int[] P = {
        1, 3, 5, 7, 9, 11, 13, 15,
        17, 19, 21, 23, 25, 27, 29, 31,
        33, 35
    };

    // Simplified S-Boxes (decimal values)
    static int[] S1 = {101, 203, 305, 407};
    static int[] S2 = {509, 611, 713, 815};
    static int[] S3 = {917, 1019, 1121, 1223};
    static int[] S4 = {1325, 1427, 1529, 1631};

    // F-function (simple and exam-friendly)
    static int F(int x) {
        int a = (x >> 24) & 3;
        int b = (x >> 16) & 3;
        int c = (x >> 8) & 3;
        int d = x & 3;

        int result = S1[a] + S2[b];
        result = result ^ S3[c];
        result = result + S4[d];

        return result;
    }

    // Encryption function
    static void encrypt(int[] data) {
        int L = data[0];
        int R = data[1];

        for (int i = 0; i < ROUNDS; i++) {
            L = L ^ P[i];
            R = R ^ F(L);

            // Swap
            int temp = L;
            L = R;
            R = temp;
        }

        // Undo last swap
        int temp = L;
        L = R;
        R = temp;

        R = R ^ P[16];
        L = L ^ P[17];

        data[0] = L;
        data[1] = R;
    }

    public static void main(String[] args) {

        int[] data = {10, 20};   // Plaintext

        System.out.println("Before Encryption:");
        System.out.println("L = " + data[0] + " R = " + data[1]);

        encrypt(data);

        System.out.println("After Encryption:");
        System.out.println("L = " + data[0] + " R = " + data[1]);
    }
}