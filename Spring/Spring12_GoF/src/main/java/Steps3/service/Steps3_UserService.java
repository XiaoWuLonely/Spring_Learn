package Steps3.service;

public class Steps3_UserService {
    public boolean login(String username, String password) {
        System.out.println("login");
        if("admin".equals(username) && "wulong".equals(password)) {
            return true;
        }
        return false;
    }
    public void logout(){
        System.out.println("logout");
    }
}
