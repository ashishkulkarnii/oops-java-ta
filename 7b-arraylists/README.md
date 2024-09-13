## Lab 7: Abstract Classes, ArrayLists, Linked Lists, and Stacks

### [ArrayLists Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/arraylist-ooadj)

Compulsorily use the concept of ArrayList to solve this problem. Failure to abide by this rule will result in zero marks.

A list of cars models (comma-separated), will be given in one line.
In the next line, there will be a list of horsepowers, which correspond to the respective cars above.

Populate two Java ArrayLists, one of car models and one of their horsepowers.
Sort the car models by their horsepowers.
As output, use the car model ArrayList's `toString()` method and print.

Input Example:
```
Mustang,Miata,Z
650,150,400
```

Constraints:
- `1 <= n <= 100`, where `n` is the number of car models.

Every car's name is unique.

Output Example:
```
[Miata, Z, Mustang]
```

### Code

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cars = sc.nextLine().split(",");
        String[] horsepowers = sc.nextLine().split(",");
        ArrayList<String> carModels = new ArrayList<String>(Arrays.asList(cars));
        ArrayList<String> carHorsepowers = new ArrayList<String>(Arrays.asList(horsepowers));
        ArrayList<Integer> carHorsepowersInt = new ArrayList<Integer>();
        for (String s : carHorsepowers) {
            carHorsepowersInt.add(Integer.parseInt(s));
        }
        for (int i = 0; i < carHorsepowersInt.size(); i++) {
            for (int j = i + 1; j < carHorsepowersInt.size(); j++) {
                if (carHorsepowersInt.get(i) > carHorsepowersInt.get(j)) {
                    int temp = carHorsepowersInt.get(i);
                    carHorsepowersInt.set(i, carHorsepowersInt.get(j));
                    carHorsepowersInt.set(j, temp);
                    String temp2 = carModels.get(i);
                    carModels.set(i, carModels.get(j));
                    carModels.set(j, temp2);
                }
            }
        }
        System.out.println(carModels.toString());
    }
}
```
