import java.util.*;

public class Traffic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        

  

        System.out.println(visited[destination] ? "YES" : "NO");
    }
}

#Input & Output 
  5 4
  1 2
  2 3
  3 4
  4 5
  1 5
  YES
