package proxy;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private Set<String> permissionList;

    public User(String name){
        this.username = name;
        this.permissionList = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void addPermissionToDocument(String identeifier){
        this.permissionList.add(identeifier);
    }

    public Set<String> getPermissionList() {
        return permissionList;
    }
}
