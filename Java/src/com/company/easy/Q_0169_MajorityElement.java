package com.company.easy;

import java.util.HashMap;
import java.util.Map;

public class Q_0169_MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 2, 1, 1, 1, 1};
        System.out.println(new Q_0169_MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                int oldValue = map.get(key);
                map.put(key, oldValue + 1);
            } else {
                map.put(key, 1);
            }
        }

        final int majorCount = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorCount) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
