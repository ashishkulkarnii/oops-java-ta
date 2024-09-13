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