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

		Arrays.sort(people);
		int left = 0, right = people.length - 1, boatCount = 0;   
		while(left <= right) {
			if(people[left] + people[right] <= limit) {
				left++;
			}
			right--;
			boatCount++;
		}
		return boatCount;
    }
}