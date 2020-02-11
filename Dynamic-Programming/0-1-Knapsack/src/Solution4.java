/// 背包问题
/// 动态规划改进  一维数组
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 只使用了C的额外空间
public class Solution4 {

    public int knapsack01(int[] w, int[] v, int C){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        //优化了空间
        int[] dp = new int[C + 1]; //只使用一维数组

        //初始化第一行 不变
        for(int i = 0; i <= C; i++) {
            //装第一个物品 未知容量 的最大价值
            if (i >= w[0]) { //当前容量能装下第一个物品
                dp[i] = v[0];
            } else {
                dp[i] = 0;
            }
        }

        for(int j = 1; j < n; j++) {
            //是否选择第j件物品  i >= w[j]就提前停止，dp[i]不变 还是原先的dp[i]
            for(int i = C; i >= w[j]; i--) { //注意 从大到小逆推  如果从小到大，会影响索引大的dp结果

                dp[i] = Math.max(dp[i], v[j] + dp[i - w[j]]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        System.out.println(new Solution4().knapsack01(w, v, 5));
    }
}
