# 33. Search in Rotated Sorted Array

Difficulty: Medium
Tags: Array, Binary Search

# [Description](https://leetcode.com/problems/search-in-rotated-sorted-array/solution/)

# Ideas

核心关注点：如何安全且有效地排除target肯定不在的区间，判断target是否在绝对单调的区间（根据旋转递增数组的特性），以此来缩小二分搜索的范围

- 如果nums[mid]不等于target可能存在两种情况（以右边界点作为参考）
    1. nums[mid] ≥ nums[end]：绝对单调的区间在mid左边，如果target < nums[mid] && target ≥ nums[start] 则target在此单调区间内，end = mid -1，否则排除此单调区间，start = mid + 1

    ![33%20Search%20in%20Rotated%20Sorted%20Array%20005967ce5f1e4029a58e40b525aaceea/Screen_Shot_2021-05-08_at_5.08.55_PM.png](33%20Search%20in%20Rotated%20Sorted%20Array%20005967ce5f1e4029a58e40b525aaceea/Screen_Shot_2021-05-08_at_5.08.55_PM.png)

      2. nums[mid] < nums[end]：绝对单调的区间在mid右边，如果target > nums[mid] && target ≤ nums[end] 则target在此单调区间内，start = mid + 1，否则排除此单调区间，end = mid - 1

    ![33%20Search%20in%20Rotated%20Sorted%20Array%20005967ce5f1e4029a58e40b525aaceea/Screen_Shot_2021-05-08_at_5.09.01_PM.png](33%20Search%20in%20Rotated%20Sorted%20Array%20005967ce5f1e4029a58e40b525aaceea/Screen_Shot_2021-05-08_at_5.09.01_PM.png)

- 如果nums[mid]等于target 输出结果，否则返回-1

# Solutions

```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            // If nums[mid] == target, the job is done, return mid
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] >= nums[r]){
                (target >= nums[l] && target < nums[mid]) ? 
								r = mid - 1 : l = mid + 1;
            }else if(nums[mid] < nums[r]){
                (target <= nums[r] && target > nums[mid]) ?
                l = mid + 1 : r = mid - 1;
            }
        }
        return -1;
    }
}
```