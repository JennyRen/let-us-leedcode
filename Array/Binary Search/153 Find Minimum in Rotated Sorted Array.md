# 153. Find Minimum in Rotated Sorted Array

Difficulty: Medium
Status: Finished
Tags: 头尾双指针

# [Description](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

# Ideas

- 有序数组查找 → 二分查找
- 生序旋转数组找最小值（包含重复元素），以右边界元素作为参考元素
    - nums[mid] < nums[right]：说明最小值肯定在mid左边部分，排除右边部分元素，移动右边界至mid
    - nums[mid] > nums[right]：说明最小值肯定在mid右边部分，排除左边部分元素，移动左边界至mid+1
- 结果就是二分查找后的左边界元素

时间复杂度O(logN) 空间复杂度O(1)

# Solutions

```java
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        // Binary search
        while(l < r){
            int mid = (l + r) / 2;
            // estimate in accordance with nums[r] since the array is ascending
            // exclude the monotonously increasing part and narrow the binary search range
            if(nums[mid] < nums[r]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        // left boundary as result
        return nums[l];
    }
}
```