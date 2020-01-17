package ArrayList;


import java.util.ArrayList;
import java.util.List;

public class ArrayListFailFast {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
       // list.add("four");
       // 删除完这一行，是不会报错的 ConcurrentModificationException, 因为这个是特殊情况，当指针到达 1 时，remove了元素之后，所有的元素往前拷贝 siz = 2， cursor = 2
        // 直接退出了循环，因为 cursor = size, 没有机会执行到check方法。所以不会报错

        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }

        System.out.println(list);
    }
}
