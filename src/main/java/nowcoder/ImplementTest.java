package nowcoder;

/**
 * Created by blank on 2015-09-06 下午1:52.
 */
public class ImplementTest extends AbstractTest implements InterfaceTest {

    public static void main(String[] args) {
        AbstractTest fa = new ImplementTest();
        fa.conMethod();

        Thread 啊 = new Thread();
        啊.start();
    }





    @Override
    public void test() {
        this.conMethod();
    }


    @Override
    void conMethod() {
        System.out.println("son method");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
