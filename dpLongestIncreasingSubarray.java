
public class dpLongestIncreasingSubarray {
    public int solution(int[] array) {
        int[] dpTable = new int[array.length];
        dpTable[0] = 1;
        int last = array[0];
        int maxLen = 1;
        for(int i = 1; i < array.length; i++) {
            int curr = array[i];
            if(curr > last) {
                dpTable[i] = dpTable[i-1]+1;
                maxLen = Math.max(maxLen, dpTable[i]);
            }
            else {
                dpTable[i] = 1;
            }
            last = curr;
        }
        return maxLen;
    }
}