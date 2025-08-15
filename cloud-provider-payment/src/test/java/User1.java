import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true,fluent = true)
public class User1 {
    private int id;
    private String username;
    private int age;
    // 其他字段...

    public static void main(String[] args) {
        User1 user1 = new User1();
        System.out.println(user1.id()); // 这个返回的值是int值，因为id为int类型
        System.out.println(user1.id(123)); // 这个返回的对象值是类
        System.out.println(user1.id()); // 再次看看id的属性为，123
        System.out.println(user1.age()); // 查看其age属性，发现为0

        user1.age(666).username("manong");
        System.out.println(user1); // User1(id=0, username=manong, age=123)
        System.out.println(user1.age()); // 123


        User1 user2 = new User1().age(333).username("yanjiuseng");
        System.out.println(user2); // User1(id=0, username=yanjiuseng, age=333)
    }
}

