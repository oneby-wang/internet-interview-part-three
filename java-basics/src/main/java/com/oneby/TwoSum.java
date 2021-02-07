package com.oneby;

import java.util.HashMap;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Author Oneby
 * @Date 2020/12/26 20:41
 * @Version 1.0
 */
public class TwoSum {

    // 暴力版本
//    class Solution {
//        public int[] twoSum(int[] arr, int target) {
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (arr[i] + arr[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            return null;
//        }
//    }

    // HashMap 版本
//    class Solution {
//        public int[] twoSum(int[] arr, int target) {
//            HashMap<Integer, Integer> valueToIndex = new HashMap<>();
//
//            // 构造 HashMap，Key 是数组元素的值，Value 是数组元素的下标
//            for (int i = 0; i < arr.length; i++) {
//                valueToIndex.put(arr[i], i);
//            }
//
//            for (int i = 0; i < arr.length; i++) {
//                // arr[i] + remain = target
//                int remain = target - arr[i];
//                // remain 在 HashMap 中，且 remain 对应的下标和 arr[i] 对应的下标不同
//                if (valueToIndex.containsKey(remain) && (valueToIndex.get(remain) != i)) {
//                    return new int[]{i, valueToIndex.get(remain)};
//                }
//            }
//
//            return null;
//        }
//    }

    // 一遍完成
    class Solution {
        public int[] twoSum(int[] arr, int target) {
            HashMap<Integer, Integer> valueToIndex = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                // arr[i] + remain = target
                int remain = target - arr[i];
                // 如果存在于 HashMap 之中，就返回数组下标
                if (valueToIndex.containsKey(remain)) {
                    return new int[]{valueToIndex.get(remain), i};
                }
                // 否则记录数组元素的值和下标
                valueToIndex.put(arr[i], i);
            }

            return null;
        }
    }

}
