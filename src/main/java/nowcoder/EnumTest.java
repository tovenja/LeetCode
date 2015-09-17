package nowcoder;

/**
 * 测试结果:
 * invoke once
 * invoke once
 * invoke once
 * BLUE
 * 表示枚举类型是静态final实例,随着enum类加载而实例化
 * Created by blank on 2015-09-01 下午2:32.
 */
public class EnumTest {
    enum Color{
        RED,BLUE,GREEN;
        private Color(){
            System.out.println("invoke once");
        }
    }

    public static void main(String[] args) {
//        错误 赋值
//        Color.BLUE = Color.RED;
        System.out.println(Color.BLUE);
    }
}
