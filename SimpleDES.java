public class SimpleDES {

    // XOR function
    static int[] xor(int[] a, int[] b) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++)
            r[i] = a[i] ^ b[i];
        return r;
    }

    public static void main(String[] args) {

        // 64-bit plaintext (example)
        int[] plaintext = new int[64];
        for (int i = 0; i < 64; i++)
            plaintext[i] = i % 2;

        // Split into Left & Right
        int[] L = new int[32];
        int[] R = new int[32];

        System.arraycopy(plaintext, 0, L, 0, 32);
        System.arraycopy(plaintext, 32, R, 0, 32);

        // Simple key (same for all rounds)
        int[] key = new int[32];
        for (int i = 0; i < 32; i++)
            key[i] = 1;

        // 16 rounds
        for (int i = 0; i < 16; i++) {
            int[] temp = R;
            R = xor(L, xor(R, key)); // Feistel function
            L = temp;
        }

        // Combine result
        int[] cipher = new int[64];
        System.arraycopy(R, 0, cipher, 0, 32);
        System.arraycopy(L, 0, cipher, 32, 32);

        // Output
        System.out.println("Encrypted Text:");
      for (int i = 0; i < cipher.length; i++) {
    System.out.print(cipher[i]);
}
    }
}