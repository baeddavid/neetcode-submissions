class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        Given an integer array nums and an integer k, return k the most frequent elements within the array
        The test cases are generated such that the answer is always unique
        You may return the output in any order

        [1,2,2,3,3,3] k = 2
        output: [2,3]

        Freq count iterated backwards by count added to a list until list.size() == k

        I mean could be a min heap size of k
        heap is sorted by frequency
        */
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int num : nums) {
            freqCount.merge(num, 1, Integer::sum);
        }        

        // Uhhh how do we handle elements that have the same frequency into a bucket
        // It's a fucking list not ints

        List<Integer>[] bucket = new List[nums.length + 1]; 
        for(int num : freqCount.keySet()) {
            int count = freqCount.get(num);
            if(bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(num);
        }

        int kCount = 0;
        for(int i = bucket.length - 1; kCount < k && i >= 0; i--) {
            if(bucket[i] != null) {
                for(int j = 0; j < bucket[i].size(); j++) {
                    if(kCount < k) {
                        result.add(bucket[i].get(j));
                        kCount++;
                    }
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
