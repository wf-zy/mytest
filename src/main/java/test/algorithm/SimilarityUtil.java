package test.algorithm;

/**
 * 相似度
 * @Author xiongyong
 * @Date 2021/8/30
 */

public class SimilarityUtil {

    public static void main(String[] args) {
        System.out.println(Levenshtein_Distance("abc/test/a", "abc/test"));
        System.out.println(Levenshtein_Distance("abc/test/a", "/test"));
        System.out.println(Levenshtein_Distance("abc/test/a", "abc/a"));
        System.out.println(Levenshtein_Distance("abc/test/a", "abc/test/a"));
    }


    private static int LowerOfThree(int first, int second, int third) {
        int min = Math.min(first, second);
        return Math.min(min, third);
    }

    private static int Levenshtein_Distance(String str1, String str2) {
        int[][] Matrix;
        int n = str1.length();
        int m = str2.length();
        int temp = 0;
        char ch1;
        char ch2;
        int i = 0;
        int j = 0;
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        Matrix = new int[n + 1][m + 1];

        for (i = 0; i <= n; i++) {
            // ��ʼ����һ��
            Matrix[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            // ��ʼ����һ��
            Matrix[0][j] = j;
        }

        for (i = 1; i <= n; i++) {
            ch1 = str1.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                Matrix[i][j] = LowerOfThree(Matrix[i - 1][j] + 1,
                        Matrix[i][j - 1] + 1, Matrix[i - 1][j - 1] + temp);
            }
        }
        return Matrix[n][m];
    }

    public static double LevenshteinDistancePercent(String str1, String str2) {
        str1=str1.replace(" ", "");
        str2=str2.replace(" ", "");
        int val = Levenshtein_Distance(str1, str2);
        return 1 - (double) val / Math.max(str1.length(), str2.length());
    }

}
