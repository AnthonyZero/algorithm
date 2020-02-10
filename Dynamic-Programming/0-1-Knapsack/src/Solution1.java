/// 背包问题
/// 记忆化搜索 递归
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution1 {

    private int[][] memery;

    //w重量 v价值 C容量
    public int knapsack01(int[] w, int[] v, int C){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        memery = new int[n][C + 1]; //初始化为 -1
        for(int i = 0; i < n; i ++)
            for(int j = 0; j <= C; j ++)
                memery[i][j] = -1;

        return bestValue(w, v, n - 1, C); //从n-1选择开始 到0
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c){

        if(c <= 0 || index < 0)
            return 0;

        if(memery[index][c] != -1)
            return memery[index][c];

        int res = bestValue(w, v, index-1, c); //不取当前index的物品价值
        if(c >= w[index]) //能装入前提下（这很重要） 两个最大价值（取当前index的物品价值）
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return memery[index][c] = res;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        System.out.println(new Solution1().knapsack01(w, v, 5));
    }
}
