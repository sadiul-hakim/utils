package Practice;

import jakarta.inject.Inject;

/**
 *
 * @author Hakim
 */
public class UserService {
    @Inject
    @Remote
    private UserRepository userRepository;
    
    @Inject
    @Sha256
    private PasswordEncryption passwordEncryption;

    public UserService(UserRepository userRepository, PasswordEncryption passwordEncryption) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryption;
    }
    
    public Object saveUser(User user){
        user.setPassword(passwordEncryption.encrypt(user.getPassword()));
        return userRepository.save(user);
    }
    
}
