/// 79. Word Search
/// Source : https://leetcode.com/problems/word-search/description/
///
/// 回溯法
/// 时间复杂度: O(m*n*m*n)
/// 空间复杂度: O(m*n)
public class Solution {

    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //4个方位
    private int m, n;
    private boolean[][] visited; //坐标访问标志

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        if(m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = board[0].length;
        if(n == 0)
            throw new IllegalArgumentException("board can not be empty.");

        visited = new boolean[m][n];
        //从坐标内任意位置出发
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从board[startx][starty]开始, 寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index,
                               int startx, int starty){
        if(index == word.length() - 1) {
            //搜索到最后一个字符了
            return board[startx][starty] == word.charAt(index);
        }
        //当前坐标 是目标字符 继续下一个字符
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    //下一步位置 在范围内 且没有被访问过
                    if (searchWord(board, word, index + 1, newx, newy)) {
                        //存在一条即可
                        return true;
                    }
                }
            }
            //状态重置
            visited[startx][starty] = false;
        }
        return false;
    }
    // 看是否在坐标范围内
    private boolean inArea( int x , int y ){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] b1 = { {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new Solution()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);
    }
}
