/*
 * Author: Andliage Pox
 * Date: 2020-01-14
 */

package bh3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 模拟测试一个角色抽毕业需要多少发
 */
public class GraduateTest {
    private static int totalTimes = 1000000;
    private static int threadCount = 1;
    private static int completeThreads = 0;

    private static int totalCount = 0;
    private static int totalCountS = 0;
    private static int totalCountE = 0;

    private static final Object writeLock = new Object();
    private static final Object completeLock = new Object();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(), endTime;
        Thread[] threads = new Thread[threadCount];

        for (int t = 0; t < threadCount; t++) {
            threads[t] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " rs");
                    int i, s, e, times = totalTimes / threadCount;
                    int countS = 0, countE = 0, count = 0;
                    for (i = 0; i < times; i++) {
                        s = getS();
                        e = getEquipmentsWithWish();
                        count += s + e;
                        countS += s;
                        countE += e;
                    }
                    System.out.println(Thread.currentThread().getName() + " re");
                    synchronized (writeLock) {
                        totalCount += count;
                        totalCountS += countS;
                        totalCountE += countE;
                        completeThreads++;
                        System.out.println(Thread.currentThread().getName() + " ce");
                        if (completeThreads == threadCount) {
                            synchronized (completeLock) {
                                System.out.println(Thread.currentThread().getName() + " ne");
                                completeLock.notifyAll();
                            }
                        }
                    }
                }
            });
            threads[t].start();
        }

        try {
            synchronized (completeLock) {
                completeLock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();

        System.out.println("平均获取人物需要抽数： " + totalCountS / totalTimes);
        System.out.println("平均获取装备需要抽数： " + totalCountE / totalTimes);
        System.out.println("平均毕业需要抽数： " + totalCount / totalTimes);
        System.out.println("采用" + threadCount + "线程测试" + totalTimes + "组共耗时： " + (endTime - startTime) + "ms");
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

    @SuppressWarnings("unused")
    private static int getEquipments() {
        int count = 0, upTimes = 0;
        boolean weapon = false, sA = false, sB = false, sC = false;
        double random;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        while (true) {
            count++;
            random = tlr.nextDouble();
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

    /**
     * 有许愿池的情况
     * @return 抽数
     */
    @SuppressWarnings("unused")
    private static int getEquipmentsWithWish() {
        int count = 0, upTimes = 0, sA = 0, sB = 0, sC = 0, sType;
        boolean weapon = false;
        double random;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        while (true) {
            count++;
            random = tlr.nextDouble();
            if (upTimes == 9) {
                upTimes = 0;
                if (random < 0.2) {
                    weapon = true;
                } else if (random < 0.3) {
                    sA++;
                } else if (random < 0.4) {
                    sB++;
                } else if (random < 0.5) {
                    sC++;
                }
            } else {
                if (random < 0.12395) {
                    upTimes = 0;
                    if (random < 0.02479) {
                        weapon = true;
                    } else if (random < 0.03719) {
                        sA++;
                    } else if (random < 0.04959) {
                        sB++;
                    } else if (random < 0.06199) {
                        sC++;
                    }
                } else {
                    upTimes++;
                }
            }
            sType = 0;
            if (sA > 0) sType++;
            if (sB > 0) sType++;
            if (sC > 0) sType++;
            if (sType >= 2 && sA + sB + sC >= 4) {
                return count;
            }
            if (weapon && sA > 0 && sB > 0 && sC > 0) {
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
