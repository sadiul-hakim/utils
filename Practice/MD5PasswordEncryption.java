package Practice;

import jakarta.enterprise.inject.Default;

/**
 *
 * @author Hakim
 */
@Default
public class MD5PasswordEncryption implements PasswordEncryption{

    @Override
    public String encrypt(String password) {
        return password;

    }
    
}
