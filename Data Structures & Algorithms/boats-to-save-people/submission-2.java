class Solution {
    public int numRescueBoats(int[] people, int limit) {
		/*
		Part of me thinks this can be done greedily
		Cram the fattest guy into a boat
		if he == limit thats a boat
		if not find a complement 

		frequency count as well like 2 sum
		key is the value at index i and value is the number of occurrences
		*/     

		int[] bucket = new int[limit + 1];
		for(int peeps : people) {
			bucket[peeps]++;
		}

		int left = 1, right = limit, boatCount = 0;

		while(left <= right) {
			while(left <= right && bucket[left] == 0) left++;
			while(left <= right && bucket[right] == 0) right--;

			if(left > right) break;

			if(left == right) {
				if(left + left <= limit) {
					boatCount += bucket[left] / 2;
					if(bucket[left] % 2 == 1) boatCount++;
				} else {
					boatCount += bucket[left];
				}
				bucket[left] = 0;
				break;
			}


			bucket[right]--;
			boatCount++;

			if(left <= right && left + right <= limit) {
				bucket[left]--;
			}
		}
		return boatCount;
    }
}