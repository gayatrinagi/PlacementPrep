// User function Template for Java

class Solution {
    public static void addBS(int n,String curr,List<String> result,int lastplace){
        if(n==0){
            result.add(curr);
            return;
        }
        addBS(n-1,curr+"0",result,0);//doesnt matter what the last place was if 1 then also 0 can come if 0 then also 0 can come
        if(lastplace==0){
            addBS(n-1,curr+"1",result,1);//if last place was 0 then add 1 because cant have 11 
        }
    }
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> result=new ArrayList<String>();
        addBS(n,"", result,0);
        return result;
        
    }
}
