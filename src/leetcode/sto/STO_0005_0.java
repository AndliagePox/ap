/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package leetcode.sto;

public class STO_0005_0 {
    public static void main(String[] args) {
        String s = "Hello world.";
        System.out.println(new STO_0005_0().replaceSpace(s));
    }

    public String replaceSpace(String s) {
        /*
         * 替换字符好像也没什么难度
         * 改进(也许并不是)点就是我觉得为统计空格再扫一遍有些浪费
         * 然后就空间换时间地直接整了4倍内存全是空格也够换了，避免扩容消耗时间
         * 为什么是4倍不是3倍这种事，当然是 <<2 比 *3 快多了啊
         * 浪费内存邪教
         */
        StringBuilder sb = new StringBuilder(s.length() << 2);
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
        /*
         * 时间O(n)
         * 空间O(n)(虽然我浪费，但还是n)
         * 上面好像分析的多了，不过我这么浪费内存，它还检查超过100%内存使用，神经病
         */
    }
}
