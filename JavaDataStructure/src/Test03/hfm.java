package Test03;

import java.util.PriorityQueue;
import java.util.Scanner;


public class hfm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        scanner.close();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(weights[i]);
        }

        int wpl = 0;
        while (pq.size() > 1) {
            int left = pq.poll();
            int right = pq.poll();
            int sum = left + right;
            pq.offer(sum);
            wpl += sum;
        }

        System.out.println(wpl);
    }
}


