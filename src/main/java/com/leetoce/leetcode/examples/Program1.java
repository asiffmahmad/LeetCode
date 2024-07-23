package com.leetoce.leetcode.examples;


/*
1636. Sort Array by Increasing Frequency

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.
Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
*/
import java.util.*;

class Program1 {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of elements
        List<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            sortedList.add(num);
        }

        // Step 3: Sort the list based on frequency and then by value
        sortedList.sort((a, b) -> {
            int freqComparison = Integer.compare(freqMap.get(a), freqMap.get(b));
            if (freqComparison != 0) {
                return freqComparison;
            }
            // For the same frequency, sort by value in decreasing order
            return Integer.compare(b, a);
        });

        // Step 4: Create the result array
        int[] result = new int[nums.length];
        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = sortedList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
    	Program1 sol = new Program1();
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] result1 = sol.frequencySort(nums1);
        System.out.println(Arrays.toString(result1)); // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2,5,6};
        int[] result2 = sol.frequencySort(nums2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] result3 = sol.frequencySort(nums3);
        System.out.println(Arrays.toString(result3)); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}

