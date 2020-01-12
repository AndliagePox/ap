/*
 * Author: Andliage Pox
 * Date: 2019-08
 */
package bh3;

public class BH3SummerMelee {
    public static void main(String[] args) {
        int i, roundCount = 100000; // 使用指南之：局数
        int aWin = 0, bWin = 0;
        for (i = 0; i < roundCount; i++) {
            if (gameFuhuaVsSakura()) // 使用指南之：谁打谁
                aWin++;
            else
                bWin++;
            System.out.println();
        }
        System.out.println("Fu:" + aWin + "\nSa:" + bWin); // 使用指南之：胜场统计
    }

    @SuppressWarnings("unused")
    private static boolean gameBronyaVsSakura() {
        int dA, dB;
        boolean ff;
        int round = 0, fire = 0, aHp = 100, bHp = 100;
        double rAp = 0.15, rBp = 0.25, rBr = 0.2;
        System.out.print("Bronya Vs Sakura");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            ff = false;
            if (Math.random() < rBp) {
                dB = 40;
                System.out.println("嘤嘤嘤发动暴击");
            } else dB = 20;
            if (Math.random() < rAp) {
                ff = true;
                System.out.println("板鸭成功闪避");
            } else {
                aHp -= dB;
                System.out.println("嘤嘤嘤对板鸭造成" + dB + "点物理伤害");
            }
            if (Math.random() < rBr && !ff) {
                fire = 3;
                System.out.println("嘤嘤嘤发动点燃");
            }

            if (fire-- > 0) {
                aHp -= 5;
                System.out.println("板鸭受到来自致命点盐的5点元素伤害");
            }
            if (aHp <= 0) {
                System.out.println("嘤嘤嘤获胜");
                return false;
            }
            if (round % 3 == 0) {
                dA = 1 + (int) (Math.random() * 99.0) - 7;
                System.out.println("板鸭发动必杀技");
            } else {
                dA = 19;
            }
            bHp -= dA;
            System.out.println("板鸭对嘤嘤嘤造成" + dA + "点物理伤害");
            if (bHp <= 0) {
                System.out.println("板鸭获胜");
                return true;
            }
            System.out.println("剩余血量:\n板鸭 " + aHp + "\n嘤嘤嘤 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameMurataVsFuhua() {
        int dA, dB, pAa = 24, pAd = 10;
        boolean fAr = false, fAp = false, fBp = false;
        int round = 0, aHp = 100, bHp = 100;
        double rAr = 0.3;
        System.out.print("Murata Vs Fuhua");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 3 == 0) {
                dB = 10 + (int)(Math.random() * 20.0);
                System.out.println("符华发动必杀技");
                System.out.println("符华对姬子造成" + dB + "点元素伤害");
            } else {
                dB = 27 - pAd;
                System.out.println("符华对姬子造成" + dB + "点物理伤害");
            }
            aHp -= dB;

            if (aHp <= 0) {
                System.out.println("符华获胜");
                return false;
            }

            if (aHp < 40 && !fAp) {
                pAa = 36;
                pAd = 15;
                fAp = true;
                System.out.println("姬子发动被动技能，攻防提高");
            }
            if (fAr) {
                System.out.println("姬子释放必杀攻击");
                if (fBp) {
                    dA = pAa - 8;
                    bHp -= dA;
                    System.out.println("姬子对符华造成" + dA + "点物理伤害");
                    System.out.println("符华持有锁血挂，免疫元素伤害(但难逃一死)");
                } else {
                    dA = pAa - 8;
                    bHp -= dA;
                    System.out.print("姬子对符华造成" + dA + "点物理伤害");
                    dA = 2 * pAa;
                    bHp -= dA;
                    System.out.println("和" + dA + "点元素伤害");
                }
                fAr = false;
            } else {
                if (Math.random() < rAr) {
                    fAr = true;
                    System.out.println("姬子发动必杀技，本回合不攻击");
                } else {
                    dA = pAa - 8;
                    bHp -= dA;
                    System.out.println("姬子对符华造成" + dA + "点物理伤害");
                }
            }

            if (bHp <= 0) {
                if (fBp) {
                    System.out.println("姬子获胜");
                    return true;
                } else {
                    bHp = 1;
                    fBp = true;
                    System.out.println("符华开启锁血挂");
                }
            }
            System.out.println("剩余血量:\n姬子 " + aHp + "\n符华 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameMurataVsKallen() {
        int dA, dB, cBr = 0, pAa, pAd = 10, round = 0, aHp = 100, bHp = 100;
        boolean fAr = false, fAp = false;
        double rAr = 0.3, rBp = 0.05, rBr = 0.3;
        System.out.print("Murata Vs Kallen");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if(Math.random() < rBp) {
                System.out.println("卡莲发动被动技能，姬子被打成了废人");
                System.out.println("卡莲获胜");
                return false;
            }

            dB = 26 - pAd;
            aHp -= dB;
            System.out.println("卡莲对姬子造成" + dB + "点物理伤害");

            if (aHp <= 0) {
                System.out.println("卡莲获胜");
                return false;
            }

            if (Math.random() < rBr) {
                cBr = 2;
                System.out.println("卡莲发动必杀技，姬子攻击力降低");
            }

            if (aHp < 40 && !fAp) {
                pAd = 15;
                fAp = true;
                System.out.println("姬子发动被动技能，攻防提高");
            }

            if (cBr-- != 0) {
                if (fAp) pAa = 21;
                else pAa = 9;
            } else {
                if (fAp) pAa = 36;
                else pAa = 24;
            }

            if (fAr) {
                System.out.println("姬子释放必杀攻击");
                dA = pAa - 6;
                bHp -= dA;
                System.out.print("姬子对卡莲造成" + dA + "点物理伤害");
                dA = 2 * pAa;
                bHp -= dA;
                System.out.println("和" + dA + "点元素伤害");
                fAr = false;
            } else {
                if (Math.random() < rAr) {
                    fAr = true;
                    System.out.println("姬子发动必杀技，本回合不攻击");
                } else {
                    dA = pAa - 6;
                    bHp -= dA;
                    System.out.println("姬子对卡莲造成" + dA + "点物理伤害");
                }
            }

            if (bHp <= 0) {
                System.out.println("姬子获胜");
                return true;
            }
            System.out.println("剩余血量:\n姬子 " + aHp + "\n卡莲 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameMeiVsKiana() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 6, pBa = 23, pBd = 11, aHp = 100, bHp = 120;
        double rAr = 0.3;
        boolean fAr = false;
        System.out.print("Mei Vs Kiana");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            dA = pAa - pBd;
            bHp -= (dA + 5);
            System.out.println("芽衣砍了出去，对琪亚娜造成" + dA + "点物理伤害和5点元素伤害");

            if (Math.random() < rAr) {
                bHp -= 15;
                fAr = true;
                System.out.println("芽衣发动必杀技，再次对琪亚娜造成15点元素伤害，并沉默了琪亚娜");
            }

            if (bHp <= 0) {
                System.out.println("芽衣：只是这样的琪亚娜，看来是我多虑了");
                return true;
            }

            if (round % 3 == 0) {
                if (fAr) {
                    fAr = false;
                    dB = pBa - pAd;
                    aHp -= dB;
                    System.out.println("琪亚娜被沉默了，无法转转转，只好A一下，对芽衣造成" + dB + "点物理伤害");
                } else {
                    dB = 12 - pAd;
                    aHp -= (8 * dB);
                    System.out.println("琪亚娜发动转圈圈，对芽衣造成8*" + dB + "点物理伤害");
                }
            } else {
                dB = pBa - pAd;
                aHp -= dB;
                System.out.println("琪亚娜A了一下，对芽衣造成" + dB + "点物理伤害");
            }

            if (aHp <= 0) {
                System.out.println("琪亚娜：胜利是必然的嘛");
                return false;
            }
            System.out.println("剩余血量:\n芽衣 " + aHp + "\n琪亚娜 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameMeiVsTheresa() {
        int dA, dB, round = 0, td;
        int pAa = 26, pAd = 6, pBa = 24, pBd = 8, aHp = 100, bHp = 100;
        double rAr = 0.3;
        boolean fAr = false;
        System.out.print("Mei Vs Theresa(Judas)");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            dA = pAa - pBd;
            bHp -= (dA + 2);
            System.out.println("芽衣砍了出去");
            System.out.println("犹大被动技能生效");
            System.out.println("芽衣对犹大造成" + dA + "点物理伤害和2点元素伤害");

            if (Math.random() < rAr) {
                bHp -= 7;
                fAr = true;
                System.out.println("芽衣发动必杀技");
                System.out.println("犹大被动技能生效");
                System.out.println("芽衣对犹大造成7点元素伤害，并绑紧了犹大");
            }

            if (bHp <= 0) {
                System.out.println("芽衣：只是这样的犹大，看来是我多虑了");
                return true;
            }

            if (round % 2 == 0) {
                if (fAr) {
                    dB = pBa - pAd;
                    aHp -= dB;
                    System.out.println("犹大被绑住了，无法展开，只好砸上一下，对芽衣造成了" + dB + "点物理伤害");
                } else {
                    System.out.println("犹大展开!");
                    for(int i = 1; i <= 4; i++) {
                        dB = 1 + (int) (Math.random() * 15);
                        aHp -= dB;
                        System.out.println("犹大的第" + i + "根光矛插出了" + dB + "点元素伤害");
                    }
                    System.out.println("犹大收起!(为什么只有四根这种事……@策划)");
                }
            } else {
                dB = pBa - pAd;
                aHp -= dB;
                System.out.println("犹大砸了一下，对芽衣造成" + dB + "点物理伤害");
            }

            if (aHp <= 0) {
                System.out.println("Teriri：舰长已经起床了么?");
                return false;
            }
            System.out.println("剩余血量:\n芽衣 " + aHp + "\n犹大 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameTheresaVsKiana() {
        int dA, dB, round = 0;
        int pAa = 24, pAd = 8, pBa = 23, pBd = 11, aHp = 100, bHp = 120;
        System.out.println("Theresa(Judas) Vs Kiana");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 2 == 0) {
                System.out.println("犹大展开!");
                for(int i = 1; i <= 4; i++) {
                    dA = 1 + (int) (Math.random() * 15);
                    bHp -= dA;
                    System.out.println("犹大的第" + i + "根光矛造成了" + dA + "点元素伤害");
                }
                System.out.println("犹大收起!");
            } else {
                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("犹大砸了一下，对琪亚娜造成" + dA + "点物理伤害");
            }

            if (bHp <= 0) {
                System.out.println("Teriri：琪亚娜你补考没过");
                return true;
            }

            if (round % 3 == 0) {
                dB = 12 - pAd;
                aHp -= (8 * dB);
                System.out.println("琪亚娜转转转，对犹大造成8*" + dB + "点物理伤害");
            } else {
                dB = pBa - pAd;
                aHp -= dB;
                System.out.println("琪亚娜A了一下，对犹大造成" + dB + "点物理伤害");
            }

            if (aHp <= 0) {
                System.out.println("琪亚娜：我今天不起床了");
                return false;
            }
            System.out.println("剩余血量:\n犹大 " + aHp + "\n琪亚娜 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameRitaVsSeele() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 8, pBa = 23, pBd = 10, aHp = 100, bHp = 100;
        double rAp = 0.3, rAr = 0.2, rBr = 0.25;
        boolean fAr = false;
        System.out.println("Rita Vs Seele");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            bHp += 7;
            if (bHp > 100) bHp = 100;
            System.out.println("希儿发动被动技能，回复7点生命");

            if (fAr) {
                fAr = false;
                System.out.println("希儿又被困住了，本回合无法攻击");
            } else {
                if (round % 4 == 0) {
                    System.out.println("希儿开大了！");
                    if (Math.random() < rBr) {
                        dB = 100 - pAd;
                        aHp -= dB;
                        System.out.println("在黑暗中沦陷吧！希儿对丽塔造成了" + dB + "点物理伤害");
                    } else {
                        System.out.println("希儿空大了！");
                    }
                } else {
                    dB = pBa - pAd;
                    aHp -= dB;
                    System.out.println("希儿砍了一下，对丽塔造成了" + dB + "点物理伤害");
                }
            }

            if (aHp <= 0) {
                System.out.println("希儿：布洛妮娅姐姐，还满意希儿的表现吗？");
                return false;
            }

            dA = pAa - pBd;
            bHp -= dA;
            System.out.println("丽塔扔了一台冰箱，对希儿造成了" + dA + "点物理伤害");

            if (Math.random() < rAp) {
                aHp += dA;
                System.out.println("丽塔被动生效，吸取了" + dA + "点生命");
            }

            if (Math.random() < rAr) {
                fAr = true;
                System.out.println("丽塔召唤了一群冰箱，希儿被冻进冰牢");
            }

            if (bHp <= 0) {
                System.out.println("冰箱(们)：主人你回来了！");
                return true;
            }
            System.out.println("剩余血量:\n丽塔 " + aHp + "\n希儿 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameRitaVsRozaliya() {
        int dA, dB, round = 0;
        double t;
        int pAa = 26, pAd = 8, pBa = 30, pBd = 4, aHp = 100, bHp = 100;
        int fBp = 0;
        double rAp = 0.3, rAr = 0.2, rBp = 0.3;
        boolean fAr = false;
        System.out.print("Rita Vs Rozaliya");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (fAr) {
                fAr = false;
                System.out.println("萝莎莉亚被困住了，本回合无法攻击");
            } else {
                if (round % 3 == 0) {
                    System.out.println("呼啦啦旋风！");
                    dB = (15 - pAd) * 10;
                } else if (round != 1 && round % 3 == 1) {
                    dB = 0;
                    System.out.println("萝莎莉亚上回合转的有点晕，动不了");
                } else {
                    dB = pBa - pAd;
                    System.out.print("萝莎莉亚A了一下，");
                }

                if (fBp == 1) dB += (dB / 2);
                if (fBp == 2) dB -= (dB / 2);

                aHp -= dB;
                if (dB != 0)
                    System.out.println("对丽塔造成" + dB + "点物理伤害");

                if (aHp <= 0) {
                    System.out.println("萝莎莉亚：伏特加女孩今日演出成功");
                    return false;
                }
            }

            System.out.println("萝莎莉亚被动生效，开始抽取下回合buff");
            t = Math.random();
            if (t < rBp) {
                fBp = 1;
                System.out.println("Nice，下回合伤害提高50%");
            } else if (t > 1 - rBp) {
                fBp = 2;
                System.out.println("哦豁完蛋，下回合伤害降低50%");
            } else {
                fBp = 0;
                System.out.println("40% +1，下回合什么都不会发生");
            }

            dA = pAa - pBd;
            bHp -= dA;
            System.out.println("丽塔扔出一台冰箱，对萝莎莉亚造成了" + dA + "点物理伤害");

            if (Math.random() < rAp) {
                aHp += dA;
                System.out.println("丽塔被动生效，吸取了" + dA + "点生命");
            }

            if (Math.random() < rAr) {
                fAr = true;
                System.out.println("丽塔召唤了一群冰箱，萝莎莉亚被冻进冰牢");
            }

            if (bHp <= 0) {
                System.out.println("冰箱(们)：主人你回来了！");
                return true;
            }
            System.out.println("剩余血量:\n丽塔 " + aHp + "\n萝莎莉亚 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameRozaliyaVsSeele() {
        int dA, dB, round = 0;
        double t;
        int pAa = 30, pAd = 4, pBa = 23, pBd = 10, aHp = 100, bHp = 100;
        int fAp = 0;
        double rAp = 0.3, rBr = 0.25;
        System.out.print("Rozaliya Vs Seele");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            bHp += 7;
            if (bHp > 100) bHp = 100;
            System.out.println("希儿发动被动技能，回复7点生命");

            if (round % 4 == 0) {
                System.out.println("希儿开大了！");
                if (Math.random() < rBr) {
                    dB = 100 - pAd;
                    aHp -= dB;
                    System.out.println("来和希儿一起玩吧！\n对萝莎莉亚造成了" + dB + "点物理伤害");
                } else {
                    System.out.println("希儿空大了！");
                }
            } else {
                dB = pBa - pAd;
                aHp -= dB;
                System.out.println("希儿砍了一下，对萝莎莉亚造成了" + dB + "点物理伤害");
            }

            if (aHp <= 0) {
                System.out.println("希儿：总算安全了，但游戏才刚刚开始");
                return false;
            }

            if (round % 3 == 0) {
                System.out.println("呼啦啦旋风！");
                dA = (15 - pBd) * 10;
            } else if (round != 1 && round % 3 == 1) {
                dA = 0;
                System.out.println("萝莎莉亚头晕中");
            } else {
                dA = pAa - pBd;
                System.out.print("萝莎莉亚A了一下，");
            }

            if (fAp == 1) dA += (dA / 2);
            if (fAp == 2) dA -= (dA / 2);

            bHp -= dA;
            if (dA != 0)
                System.out.println("对希儿造成" + dA + "点物理伤害");

            if (bHp <= 0) {
                System.out.println("萝莎莉亚：伏特加女孩今日演出成功");
                return true;
            }

            System.out.println("萝莎莉亚被动生效，开始抽取下回合buff");
            t = Math.random();
            if (t < rAp) {
                fAp = 1;
                System.out.println("Nice，下回合伤害提高50%");
            } else if (t > 1 - rAp) {
                fAp = 2;
                System.out.println("哦豁完蛋，下回合伤害降低50%");
            } else {
                fAp = 0;
                System.out.println("就当无事发生");
            }

            System.out.println("剩余血量:\n萝莎莉亚 " + aHp + "\n希儿 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameBronyaVsTheresa() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 8, pBa = 24, pBd = 8, aHp = 100, bHp = 100;
        double rAp = 0.15;
        System.out.print("Bronya Vs Theresa(Judas)");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 2 == 0) {
                System.out.println("犹大召唤出了德丽莎");
                for (int i = 1; i <= 4; i++) {
                    if (Math.random() < rAp) {
                        System.out.println("布洛妮娅闪开了第" + i + "只德丽莎");
                    } else {
                        dB = 1 + (int) (Math.random() * 15);
                        aHp -= dB;
                        System.out.println("第" + i + "只德丽莎对布洛妮娅造成了" + dB + "点元素伤害");
                    }
                }
            } else {
                System.out.print("犹大砸了出去，");
                if (Math.random() < rAp) {
                    System.out.println("但是被布洛妮娅闪开了");
                } else {
                    dB = pBa - pAd;
                    aHp -= dB;
                    System.out.println("对布洛妮娅造成了" + dB + "点物理伤害");
                }
            }

            if (aHp <= 0) {
                System.out.println("\nTeriTeri，这一次是德丽莎赢了");
                return false;
            }

            if (round % 3 == 0) {
                dA = 1 + (int) (Math.random() * (99 - pBd));
                bHp -= dA;
                System.out.println("布洛妮娅成功分析股市行情，对犹大造成" + dA + "点物理伤害");
            } else {
                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("布洛妮娅扔出吼姆，对犹大造成" + dA + "点物理伤害");
            }

            if (bHp <= 0) {
                System.out.println("\n敌方目标全体静默，布洛妮娅请求回收");
                return true;
            }

            System.out.println("剩余血量:\n布洛妮娅 " + aHp + "\n犹大 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameFuhuaVsRozaliya() {
        int dA, dB, round = 0;
        double t;
        int pAa = 27, pAd = 8, pBa = 30, pBd = 4, aHp = 100, bHp = 100;
        int fBp = 0;
        double rBp = 0.3;
        boolean fAp = false;
        System.out.print("Fu Hua Vs Rozaliya");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 3 == 0) {
                dA = 10 + (int) (Math.random() * 20);
                bHp -= dA;
                System.out.println("符华召唤出巨大的赤鸢，对萝莎莉亚造成" + dA + "点元素伤害");
            } else {
                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("寸劲开天，符华对萝莎莉亚造成" + dA + "点物理伤害");
            }

            if (bHp <= 0) {
                System.out.println("\n这一次的表现不够完美");
                return true;
            }

            if (round % 3 == 0) {
                dB = (15 - pAd) * 10;
                System.out.println("呼啦啦旋风！");
            } else if (round != 1 && round % 3 == 1) {
                dB = 0;
                System.out.println("萝莎莉亚上回合转的有点晕，动不了");
            } else {
                dB = pBa - pAd;
                System.out.print("萝莎莉亚A了一下，");
            }

            if (fBp == 1) dB += (dB / 2);
            if (fBp == 2) dB -= (dB / 2);

            aHp -= dB;
            if (dB != 0)
                System.out.println("对符华造成" + dB + "点物理伤害");

            if (aHp <= 0) {
                if (fAp) {
                    System.out.println("\n不好意思，出bug了");
                    return false;
                } else {
                    fAp = true;
                    aHp = 1;
                    System.out.println("符华开启锁血挂");
                }
            }

            System.out.println("萝莎莉亚被动生效，开始抽取下回合buff");
            t = Math.random();
            if (t < rBp) {
                fBp = 1;
                System.out.println("下回合伤害提高50%");
            } else if (t > 1 - rBp) {
                fBp = 2;
                System.out.println("下回合伤害降低50%");
            } else {
                fBp = 0;
                System.out.println("下回合什么都不会发生");
            }

            System.out.println("剩余血量:\n符华 " + aHp + "\n萝莎莉亚 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameMeiVsSakura() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 6, pBa = 28, pBd = 7, aHp = 100, bHp = 100;
        int cBp = 0;
        double rAr = 0.3, rBp = 0.2, rBr = 0.25;
        boolean fAr = false;
        System.out.print("Mei Vs Sakura");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (fAr) System.out.println("嘤嘤嘤被沉默了，本回合不会触发技能");

            dB = pBa - pAd;

            if (Math.random() < rBr && !fAr) {
                dB *= 2;
                System.out.print("嘤嘤嘤发动了必杀技，");
            } else {
                System.out.print("嘤嘤嘤砍了出去，");
            }

            aHp -= dB;
            System.out.println("对芽衣造成了" + dB + "点物理伤害");

            if (aHp <= 0) {
                System.out.println("\n大姐你回来了");
                return false;
            }

            if (Math.random() < rBp && !fAr) {
                cBp = 3;
                System.out.println("嘤嘤嘤发动被动技能，点燃了芽衣");
            }

            if (fAr) {
                fAr = false;
                System.out.println("嘤嘤嘤解除了芽衣的沉默");
            }

            dA = pAa - pBd;
            bHp -= (dA + 5);
            System.out.println("芽衣砍了出去，对嘤嘤嘤造成" + dA + "点物理伤害和5点元素伤害");

            if (Math.random() < rAr) {
                bHp -= 15;
                fAr = true;
                System.out.println("芽衣发动必杀技，再次对嘤嘤嘤造成15点元素伤害，并沉默了嘤嘤嘤");
            }

            if (bHp <= 0) {
                System.out.println("\n是时候回去了，舰长");
                return true;
            }

            if (cBp-- > 0) {
                aHp -= 5;
                System.out.println("芽衣被点燃烫了5点元素伤害");
            }

            if (aHp <= 0) {
                System.out.println("\n大姐你回来了");
                return false;
            }

            System.out.println("剩余血量:\n芽衣 " + aHp + "\n嘤嘤嘤 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameKallenVsRita() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 6, pBa, pBd = 8, aHp = 100, bHp = 100;
        int cAr = 0;
        double rAp = 0.05, rAr = 0.3, rBp = 0.3, rBr = 0.2;
        boolean fBr = false;
        System.out.print("Kallen Vs Rita");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (fBr) {
                fBr = false;
                System.out.println("卡莲花了一回合从冰箱里出来");
            } else {
                System.out.print("卡莲A了出去，");

                if (Math.random() < rAp) {
                    System.out.println("被动技能生效，丽塔被打成了废人\n\n一起买菜！");
                    return true;
                }

                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("对丽塔造成了" + dA + "点物理伤害");

                if (bHp <= 0) {
                    System.out.println("\n一起买菜！");
                    return true;
                }

                if (Math.random() < rAr) {
                    cAr = 2;
                    System.out.println("卡莲发动必杀技，丽塔攻击力降低两回合");
                }
            }

            pBa = 26;
            if (cAr-- > 0) {
                pBa -= 15;
                System.out.println("卡莲必杀技生效，丽塔攻击力降低");
            }

            dB = pBa - pAd;
            aHp -= dB;
            System.out.println("丽塔扔出了冰箱，对卡莲造成了" + dB + "点物理伤害");

            if (aHp <= 0) {
                System.out.println("\n冰箱(们)：主人你回来了");
                return false;
            }

            if (Math.random() < rBp) {
                bHp += dB;
                if (bHp > 100) {
                    dB -= (bHp - 100);
                    bHp = 100;
                }
                System.out.println("丽塔被动技能发动，回复了" + dB + "点生命");
            }

            if (Math.random() < rBr) {
                fBr = true;
                System.out.println("丽塔必杀技发动，将卡莲放进了冰箱");
            }

            System.out.println("剩余血量:\n卡莲 " + aHp + "\n丽塔 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameBronyaVsFuhua() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 8, pBa = 27, pBd = 8, aHp = 100, bHp = 100;
        double rAp = 0.15;
        boolean fBp = false;
        System.out.print("Bronya Vs Fu Hua");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 3 == 0) {
                System.out.print("符华发动必杀技召唤出巨大的赤鸢，");
                if (Math.random() < rAp) {
                    System.out.println("但是被布洛妮娅闪掉了");
                } else {
                    dB = 10 + (int) (Math.random() * 20);
                    aHp -= dB;
                    System.out.println("对布洛妮娅造成" + dB + "点元素伤害");
                }
            } else {
                System.out.print("符华使出了寸劲开天，");
                if (Math.random() < rAp) {
                    System.out.println("但是被布洛妮娅闪开了");
                } else {
                    dB = pBa - pAd;
                    aHp -= dB;
                    System.out.println("对布洛妮娅造成了" + dB + "点物理伤害");
                }
            }

            if (aHp <= 0) {
                System.out.println("\n这一次的表现不够完美");
                return false;
            }

            if (round % 3 == 0) {
                int t = 1 + (int) (Math.random() * 99);
                dA = Math.max(0, t - pBd);
                bHp -= dA;
                System.out.println("布洛妮娅成功分析股市行情");
                System.out.println("扔出了" + t + "枚金币，对符华造成" + dA + "点物理伤害");
            } else {
                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("布洛妮娅扔出吼姆，对符华造成" + dA + "点物理伤害");
            }

            if (bHp <= 0) {
                if (fBp) {
                    System.out.println("\n敌方目标全体静默，布洛妮娅请求回收");
                    return true;
                } else {
                    fBp = true;
                    bHp = 1;
                    System.out.println("符华开启锁血挂");
                }
            }

            System.out.println("剩余血量:\n布洛妮娅 " + aHp + "\n符华 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameKallenVsSakura() {
        int dA, dB, round = 0;
        int pAa = 26, pAd = 6, pBa, pBd = 7, aHp = 100, bHp = 100;
        int cAr = 0, cBp = 0;
        double rAp = 0.05, rAr = 0.3, rBp = 0.2, rBr = 0.25;
        System.out.print("Kallen Vs Sakura");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            System.out.print("卡莲A了出去，");

            if (Math.random() < rAp) {
                System.out.println("被动技能生效，老婆被打成了废人\n\n一起买菜！");
                return true;
            }

            dA = pAa - pBd;
            bHp -= dA;
            System.out.println("对老婆造成了" + dA + "点物理伤害");

            if (bHp <= 0) {
                System.out.println("\n一起买菜！");
                return true;
            }

            if (Math.random() < rAr) {
                cAr = 2;
                System.out.println("卡莲发动必杀技，老婆攻击力降低两回合");
            }

            pBa = 28;
            if (cAr-- > 0) {
                pBa -= 15;
                System.out.println("卡莲必杀技生效，老婆攻击力降低");
            }

            dB = pBa - pAd;

            if (Math.random() < rBr) {
                dB *= 2;
                System.out.print("嘤嘤嘤打出了暴击，");
            } else {
                System.out.print("嘤嘤嘤A了一下，");
            }

            aHp -= dB;
            System.out.println("对老婆造成了" + dB + "点物理伤害");

            if (aHp <= 0) {
                System.out.println("\n大姐你回来了");
                return false;
            }

            if (Math.random() < rBp) {
                cBp = 3;
                System.out.println("嘤嘤嘤发动被动技能，把老婆点了(?)");
            }

            if (cBp-- > 0) {
                aHp -= 5;
                System.out.println("卡莲被老婆的点燃烫了5点元素伤害");
            }

            if (aHp <= 0) {
                System.out.println("\n大姐你回来了");
                return false;
            }

            System.out.println("剩余血量:\n卡莲 " + aHp + "\n嘤嘤嘤 " + bHp);
        }
    }

    @SuppressWarnings("unused")
    private static boolean gameFuhuaVsSakura() {
        int dA, dB, round = 0;
        int pAa = 27, pAd = 8, pBa = 28, pBd = 7, aHp = 100, bHp = 100;
        int cBp = 0;
        double rBp = 0.2, rBr = 0.25;
        boolean fAr = false;
        System.out.print("Fu Hua Vs Sakura");
        while (true) {
            System.out.println("\n第" + ++round + "回合:");

            if (round % 3 == 0) {
                dA = 10 + (int) (Math.random() * 20);
                bHp -= dA;
                System.out.println("符华召唤出巨大的赤鸢，对嘤嘤嘤造成" + dA + "点元素伤害");
            } else {
                dA = pAa - pBd;
                bHp -= dA;
                System.out.println("寸劲开天，符华对嘤嘤嘤造成" + dA + "点物理伤害");
            }

            if (bHp <= 0) {
                System.out.println("\n符华：我也不知道为啥，反正我赢了");
                return true;
            }

            dB = pBa - pAd;

            if (Math.random() < rBr) {
                dB *= 2;
                System.out.print("嘤嘤嘤打出了暴击，");
            } else {
                System.out.print("嘤嘤嘤A了一下，");
            }

            aHp -= dB;
            System.out.println("对符华造成了" + dB + "点物理伤害");

            if (aHp <= 0) {
                if (fAr) {
                    System.out.println("\n嘤嘤嘤：我也不知道为啥，反正我赢了");
                    return false;
                } else {
                    aHp = 1;
                    fAr = true;
                    System.out.println("符华开启锁血挂");
                }
            }

            if (Math.random() < rBp) {
                cBp = 3;
                System.out.println("嘤嘤嘤发动被动技能，点燃了符华");
            }

            if (cBp-- > 0) {
                if (fAr) {
                    System.out.println("符华持有锁血挂，免疫元素伤害(点燃)");
                } else {
                    aHp -= 5;
                    System.out.println("符华被嘤嘤嘤的点燃烫了5点元素伤害");
                    if (aHp <= 0) {
                        aHp = 1;
                        fAr = true;
                        System.out.println("符华开启锁血挂");
                    }
                }
            }

            System.out.println("剩余血量:\n符华 " + aHp + "\n嘤嘤嘤 " + bHp);
        }
    }
}
