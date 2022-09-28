package Practice;

/**
 *
 * @author Hakim
 */
@Remote
public class RemoteUserRepository implements UserRepository{

    @Override
    public User save(User user) {
        return user;
    }
    
}
