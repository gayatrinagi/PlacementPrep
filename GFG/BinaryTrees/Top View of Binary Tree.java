/*
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static class Info {
        Node node;
        int hd;
        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Info> q = new LinkedList<>();
        TreeMap<Integer, Integer> topMap = new TreeMap<>();

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();
            if (!topMap.containsKey(curr.hd)) {
                topMap.put(curr.hd, curr.node.data);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
            }
        }

        result.addAll(topMap.values());
        return result;
    }
}
