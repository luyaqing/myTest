
public class CodeTest {
    private int a;
    private static int b;
    // 最终的答案
    public static int countDigitOne(int n, char ch) {
        int ones = 0;
        int temp = ch - '0';
        for (long m = 1; m <= n; m *= 10){
            ones += (n/m + 9-temp) / 10 * m + (n/m % 10 == temp ? n%m + 1 : 0);
        }
        return ones;
    }

    // 递归的思路, 不对 ，当传入 20 2的时候会出现错误的情况（良良做的）
    public static int getTime(int num, int ch){
        if(num == 0){
            return 0;
        }else if(num <= 9){
            return num >= ch?1:0;
        }
        int time = 0;
        // 先算位数
        int length = getLength(num);
        int pow = (int) Math.pow(10, (length - 1));
        time += (length -1)*pow/10;
        //再算首位
        int first = num/pow;
        time = first * time;
        if(first > ch){
            time +=pow;
        }else if(first == ch){
            time +=num%pow;
        }
        time += getTime(num%pow,ch);
        return time;
    }
    public static int getLength(int num){
        int length = 1;
        while (num > 9){
            num /= 10;
            length ++;
        }
        return length;
    }

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
       //System.out.println( 1 << COUNT_BITS );
        //System.out.println( (1 << COUNT_BITS) - 1 );
       // System.out.println( -1 << COUNT_BITS);
        //System.out.println( 0 << COUNT_BITS);

        /*char a = 'c';
        int b = a;
        System.out.println(b);*/

//        int a = 0, i;
//        for (i = a; i >= 0; i--) {
//            a++;
//            System.out.println(a);
//        }
//
//        int[] array = new int[4];
//        int b = array.length;

//        Deque<Integer> deque = new LinkedList<>();
//        deque.push(1);
//        deque.push(2);
//        deque.push(3);
//
//        System.out.println(deque.peek());
//        System.out.println(deque);
//        System.out.println(deque.pop());
//        System.out.println(deque);

        int ones = countDigitOne(222222, '2');
        System.out.println(ones);

       // int ones_2 = getTime(20, 2);
       // System.out.println(ones_2);
        //System.out.println(2%10);
    }
}
