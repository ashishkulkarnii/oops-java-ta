## Lab 7: Abstract Classes, ArrayLists, Linked Lists, and Stacks

### [Abstract Classes Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/abstract-class-ooadj)

Compulsorily use the concept of abstract classes to solve this problem. Failure to abide by this rule will result in zero marks.

Create an abstract class called `Shape`. Create classes `Square` and `Triangle` that extend `Shape`. Each class must have two methods: `drawSolid()`, `drawHollow()` and `getArea()`, and one integer variables `x`. An object of either of these classes must be instantiated using `x`.

Draw the shapes using `.` (period). Examples are given below.

After drawing, print the area of the shape using `getArea()`. (`getArea()` returns a floating-point value.)

Input Format:
`<square or tri> <x> <solid or hollow>`

Constraints:
- `1 <= x <= 20`

Output Examples:

```
square 5 hollow:
.....
.   .
.   .
.   .
.....
25.0
```

```
tri 5 hollow
.
..
. .
.  .
.....
12.5
```

### Code

```java
// import java.io.*;
import java.util.*;

abstract class Shape {
    int x;

    Shape(int x) {
        this.x = x;
    }

    abstract void drawSolid();

    abstract void drawHollow();

    abstract double getArea();
}

class Square extends Shape {
    Square(int x) {
        super(x);
    }

    void drawSolid() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }

    void drawHollow() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == x - 1) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    double getArea() {
        return x * x;
    }
}

class Triangle extends Shape {
    Triangle(int x) {
        super(x);
    }

    void drawSolid() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }

    void drawHollow() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == i) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    double getArea() {
        return 0.5 * x * x;
    }
}

public class Solution {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        String shape = sc.next();
        int x = sc.nextInt();
        String type = sc.next();

        if (shape.equals("square")) {
            Square s = new Square(x);
            if (type.equals("solid")) {
                s.drawSolid();
            } else {
                s.drawHollow();
            }
            System.out.println(s.getArea());
        } else {
            Triangle t = new Triangle(x);
            if (type.equals("solid")) {
                t.drawSolid();
            } else {
                t.drawHollow();
            }
            System.out.println(t.getArea());
        }
        sc.close();
    }
}
```
