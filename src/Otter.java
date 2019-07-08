/**
 * 匿名内部类中的 final
 *
 * 也就是说在内部类打印变量 a 的值时，这个变量 a 不是外部的局部变量 a，因为如果是外部局部变量的话，应该会使用 load指令加载变量的值
 *
 * 也就是说系统以拷贝的形式把外部局部变量 a 复制了一个副本到内部类中，内部类有一个变量指向外部变量a所指向的值。
 */
public class Otter {

    public static void main(String[] args) {
        final int a = 10;

        new Thread(){
            @Override
            public void run(){
                System.out.println(a);
            }
        }.start();
    }

}
