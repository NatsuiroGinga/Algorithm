package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ginga
 * @since 27/4/2023 下午9:08
 */
public class Sword106 {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);

        for (int i = 0; i < size; i++) {
            if (colors[i] == -1)
                if (!setColors(graph, colors, i))
                    return false;
        }

        return true;
    }

    private boolean setColors(int[][] graph, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int neighbor : graph[v]) {
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[v]) return false;
                } else {
                    queue.offer(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }

    private boolean setColors(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] >= 0) {
            return colors[i] == color;
        }

        colors[i] = color;

        for (int neighbor : graph[i]) {
            if (!setColors(graph, colors, neighbor, 1 - color))
                return false;
        }

        return true;
    }
}
