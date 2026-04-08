import java.math.BigInteger;
import java.util.Scanner;
public class RSAExample{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter prime number p: ");
		BigInteger p=sc.nextBigInteger();
		System.out.print("Enter prime number q: ");
		BigInteger q=sc.nextBigInteger();
		BigInteger n=p.multiply(q);
		BigInteger phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		System.out.print("Enter Public Key e: ");
		BigInteger e=sc.nextBigInteger();
		BigInteger d=e.modInverse(phi);
		System.out.println("\n Public Key(e,n):("+e+","+n+")");
		System.out.println("Private Key(d,n):("+d+","+n+")");
		System.out.println("\nEnter message(number): ");
		BigInteger message=sc.nextBigInteger();
		BigInteger cipher=message.modPow(e,n);
		System.out.println("Encrypted message : "+cipher);
		BigInteger decrypted=cipher.modPow(d,n);
		System.out.println("Decrypted message : "+decrypted);
		sc.close();
	}
}