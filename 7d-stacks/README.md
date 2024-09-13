### [Stacks Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/stack-ooadj)

Compulsorily use the concept of Stack to solve this problem. Failure to abide by this rule will result in zero marks.

You will be given a list of numbers, separated by newlines, as your input. Using only two stacks, and no built-in sorting methods, ensure that the main stack is sorted such that the top is the largest number.

Finally, use the toString() method and print the contents of the stack.

_Hint:_
The logic is as follows (don't read it if you want a challenge, but reading it won't make it super easy either):
- As you read numbers, push them onto the stack.
- If a number you are pushing onto the stack is lesser than the top, then keep popping elements (into temporary stack) until you are able to push the current number onto the stack.
- Return all temp stack elements to the main stack, and continue.

Input Format:
- One number per line, upto 1000 lines.

Constraints:
- Number of numbers <= 1000

Output Format:
- System.out.println(stack.toString())

### Code

```java
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
```
