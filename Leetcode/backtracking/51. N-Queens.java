class Solution {
    public static boolean isSafe(char[][]board, int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char[][]board,int row,List<List<String>> result){
        if(row==board.length){
            result.add(construct(board));
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueens(board,row+1,result);
                board[row][j]='.';
            }
        }
    }
    public static List<String> construct(char[][] board){
        List<String> ans=new ArrayList<>();
        for(char[] row:board){
            ans.add(new String(row));
        }
        return ans;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][]board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }
        nQueens(board,0,result);
        return result;
    }
}
