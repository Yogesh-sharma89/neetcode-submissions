class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0 , high = 0;

        int res = Integer.MAX_VALUE, sum = 0;

        while(high<nums.length){
            //means jab tak clg me bacche hai tab tak hire karo
            // first of all you have to hire 
            //window ke info me high add karo
            sum +=nums[high];

            //check if our work is happening then start firing 
            //means if condition is met then look for smaller window
            while(sum>=target){
                //get the subarray len;
                int len = high-low +1;
                //track the min length
                res = Math.min(res,len);

                //slide window  - shrink window and fire the low
                sum = sum - nums[low];
                low++;
            }
            //it means- codition is till not meet then hire more
            high++;
        }

        return res == Integer.MAX_VALUE ? 0:res;
    }
}