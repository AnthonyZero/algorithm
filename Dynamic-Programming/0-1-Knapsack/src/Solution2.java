/// 背包问题
/// 动态规划 实现方式
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution2 {

    public int knapsack01(int[] w, int[] v, int C){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[][] dp = new int[n][C + 1];

        //初始化第一行
        for(int i = 0; i <= C; i++) {
            //装第一个物品 未知容量 的最大价值
            if (i >= w[0]) { //当前容量能装下第一个物品
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;
            }
        }

        //是否选择第i件物品
        for(int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= w[i]) {
                    //当前容量能装下第i件物品 取两者最大值 第i件选与不选
                    dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
                } else {
                    // 装不下 只能继续看下一件
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][C];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        System.out.println(new Solution2().knapsack01(w, v, 5));
    }
}
