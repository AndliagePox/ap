/*
 * Author: Andliage Pox
 * Date: 2020-01-05
 */

package arknights;

public class ProbabilityTest {
    public static void main(String[] args) {
        double curP = 0.02;
        int sTimes = 0, usTimes = 0, i;
        int times = 1000000;
        for (i = 0; i < times; i++) {
            if (Math.random() < curP) {
                sTimes++;
                System.out.println("sTimes+1 curP: " + curP);
                curP = 0.02;
                usTimes = 0;
            } else {
                usTimes++;
                if (usTimes >= 50) {
                    curP = 0.02 * (usTimes - 48);
                }
            }
        }
        System.out.println("实验 " + times + " 次");
        System.out.println("六星 " + sTimes + " 次");
        System.out.println("平均 " + (double)times / sTimes + " 次一只");
        System.out.println("平均概率 " + (double)sTimes / times);
    }
}
