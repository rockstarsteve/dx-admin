import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/12
 */
public class Temp {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("tom");
        users.add(user);
        User user2 = new User();
        user2.setName("tom");
        users.add(user2);

        users.forEach(user1 -> {
            user1.setId("23323");
        });


        System.out.println(users);



    }
}
class User{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}