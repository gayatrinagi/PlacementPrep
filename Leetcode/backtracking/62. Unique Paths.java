class Solution {
    public int uniquePaths(int m, int n) {
        int N=m+n-2;//total steps
        int r=Math.min(m-1,n-1);//min for reduced calc in loop
        long result=1;//fact grows faster so store it in long
        for (int i = 1; i <= r; i++) {
            result = result * (N - r + i) / i;//nCr simplified 
        }

        return (int) result;
    }
}
