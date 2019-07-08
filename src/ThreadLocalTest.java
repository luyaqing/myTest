import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 多线程处理  ThreadLocalTest
 */
public class ThreadLocalTest {

    /*private static final ThreadLocal<DateFormat> dfThLocal = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue(){
            return  new SimpleDateFormat("yyyy-MM-dd");
        }
    };*/

    // 这里定义为 static 使他变成 强引用，最后调用 remove方法的时候，可以删除掉，
    // 不加的话，它是弱引用，Entry的键会变成null了，垃圾回收的话，无法回收掉。 所以最后要掉remove方法
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {

        new Thread(() -> {

            try{

                for(int i =0; i<100; i++){
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());

                    try{
                        Thread.sleep(2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                threadLocal.remove();
            }
        }, "ThreadLocal_1").start();


        new Thread(() -> {

            try{

                for(int i =0; i<100 ; i++){
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());

                    try{
                        Thread.sleep(2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "ThreadLocal_2").start();
    }
}
