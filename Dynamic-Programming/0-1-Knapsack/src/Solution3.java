/// 背包问题
/// 动态规划改进: 滚动数组 两行 奇偶行交替依赖
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 实际使用了2*C的额外空间
public class Solution3 {

    public int knapsack01(int[] w, int[] v, int C){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        //优化了空间
        int[][] dp = new int[2][C + 1]; //只使用两行空间，后一行的dp结果只依赖于前一行
        //在迭代计算的时候，这两行数据在变化 奇偶行交替依赖

        //初始化第一行 不变
        for(int i = 0; i <= C; i++) {
            //装第一个物品 未知容量 的最大价值
            if (i >= w[0]) { //当前容量能装下第一个物品
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;
            }
        }

        for(int j = 1; j < n; j++) {
            //是否选择第j件物品
            for(int i = 0; i <= C; i++) {

                dp[j % 2][i] = dp[(j - 1) % 2][i]; //先假设不选第j件
                if (i >= w[j]) {
                    //当前容量能装下第j件物品 取两者最大值
                    dp[j % 2][i] = Math.max(dp[j % 2][i], v[j] + dp[(j - 1) % 2][i - w[j]]);
                }
            }
        }
        return dp[(n - 1) % 2][C];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        System.out.println(new Solution3().knapsack01(w, v, 5));
    }
}
