package leetcode322;

import java.util.Arrays;

public class demo {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为：目标值加一，如果最后的一个位置没有更新就说明无法兑换
        dp[0] = 0;

        // 遍历所有访问，从1到目标amount
        for (int i = 1; i <= amount; i++) {// i表示当前所凑的数值，
            // 遍历所有硬币的面值
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) { // 如果当前硬币的面值已经超过了当前金额，那么一定无法凑出来
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // 加1 表示已经凑出来的钱数的那一个硬币coin[j],还差i - coins[j]元，所需数量为dp[i - coins[j]]个。min只用来做替换
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
