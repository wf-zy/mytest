package test.algorithm;

/**
 * 动态规划
 *
 * @Author xiongyong
 * @Date 2021/10/21
 */

public class DynamicProgramming {
    public static void main(String[] args) {
        //物品价值
        int v[] = {0, 8, 10, 6, 3, 7, 2};
        // 重量
        int w[] = {0, 4, 6, 2, 2, 5, 1};
        // 承重
        int c = 8;

        /**
         *  承重     0 1 2 3 4 5   6  7  8  9 10 11 12
         *  价值
      0  *    0     0 0 0 0 0 0   0  0  0  0  0  0  0
      4  *    8     0 0 0 0 8 8   8  8  8  8  8  8  8
      6  *   10     0 0 0 0 8 8  10 10 10 10 18 18 18
      2  *   6      0 0 6 6 8 8  14 14 16 16 18 18 24
      2  *   3      0 0 6 6 9 9  14 14 17 17 19 19 24
      5  *   7      0 0 6 6 9 9  14 14 17 17 19 21 24
      1  *   2      0 2 6 8 9 11 14 16 17 19 19 21 24
         */

        //定义二位数组动态规划背包价值和重量
        int m[][] = new int[v.length][c + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i]) {
                    m[i][j] = m[i - 1][j - w[i]] + v[i] > m[i - 1][j] ? m[i - 1][j - w[i]] + v[i] : m[i - 1][j];
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < v.length; i++) {
            System.out.println();
            for (int j = 0; j <= c; j++) {
                System.out.print(m[i][j] +" ");
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("max:"+ max);
    }
}
