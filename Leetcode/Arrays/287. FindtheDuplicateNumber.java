class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];//sets it to first element of array
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);//slow and fast pointer until they meet
        fast=nums[0];
        while(slow!=fast){//both move pointers at same speed until they meet again
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
