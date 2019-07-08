
public class ByteCodeTest {

    public static void main(String[] args){
        ClassLoader classLoader = ByteCodeTest.class.getClassLoader();

        while(classLoader != null){
            System.out.println(classLoader.toString());

            classLoader = classLoader.getParent();
        }
        //System.out.println("ByteCode Test");

        /**
         * 结果：
         *       sun.misc.Launcher$AppClassLoader@18b4aac2  应用类加载器
         *       sun.misc.Launcher$ExtClassLoader@4554617c  拓展类加载器
         */
    }
}
