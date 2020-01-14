/*
 * Author: Andliage Pox
 * Date: 2020-01-14
 */

package bh3;

/**
 * 模拟测试一个角色抽毕业需要多少发
 */
public class GraduateTest {
    public static void main(String[] args) {
        int i, s, e, times = 100000;
        int countS = 0, countE = 0, count = 0;
        for (i = 0; i < times; i++) {
            s = getS();
            e = getEquipments();
            count += s + e;
            countS += s;
            countE += e;
        }
        System.out.println("平均获取人物需要抽数： " + countS / times);
        System.out.println("平均获取装备需要抽数： " + countE / times);
        System.out.println("平均毕业需要抽数： " + count / times);
    }

    private static int getS() {
        int count = 0;
        while (true) {
            count++;
            if (Math.random() < 0.015 || count == 100) {
                return count;
            }
        }
    }

    private static int getEquipments() {
        int count = 0, upTimes = 0;
        boolean weapon = false, sA = false, sB = false, sC = false;
        double random;
        while (true) {
            count++;
            random = Math.random();
            if (upTimes == 9) {
                upTimes = 0;
                if (random < 0.2) {
                    weapon = true;
                } else if (random < 0.3) {
                    sA = true;
                } else if (random < 0.4) {
                    sB = true;
                } else if (random < 0.5) {
                    sC = true;
                }
            } else {
                if (random < 0.12395) {
                    upTimes = 0;
                    if (random < 0.02479) {
                        weapon = true;
                    } else if (random < 0.03719) {
                        sA = true;
                    } else if (random < 0.04959) {
                        sB = true;
                    } else if (random < 0.06199) {
                        sC = true;
                    }
                } else {
                    upTimes++;
                }
            }
            if (weapon && sA && sB && sC) {
                break;
            }
            if (count > 50000) {
                System.out.println("???");
                break;
            }
        }
        return count;
    }
}
