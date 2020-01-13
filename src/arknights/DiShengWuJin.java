/*
 * Author: Andliage Pox
 * Date: 2020-01-13
 */

package arknights;

/**
 * 明日方舟春节活动池模拟
 */
public class DiShengWuJin {
    public static void main(String[] args) {
        int i, times = 100000;
        int up702Sum = 0, up501Sum = 0;
        for (i = 0; i < times; i++) {
            up702Sum += up_70_2();
            up501Sum += up_50_1();
        }
        System.out.println("70双up凑齐平均抽数： " + up702Sum / times);
        System.out.println("50单up凑齐平均抽数： " + up501Sum / times);
    }

    /**
     * 地生五金双up70%(概率均分)池中抽年和啊
     * @return 抽到所用的次数
     */
    private static int up_70_2() {
        int count = 0; // 抽卡次数
        boolean nian = false, a = false;
        int usTimes = 0;
        double random, curP = 0.02;
        while (true) {
            random = Math.random();
            count++;
            if (random < curP) {
                random = Math.random();
                if (random < 0.35) {
                    nian = true;
                }
                if (random > 0.35 && random < 0.7) {
                    a = true;
                }
                curP = 0.02;
                usTimes = 0;
            } else {
                usTimes++;
                if (usTimes >= 50) {
                    curP = 0.02 * (usTimes - 48);
                }
            }
            if (nian && a) {
                break;
            }
            if (count > 10000) {
                System.out.println("???");
                break;
            }
        }
        return count;
    }

    /**
     * 如果分两个单up50%抽年和啊(就当年池里没有啊，啊池里没有年)
     * @return 抽到所用的次数
     */
    private static int up_50_1() {
        int count = 0; // 抽卡次数
        boolean nian = false;
        int usTimes = 0;
        double random, curP = 0.02;
        while (true) {
            random = Math.random();
            count++;
            if (random < curP) {
                random = Math.random();
                if (random < 0.5) {
                    nian = true;
                }
                curP = 0.02;
                usTimes = 0;
            } else {
                usTimes++;
                if (usTimes >= 50) {
                    curP = 0.02 * (usTimes - 48);
                }
            }
            if (nian) {
                break;
            }
            if (count > 10000) {
                System.out.println("???");
                break;
            }
        }
        // 数学上这两次抽池子是等价的，所以*2就好了(我也想真模拟，但它给我报warning说我复制粘贴)
        return count * 2;
    }
}
