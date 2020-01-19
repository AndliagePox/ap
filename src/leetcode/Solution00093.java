/*
 * Author: Andliage Pox
 * Date: 2020-01-19
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution00093 {
    public static void main(String[] args) {
        String s = "25525511135";
        for (String ip: new Solution00093().restoreIpAddresses(s)) {
            System.out.println(ip);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        /*
         * 乍一看这个算法效率存在些许问题，实际上并没有
         * 这个问题总共就那么几个情况，直接暴力倒也能节省不少开发成本不是
         */
        int a, b, c, d, ai, bi, ci, di, n = s.length();
        List<String> list = new ArrayList<>();
        StringBuilder sb;
        for (a = 1; a <= 3; a++) {
            for (b = 1; b <= 3; b++) {
                for (c = 1; c <= 3; c++) {
                    for (d = 1; d <= 3; d++) {
                        if (a + b + c + d != n) {
                            continue;
                        }

                        ai = Integer.parseInt(s.substring(0, a));
                        bi = Integer.parseInt(s.substring(a, a + b));
                        ci = Integer.parseInt(s.substring(a + b, a + b + c));
                        di = Integer.parseInt(s.substring(a + b + c));

                        if (ai > 255 || bi > 255 || ci > 255 || di > 255) {
                            continue;
                        }

                        sb = new StringBuilder();
                        sb.append(ai).append('.').append(bi).append('.').append(ci).append('.').append(di);

                        if (sb.length() == n + 3) { // 这里有点意思的，判长度是为了判有没有把开头的0去掉
                            list.add(sb.toString());
                        }
                    }
                }
            }
        }
        return list;
        /*
         * 时间空间这种事我说是O(1)都是常数级的东西
         * 话又说回来，这么整确实不美观，也没事通用性，甚至没有技术含量，不好不好
         */
    }
}
