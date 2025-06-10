class Solution {
    class TreeInfo{
        int height;
        int diameter;
        TreeInfo(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }
    int diameter(Node root) {
        return computeDiam(root).diameter;
        
    }
    private TreeInfo computeDiam(Node node){
        if(node==null){
            return new TreeInfo(-1, 0);
        }
        TreeInfo left=computeDiam(node.left);
        TreeInfo right=computeDiam(node.right);
        int currentHeight=Math.max(left.height,right.height)+1;
        int diamRoot=left.height+right.height+2;
        int currDiam=Math.max(diamRoot,Math.max(left.diameter,right.diameter));
        return new TreeInfo(currentHeight,currDiam);
    }
}
