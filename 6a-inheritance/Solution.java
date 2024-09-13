import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

abstract class Sequence {
    int getNthNumber(int n) {
        return n;
    };
}

class Fibonacci extends Sequence {
    int getNthNumber(int n) {
        if(n == 1) {
            return 0;
        }
        else if(n == 2) {
            return 1;
        }
        else {
            int a = 0, b = 1, c = a + b;
            for(int i = 3; i <= n; ++i) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}

class ArithmeticProgression extends Sequence {
    int a = 0, d = 0;
    
    ArithmeticProgression(int a, int d) {
        this.a = a;
        this.d = d;
    }
    
    int getNthNumber(int n) {
        return this.a + (n - 1) * this.d;
    }
}

class WholeNumbers extends ArithmeticProgression {
    WholeNumbers() {
        super(0, 1);
    }
}

class MultiplesOfFive extends ArithmeticProgression {
    MultiplesOfFive() {
        super(0, 5);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String seq_type = input.split(" ")[0];
        int n = Integer.parseInt(input.split(" ")[1]);
        if(seq_type.equals("ap")) {
            int a = Integer.parseInt(input.split(" ")[2]), d = Integer.parseInt(input.split(" ")[3]);
            ArithmeticProgression ap = new ArithmeticProgression(a, d);
            System.out.println(ap.getNthNumber(n));
        }
        else if(seq_type.equals("fibonacci")) {
            Fibonacci fib = new Fibonacci();
            System.out.println(fib.getNthNumber(n));
        }
        else if(seq_type.equals("whole")) {
            WholeNumbers whole = new WholeNumbers();
            System.out.println(whole.getNthNumber(n));
        }
        else if(seq_type.equals("five")) {
            MultiplesOfFive five = new MultiplesOfFive();
            System.out.println(five.getNthNumber(n));
        }
    }
}
