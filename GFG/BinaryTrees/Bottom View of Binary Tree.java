class Solution {
    // Function to return a list containing the bottom view of the given tree.
    static class Info{
        Node node;
        int hd;
        Info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Info> q=new LinkedList<>();
        TreeMap<Integer,Integer> bottomMap=new TreeMap<>();
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info curr=q.poll();
            bottomMap.put(curr.hd,curr.node.data);
            
            if(curr.node.left!=null) q.add(new Info(curr.node.left,curr.hd-1));
            if(curr.node.right!=null) q.add(new Info(curr.node.right,curr.hd+1));
        }
        result.addAll(bottomMap.values());
        return result;
        
    }
}
