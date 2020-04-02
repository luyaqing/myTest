package CodeTest;

import javax.jnlp.IntegrationService;
import java.util.*;
import java.util.regex.Pattern;

public class test1 {

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(getMaxLengthValid(str));

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        if (scanner.hasNext()) {
//            String str1 = scanner.next();
//
//            String pattern = "^[1-9]$";
//            boolean isInteger = Pattern.matches(pattern, str1);
//            System.out.println("isInteger:" + isInteger);
//        }
//        scanner.close();
//
//        StringBuilder sb = new StringBuilder();
//        List a  = new ArrayList();
//    }


//    Group the People Given the Group Size They Belong To
//    Input: groupSizes = [3,3,3,3,3,1,3]
//    Output: [[5],[0,1,2],[3,4,6]]
//    Explanation:
//    Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
    public static List getRes(int[] gz) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int i = 0; i < gz.length; i++) {
            List<Integer> list = groupMap.computeIfAbsent(gz[i], k -> new ArrayList<>());
            list.add(i);

            if (list.size() == gz[i]) {
                res.add(list);
                groupMap.put(gz[i], new ArrayList<>());
            }
        }

        return res;
    }

//    1-n中，ch字符出现的次数
//    比如： n = 20,  ch = 1， 则 11 算是两个字符的
//    1-10   中 有 2 个
//    11-20 中  有 10个，
    public static int countCh(int n, char ch) {
        int count = 0;
        int temp = ch - '0';
        for (long i = 1; i < n; i *= 10) {
            count += (n/i + 9 - temp) / 10 * i + n/i%10 == temp ?  n%i + 1 : 0;
        }
        return count;
    }

    /**
     * 如何把大写的转换成小写的字母
     *  使用 |32 运算 是转成小写的字母
     *  使用 ^32 运算 是大写转成小写，小写转成大写
     *  使用 &95 运算 是转成大写的字母
     * @param str
     * @return
     */
    public static String getLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = (char)(str.charAt(i) & -33);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 括号是否有效 （）（）才算是有效的
     * @param str
     * @return
     */
    public static boolean isBracketValid(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0)
                    return false;
                else
                    count--;
            }

        }
        return count == 0 ? true : false;
    }

    /**
     * 判断 ()(())(()()()()) 中有效括号的长度是多少
     *  注意点    两个循环，从左到右和从右到左，必须都要，因为 (() 这种情况再从左到右的循环中还得不到结果
     *           两个循环，left和right要赋初始值 0, 不然后面的循环中会导致计算出错！
     * @param str
     * @return
     */
    public static int getMaxLengthValid(String str) {
        int left = 0, right = 0, max = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = 0;
        right = 0;

        for (int i = str.length() - 1; i >=0; i--) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right == left) {
                max = Math.max(max, 2 * left);
            } else if (left > right){
                left = right = 0;
            }
        }

        return max;
    }

    /**
     *   从前序遍历中恢复二叉树
     * @param s
     * @return
     */
    public CommonTest.TreeNode recoverFromPreorder(String s) {

        int level;
        int val;
        Stack<CommonTest.TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length();) {

            for (level = 0; s.charAt(i) == '-'; i++) {
                level++;
            }
            for (val=0; i<s.length() && s.charAt(i) != '-'; i++) {
                val = val * 10 + s.charAt(i) - '0';
            }

            while (stack.size() > level) {
                stack.pop();
            }

            CommonTest.TreeNode treeNode = new CommonTest.TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = treeNode;
                } else {
                    stack.peek().right = treeNode;
                }
            }

            stack.add(treeNode);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }

}
