package proxy;

import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;

    private AccessControlService(){};

    public boolean isAllowed(User user, Document document){
        Set<String> list = user.getPermissionList();
        return list.contains(document.getIdentifier());
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

}
