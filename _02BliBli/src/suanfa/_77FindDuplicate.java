package suanfa;

/**
 * 出数组中的重复数字。给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（含 1 和 n），
 * 可知至少存在一个重复的数字。题目要求找出这个重复的数字。
 */
public class _77FindDuplicate {
    public int findDuplicate(int[] nums) {
        // Step 1: Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise]; // Move one step at a time.
            hare = nums[nums[hare]];   // Move two steps at a time.
        } while (tortoise != hare);    // Stop when they meet.

        // Step 2: Find the entrance to the cycle (duplicate number).
        tortoise = nums[0];           // Reset tortoise to the start.
        while (tortoise != hare) {    // Move both at the same speed.
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;                  // The meeting point is the duplicate.
    }
}
