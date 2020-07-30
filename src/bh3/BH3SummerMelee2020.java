/*
 * Author: Andliage Pox
 * Date: 2020-07
 */
package bh3;

public class BH3SummerMelee2020 {
    public static void main(String[] args) {
        int i, roundCount = 100000; // 使用指南之：局数
        int aWin = 0, bWin = 0;
        for (i = 0; i < roundCount; i++) {
            if (gameOlenyevaVsKiana()) // 使用指南之：谁打谁
                aWin++;
            else
                bWin++;
            System.out.println();
        }
        System.out.println("阿琳姐妹:" + aWin + "\n琪亚娜:" + bWin); // 使用指南之：胜场统计
    }

    @SuppressWarnings("unused")
    private static boolean gameBronyaVsSeele() {
        int dA, dB, round = 0, aHp = 100, bHp = 100;
        boolean pBf = false;
        double pAr = 0.25;
        System.out.println("板鸭 VS 希儿");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (pBf) {
                pBf = false;
                int t = 1 + (int) (Math.random() * 15);
                bHp += t;
                if (bHp > 100) bHp = 100;
                System.out.println("黑希切换为白希，攻击力下降，防御力提升，回复" + t + "点生命，当前生命：" + bHp);
                dB = 13;
            } else {
                pBf = true;
                System.out.println("白希切换为黑希，攻击力上升，防御力下降");
                dB = 23;
            }
            aHp -= dB;
            System.out.println("希儿A了板鸭一下，造成" + dB + "点伤害，板鸭当前生命值：" + aHp);
            if (aHp <= 0) {
                System.out.println("希儿胜利");
                return false;
            }

            if (round % 3 == 0) {
                dA = 1 + (int) (Math.random() * 100);
                System.out.print("板鸭发动摩托车攻击，对希儿造成" + dA + "点元素伤害，");
            } else {
                dA = pBf ? 13 : 8;
                System.out.print("板鸭A了一下，对希儿造成" + dA + "点伤害，");
            }
            bHp -= dA;
            System.out.println("希儿当前生命值：" + bHp);

            if (bHp <= 0) {
                System.out.println("板鸭胜利");
                return true;
            }

            if (Math.random() < pAr) {
                System.out.print("板鸭发动钻头攻击，");
                if (pBf) {
                    bHp -= 16;
                    System.out.println("对黑希造成4 * 4 = 16点伤害，希儿当前生命值：" + bHp);
                } else {
                    System.out.println("但未能击穿白希的装甲");
                }
            }

            if (bHp <= 0) {
                System.out.println("板鸭胜利");
                return true;
            }
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameOlenyevaVsDurandal() {
        int dA, dB, round = 0, aHp = 100, bHp = 100;
        boolean pAf = false, rAf = false;
        double rAr = 0.5, rBr = 0.16;
        System.out.println("阿琳姐妹 VS 呆鹅");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            System.out.println("呆鹅开始摸鱼，攻击力+3");
            dB = 9 + 3 * round;
            aHp -= dB;
            System.out.println("呆鹅A了阿琳姐妹一下，造成了" + dB + "点伤害，阿琳姐妹当前生命值：" + aHp);
            if (aHp <= 0) {
                if (pAf) {
                    System.out.println("呆鹅胜利");
                    return false;
                }
                pAf = true;
                aHp = 20;
                System.out.println("阿琳姐妹喝掉了96度生命之水，当前生命值：20");
            }
            if (pAf && !rAf) {
                System.out.print("阿琳姐妹发动：变成星星吧！");
                rAf = true;
                dA = Math.random() < rAr ? 223 : 40;
                if (Math.random() < rBr) {
                    System.out.println("可惜被呆鹅反弹，受到20点伤害\n呆鹅胜利");
                    return false;
                }
            } else {
                System.out.print("阿琳姐妹A了呆鹅一下，");
                dA = 8;
            }
            bHp -= dA;
            System.out.println("对呆鹅造成了" + dA + "点伤害，呆鹅当前生命值：" + bHp);
            if (bHp <= 0) {
                System.out.println("阿琳姐妹胜利");
                return true;
            }
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameKianaVsDurandal() {
        int dA, dB, round = 0, aHp = 100, bHp = 100;
        boolean rAf = false;
        double rAr = 0.35, rBr = 0.16;
        System.out.println("琪亚娜 VS 呆鹅");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            System.out.println("呆鹅开始摸鱼，攻击力+3");

            if (rAf) {
                rAf = false;
                System.out.println("琪亚娜·眩晕（中）……");
            } else {
                if ((round & 1) == 0) {
                    dA = 34;
                    System.out.print("琪亚娜发动「吃我一矛！」，");
                    if (Math.random() < rAr) {
                        rAf = true;
                        System.out.println("发现音浪～太强～，眩晕自己一回合");
                    }
                    if (Math.random() < rBr) {
                        aHp -= 19;
                        System.out.println("被呆鹅反弹，受到19点伤害，当前生命值：" + aHp);
                        if (aHp <= 0) {
                            System.out.println("呆鹅胜利");
                            return false;
                        }
                    } else {
                        bHp -= dA;
                        System.out.println("对呆鹅造成" + dA + "点伤害，呆鹅当前生命值：" + bHp);
                    }
                } else {
                    System.out.print("琪亚娜A了呆鹅一下，");
                    dA = 14;
                    bHp -= dA;
                    System.out.println("对呆鹅造成" + dA + "点伤害，呆鹅当前生命值：" + bHp);
                }
            }

            if (bHp <= 0) {
                System.out.println("琪亚娜胜利");
                return true;
            }

            dB = 8 + 3 * round;
            aHp -= dB;
            System.out.println("呆鹅A了琪亚娜一下，造成了" + dB + "点伤害，琪亚娜当前生命值：" + aHp);
            if (aHp <= 0) {
                System.out.println("呆鹅胜利");
                return false;
            }
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameOlenyevaVsKiana() {
        int dA, dB, round = 0, aHp = 100, bHp = 100;
        boolean pAf = false, rAf = false, rBf = false;
        double rAr = 0.5, rBr = 0.35;
        System.out.println("阿琳姐妹 VS 琪亚娜");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (rBf) {
                rBf = false;
                System.out.println("琪亚娜·眩晕（中）……");
            } else {
                if ((round & 1) == 0) {
                    dB = 34;
                    System.out.print("琪亚娜发动「吃我一矛！」，");
                    if (Math.random() < rBr) {
                        rBf = true;
                        System.out.println("发现音浪～太强～，眩晕自己一回合");
                    }
                } else {
                    System.out.print("琪亚娜A了阿琳姐妹一下，");
                    dB = 14;
                }
                aHp -= dB;
                System.out.println("对阿琳姐妹造成" + dB + "点伤害，阿琳姐妹当前生命值：" + aHp);
            }

            if (aHp <= 0) {
                if (pAf) {
                    System.out.println("琪亚娜胜利");
                    return false;
                }
                pAf = true;
                aHp = 20;
                System.out.println("阿琳姐妹喝掉了96度生命之水，当前生命值：20");
            }

            if (pAf && !rAf) {
                rAf = true;
                dA = Math.random() < rAr ? 222 : 39;
                System.out.print("阿琳姐妹发动：变成星星吧！");
            } else {
                dA = 7;
                System.out.print("阿琳姐妹A了琪亚娜一下，");
            }
            bHp -= dA;
            System.out.println("对琪亚娜造成了" + dA + "点伤害，琪亚娜当前生命值：" + bHp);
            if (bHp <= 0) {
                System.out.println("阿琳姐妹胜利");
                return true;
            }
        }
    }
}
