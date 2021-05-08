# 81. Search in Rotated Sorted Array II

Difficulty: Medium
Tags: Array, Binary Search

# [Description](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

# Ideas

- 思路同33. Search in Rotated Sorted Array
- 不同之处在于，数组中可能出现相等的元素，需要增加对nums[mid] == nums[end]的判断。
- 如果nums[mid] == nums[end]，则只能单纯的将右边界缩小1位

# Solutions

```java
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            // If nums[mid] == target, the job is done, return mid
            if(target == nums[mid]){
                return true;
            }else if(nums[mid] > nums[r]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else if(nums[mid] < nums[r]){
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                r -= 1;
            }
        }
        return false;
    }
}
```