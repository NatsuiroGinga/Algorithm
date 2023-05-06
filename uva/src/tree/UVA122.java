package tree;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author ginga
 * @since 25/4/2023 下午9:55
 */
public class UVA122 {
    private static final Scanner input = new Scanner(new BufferedInputStream(System.in));
    private static final PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Node root = new Node();

        while (true) {
            String node = input.next();
            node = node.substring(1, node.length() - 1);

            if ("()".equals(node)) break;

            String[] split = node.split(",");
            if (!root.insert(Integer.parseInt(split[0]), split.length == 2 ? split[1] : "")) {
                output.println("not complete");
                return;
            }
        }

        System.out.println(bfs(root));
    }

    private static List<Integer> bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return ans;
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        boolean hasValue;

        Node() {
        }

        boolean insert(int value, String path) {
            if (path.isEmpty()) {
                this.val = value;
                return true;
            }

            Node cur = this;

            for (char dir : path.toCharArray()) {
                switch (dir) {
                    case 'L':
                        if (cur.left == null) cur.left = new Node();
                        cur = cur.left;
                        break;
                    case 'R':
                        if (cur.right == null) cur.right = new Node();
                        cur = cur.right;
                        break;
                }
            }

            if (hasValue) return false;

            cur.val = value;
            cur.hasValue = true;

            return true;
        }
    }
}
