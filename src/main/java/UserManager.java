import java.util.ArrayList;
import java.util.Collection;

public class UserManager {
    //private Collection<String> userStorage;
    ArrayList<String> userStorage;

    public UserManager(){
        userStorage = new ArrayList<>();
    }
    // Create an UserEmail
    public boolean addUser(String userEmail){
        return userStorage.add(userEmail);
    }
    //Read UserEmail
    public String getUser(String userEmail){
        for(String s : userStorage){
            if(s.equals(userEmail)){
                return s;
            }
        }
        return null;
    }
    //Delete UserEmail
    public boolean deleteUser(final String userEmail){
        return userStorage.removeIf(e -> e.equals(userEmail));
    }
}
