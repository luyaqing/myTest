/**
 * 方法的内联
 *
 *   如果使用 final 修饰一个了一个方法 a，在其他调用方法 a 的类进行编译时，方法 a 的代码会直接嵌入到调用 a 的代码块中。
 *   反编译 命令  javap -c xxx.class
 */

public class MethodInline {

    public static void test(){
        String s1 = "包夹方法a";
        a();
        String s2 = "包夹方法a";
    }

    private static final void a() {
        System.out.println("我是方法a中的代码");
    }

}
