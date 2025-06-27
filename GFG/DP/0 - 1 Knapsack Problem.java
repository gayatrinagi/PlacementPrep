class Solution {
    
    static int helper(int val[],int wt[],int W,int n,int[][] dp){
        if(W==0|| n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){//valid
            int ans1= val[n-1]+helper(val,wt,W-wt[n-1],n-1,dp);
            int ans2= helper(val,wt,W,n-1,dp);
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }else{
           dp[n][W]= helper(val,wt,W,n-1,dp);
            return dp[n][W];
            
        }
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp=new int [n+1][W+1]; 
        for(int i=0;i<dp.length;i++){//intialization
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(val,wt,W,val.length,dp);
        
    }
}
