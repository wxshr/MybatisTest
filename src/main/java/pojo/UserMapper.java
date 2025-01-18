package pojo;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User findUserById(int id);
    List<User> findUsersByTags(Map<String, Object> params);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> searchUsers(Map<String, Object> params);
    void insertUsers(List<User> users);
    List<User> findUsersWithPagination(Map<String, Object> params);
}