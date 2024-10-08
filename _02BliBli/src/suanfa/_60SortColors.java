package suanfa;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class _60SortColors {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length <= 1) return;

    int p0 = 0, curr = 0, p2 = nums.length - 1;

    while (curr <= p2) {
      if (nums[curr] == 0) {
        swap(nums, p0, curr);
        p0++;
        curr++;
      } else if (nums[curr] == 2) {
        swap(nums, curr, p2);
        p2--;
      } else { // nums[curr] == 1
        curr++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

