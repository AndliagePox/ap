/*
 * Author: Andliage Pox
 * Date: 2021-02-20
 */

package foo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotateGame {
    public static void main(String[] args) {
        Situation start = new Situation(3, 3, 3, new LinkedList<>(), 0);
        Situation target = new Situation(1, 1, 1, new LinkedList<>(), 0);
        Situation result = start.findResult(target);
        System.out.println(result.history);
    }
}

class Situation {
    static Situation result = null;

    int a, b, c;
    List<Integer> history;

    public Situation(int a, int b, int c, List<Integer> history, int append) {
        this.a = a > 3 ? 1 : a;
        this.b = b > 3 ? 1 : b;
        this.c = c > 3 ? 1 : c;
        this.history = new LinkedList<>(history);
        if (append != 0) {
            this.history.add(append);
        }
    }

    public Situation findResult(Situation tar) {
        result = null;

        Queue<Situation> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty() && result == null) {
            Situation cur = queue.poll();
            if (cur.equals(tar)) {
                result = cur;
                break;
            }
            queue.add(new Situation(cur.a + 1, cur.b + 1, cur.c, cur.history, 1));
            queue.add(new Situation(cur.a, cur.b + 1, cur.c + 1, cur.history, 2));
            queue.add(new Situation(cur.a + 1, cur.b, cur.c + 1, cur.history, 3));
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Situation situation = (Situation) o;

        if (a != situation.a) return false;
        if (b != situation.b) return false;
        return c == situation.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
}