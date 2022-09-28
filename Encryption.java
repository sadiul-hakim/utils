package blogging.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class Encryption {

    public static void main(String[] args) {
        String password = "Hakim@123";

        var en=new Encryption();
        

    }

    public String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            byte[] encryptedBytes = digest.digest(password.getBytes());

            

            for (byte b : encryptedBytes) {
                sb.append(Integer.toHexString(b));
            }

            

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb.toString();
    }
}
