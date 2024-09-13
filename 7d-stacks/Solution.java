import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> mainStack = new Stack<Integer>();
        Stack<Integer> tempStack = new Stack<Integer>();
        while (sc.hasNext()) {
            int num = sc.nextInt();
            while (!mainStack.isEmpty() && num < mainStack.peek()) {
                tempStack.push(mainStack.pop());
            }
            mainStack.push(num);
            while (!tempStack.isEmpty()) {
                mainStack.push(tempStack.pop());
            }
        }
        System.out.println(mainStack.toString());
    }
}
