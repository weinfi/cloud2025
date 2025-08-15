import org.junit.jupiter.api.Test;

public class test1 {
    @Test
    public void test1(){
        // 1. 直接引用枚举常量
        Season spring = Season.SPRING;
        System.out.println(spring);  // 输出: SPRING

        // 2. 获取枚举的名称
        String name = spring.name();
        System.out.println(name);    // 输出: SPRING

        // 3. 获取枚举的序号
        int ordinal = spring.ordinal();
        System.out.println(ordinal); // 输出: 0

        // 4. 获取枚举的自定义值
        int value = spring.getValue();
        System.out.println(value);   // 输出: 1

        // 5. 获取所有枚举常量
        Season[] seasons = Season.values();
        for (Season s : seasons) {
            System.out.println(s);   // 输出: SPRING, SUMMER, AUTUMN, WINTER
            System.out.println("ordinal: "+s.ordinal());
        }

        // 6. 字符串转换为枚举
        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer);  // 输出: SUMMER

        // 注意：valueOf区分大小写，如果找不到匹配的枚举常量会抛出IllegalArgumentException
        try {
            Season.valueOf("spring"); // 会抛出异常
        } catch (IllegalArgumentException e) {
            System.out.println("枚举常量不存在");
        }
    }

    @Test
    void test2(){
        ErrorCode success = ErrorCode.SUCCESS;
        System.out.println(success);
        System.out.println(success.getCode()+"---"+success.getMessage());

    }
}
enum Season {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private final int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

enum ErrorCode {
    SUCCESS(0, "操作成功"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_ERROR(500, "服务器内部错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
