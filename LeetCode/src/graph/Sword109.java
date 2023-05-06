package graph;

import java.util.*;

/**
 * @author ginga
 * @since 27/4/2023 下午10:23
 */
public class Sword109 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> vis = new HashSet<>();
        String begin = "0000";
        if (dead.contains(begin) || dead.contains(target)) {
            return -1;
        }

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        int steps = 0;
        q1.offer(begin);
        vis.add(begin);

        while (!q1.isEmpty()) {
            final String cur = q1.poll();
            if (cur.equals(target)) {
                return steps;
            }

            List<String> neighbors = getNeighbors(cur);
            for (String n : neighbors) {
                if (!dead.contains(n) && !vis.contains(n)) {
                    q2.offer(n);
                    vis.add(n);
                }
            }

            if (q1.isEmpty()) {
                steps++;
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        return -1;
    }

    private List<String> getNeighbors(String cur) {
        List<String> nexts = new LinkedList<>();

        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            char nextChar = c == '0' ? '9' : (char) (c - 1);
            final StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, nextChar);
            nexts.add(builder.toString());

            nextChar = c == '9' ? '0' : (char) (c + 1);
            builder.setCharAt(i, nextChar);
            nexts.add(builder.toString());
        }

        return nexts;
    }
} 
