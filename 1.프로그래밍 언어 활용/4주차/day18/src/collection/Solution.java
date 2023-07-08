package collection;

import java.util.HashMap;

public class Solution {
    public static int solution(int[] nums) {
        
        int size = nums.length;
        
        int count = size/2;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i < size;i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);   	
        }
        int total = map.keySet().size();
        
        System.out.println(count < total ? count : total);
        
        
        
        return count < total ? count : total;
    }
    
    public static void main(String[] args) {
		int[] nums1 = {3,1,2,3};
		int[] nums2 = {3, 3, 3, 2, 2, 4};
		int[] nums3 = {3, 3, 3, 2, 2, 2};
		
		int res1 = solution(nums1);
		int res2 = solution(nums2);
		int res3 = solution(nums3);
		
		if(res1==2&&res2==3&&res3==2) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
	}
}