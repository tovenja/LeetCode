package nowcoder;

/**
 * 测试结果:finally里的代码一定会执行的,如果try和finally里都有return语句
 * 则返回的是finally里的语句,try里的return如果是语句会被执行,但值会被忽略.
 *
 * Created by blank on 2015-08-31 下午12:08.
 */
public class ReturnTest {

    public static void main(String[] args) {

        int a = 0;
        System.out.println(returnTestInt());
        System.out.println(returnTest());
    }


    public static int returnTestInt() {
        int a = 0;
        try {
            return ++a;
        } catch (Exception e) {

        } finally {
            return a++;
        }
    }

    public static boolean returnTest() {
        try {
            return true;
        } catch (Exception e) {

        } finally {

            return false;
        }

    }
}
