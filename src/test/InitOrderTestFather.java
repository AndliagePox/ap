/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package test;

public class InitOrderTestFather {
    static {
        System.out.println("father static init block");
    }

    InitOrderTestFather(String s) {
        System.out.println("new iot f: " + s);
    }
}
