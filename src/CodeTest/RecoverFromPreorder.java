package CodeTest;

import java.util.Stack;

/**
 * 1028 Recover a Tree From Preorder Traversal
 *  Input: "1-2--3--4-5--6--7"
 *  Output: [1,2,5,3,4,6,7]
 */


public class RecoverFromPreorder {

    public static TreeNode recoverFromPreOrderTest(String s) {
        Stack<TreeNode> stack = new Stack<>();
        int level;
        int val = 0;

        for (int i = 0; i < s.length();) {

            // 初始化 level
            for (level = 0; s.charAt(i) == '-'; i++) {
                level++;
            }

            // 初始化 val, 注意点，这个地方一定要是 i 来处理， 否则会导致问题
            // 所以会一直循环在这里，因为 i 没有变化
            for (; i < s.length() && s.charAt(i) != '-'; i++) {
                val = val * 10 + s.charAt(i) - '0';
            }

            // 如果level的长度小于stack的容量， stack中删除节点
            while (stack.size() > level) {
                stack.pop();
            }

            TreeNode treeNode = new TreeNode(val);
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

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        System.out.println(recoverFromPreOrderTest(s).val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
