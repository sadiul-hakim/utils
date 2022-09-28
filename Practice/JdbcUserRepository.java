package Practice;

import javax.enterprise.inject.Default;

/**
 *
 * @author Hakim
 */
@Default
public class JdbcUserRepository implements UserRepository{

    @Override
    public User save(User user) {

        return user;
    }
    
}
