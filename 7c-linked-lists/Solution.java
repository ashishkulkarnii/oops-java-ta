import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        String[] input = sc.nextLine().split(" ");
        sc.close();
        for (String s : input) {
            if (s.equals("+")) {
                if (list.size() < 1) {
                    continue;
                }
                int sum = 0;
                for (int i : list) {
                    sum += i;
                }
                list.addFirst(sum);
            } else if (s.equals("-")) {
                if (list.size() < 2) {
                    continue;
                }
                int last = list.removeLast();
                int secondLast = list.getLast();
                list.addLast(last);
                list.addLast(secondLast - last);
            } else if (s.equals("d")) {
                if (list.size() < 1) {
                    continue;
                }
                list.addLast(list.getFirst());
            } else {
                list.addLast(Integer.parseInt(s));
            }
        }
        System.out.println(list.toString());
    }
}