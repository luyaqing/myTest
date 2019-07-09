/**
 * 数值计算-数字魔法
 *
 *  Integer的范围为-2147483648~2147483647
 *      Integer.MIN_VALUE，它的十六进制表示是 0x80000000。其符号位为1，其余所有的位都是0。
 *      取负数(反码+1)则为 0x7fffffff+1，也就是 0x80000000。你会发现对Integer.MIN_VALUE取负值还是本身。因此，结果还是负数。
 *
 *      是否存在一个数i，可以使其满足i+1<i，这样看来，这个i就是Integer.MAX_VALUE，因为加完1就溢出了变为负值了。
 *      是否存在一个数，满足i != 0 && i == -i; 其实还是Integer.MIN_VALUE
 *
 *      对Long、Short、Byte都成立
 */
public class MathTest {

    public static void main(String[] args){
        /**
         * 缓存问题  Integer内部有一个IntegerCache缓存。对于值范围在-128到127之间的数，会进行缓存。因此a和b范围在-128到127之间
         */


        /**
         * 越界问题
         */
        int min = Integer.MIN_VALUE;

        System.out.println(min);
        System.out.println(Math.abs(min));

        System.out.println();

        short num = Short.MIN_VALUE;
        System.out.println(num);
        // 这里不强转为short的话， 会被转为int型的。强转之后才会有异常
        System.out.println((short)Math.abs(num));
        System.out.println();

        /**
         * 浮点数
         */
        // 是否存在一个数，满足i==i+1  无穷小也是一样
        double i = Double.POSITIVE_INFINITY;
        System.out.println(i == i + 1);
        System.out.println(i == i - 1);

        double nan = Double.NaN;
        System.out.println(nan != nan);
    }
}
