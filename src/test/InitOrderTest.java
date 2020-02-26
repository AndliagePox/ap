/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package test;

public class InitOrderTest extends InitOrderTestFather{

    {
        System.out.println("init block");
    }

    InitOrderTestHelper helper = new InitOrderTestHelper("");

    static {
        System.out.println("static init block");
    }

    static InitOrderTestHelper sHelper = new InitOrderTestHelper("static");

    public static void main(String[] args) {
        new InitOrderTest("main");
    }

    private InitOrderTest(String s) {
        super(s);
        System.out.println("new iot: " + s);
    }
}
