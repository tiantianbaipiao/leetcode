/**
 * 力扣第135题是“分发糖果”，要求给孩子们分发糖果，
 * 使得每个孩子至少得到一个糖果，并且如果某个孩子比相邻的孩子评分更高，那么他应该得到更多的糖果。
 */
public class _88CandyDistribution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;
        int[] candies = new int[n];

        // 先从左到右遍历，确保每个孩子至少有一个糖果，并处理递增的情况
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // 再从右到左遍历，处理递减的情况
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总糖果数
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
