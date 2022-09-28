package Practice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Hakim
 */
public class Main {
    public static void main(String[] args) {
        Weld weld=new Weld();
        WeldContainer container=weld.initialize();
        
        UserService userService=container.select(UserService.class).get();
        userService.saveUser(new User("Hakim","hakim@gmail.com","hakim@123"));
    }
}
