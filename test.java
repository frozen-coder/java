
public class test {
public static void main(String[] args) {
    System.out.println("HAI");
    int[] in = {1,2,5,3,2,6,3,2,1,5,6,7,8,9,10};
    dpLongestIncreasingSubarray dp = new dpLongestIncreasingSubarray();
    System.out.println(dp.solution(in));
}
}