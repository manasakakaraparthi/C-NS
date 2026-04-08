import java.security.MessageDigest;
public class SHA1Example {
	public static void main(String[] args){
		try{
			String message="Hello World";
			MessageDigest md=MessageDigest.getInstance("SHA-1");
			byte[] messageBytes=message.getBytes();
			byte[] digestBytes=md.digest(messageBytes);
			StringBuilder hexString=new StringBuilder();
			for(byte b : digestBytes){
				String hex=Integer.toHexString(0xff & b);
				if(hex.length()==1)hexString.append('0');
				hexString.append(hex);
			}
			System.out.println("Original Message: "+message);
			System.out.println("SHA-1 Digest: "+ hexString.toString());
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}