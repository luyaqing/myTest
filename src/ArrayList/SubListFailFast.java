package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 集合中的 fail-fast机制
 */
public class SubListFailFast {

    public static void main(String[] args) {
        List masterList = new ArrayList();

        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);  // 无法序列化，subList返回的是内部类SubList的对象，它是ArrayList的内部类，没有实现序列化接口，无法网络传输

        // 下面三行， 如果不注释掉，下面的branchList的操作抛出  ConcurrentModificationException 异常
//        branchList.remove(0);
//        masterList.add("ten");
//        masterList.clear();

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (Object t : branchList) {
            System.out.println(t);
        }

        // 子列表修改导致主列表也被修改
        System.out.println(masterList);
        System.out.println("--------test  end--------");
    }
}
