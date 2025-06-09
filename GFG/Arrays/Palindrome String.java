class Solution {
    boolean isPalindrome(String s) {
        // code here
        if(s.length()<=1){
            return true;
        }
        boolean palindrome=true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                palindrome=false;
            }
        }
        return palindrome;
    }
}
