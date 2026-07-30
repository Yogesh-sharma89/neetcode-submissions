class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //as it is two-sum question , sort it first
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            //remove duplcate from i also 
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1 , right = nums.length-1;

            int target = -nums[i];
            while(left<right){
              int sum = nums[left] + nums[right];

              if(sum==target){
                //store ans ;
                ans.add(List.of(nums[i],nums[left],nums[right]));

                left++;
                right--;  //so that duplicate won't appear
                //but still duplicate can appear

                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }

                while(left<right && nums[right]==nums[right+1]){
                    right--;
                }

                //remove complte duplicate from left and right;
              }
              else if(sum<target){
                left++; //increase sum
              }else{
                right--;
              }
            }
        }

        return ans;
    }
}
