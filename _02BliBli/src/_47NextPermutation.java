/**
 * leetcode 31. Next Permutation
 */
public class _47NextPermutation {
  public void nextPermutation(int[] nums) {
    // Step 1: Find the first element from the right that is smaller than its next element.
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    // Step 2: If such an element was found, find the next greater element to the right.
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i]) {
        j--;
      }
      // Step 3: Swap these two elements.
      swap(nums, i, j);
    }

    // Step 4: Reverse the part of the array after the index i.
    reverse(nums, i + 1, nums.length - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }
}

