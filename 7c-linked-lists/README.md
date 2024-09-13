### [Linked Lists Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/linked-list-ooadj)

Compulsorily use the concept of Linked List to solve this problem. Failure to abide by this rule will result in zero marks.

The input will be a single line of words, separated by single spaces.

Create a linked list, and based on each input, perform an action on this linked list:

1. If the word is a number, then add it to the end list.
2. If the word is `+`, then add all the existing elements in the list, and add this sum to the beginning of the list.
3. If the word is `-`, then subtract the last element of the list from the 2nd last element of the list, and add it to the end of the list.
4. If the word is `d`, then add a number equal to the first element to the end of the list.
5. Any of the above actions is not possible, then ignore the input word and move on to the next one.

Finally, print the list using it's `toString()` method.

Input Example:
```
12 13 2 4 + - + d d
```

Constraints:
- Number of words, `n < 100`.

Output Example:
```
[60, 31, 12, 13, 2, 4, -2, 60, 60]
```

### Code

```java
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
```
