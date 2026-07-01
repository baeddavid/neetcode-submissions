class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        This seems like a prefix product problem
        well
        kind of?
        its a mix
        its also postfix product 

        essentially at index i the product for index is is
        P[0, i) * PO(i, n]

        Meaning that at index i it's value is the prefix prodduct up until i * postfix product after i to n 


        */        

        int[] answer = new int[nums.length];
        answer[0] = 1;

        for(int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}  
