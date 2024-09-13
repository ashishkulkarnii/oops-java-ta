import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

class Employee {
    String name = "";
    String num = "";
    String job = "";
    Employee(String name) {
        this.name = name;
    }
    void writejob(int id) {
        this.job = "Job ID: " + String.valueOf(id);
    }
    void writejob(String job) {
        this.job = job;
    }
    void writenum(long num) {
        this.num = String.valueOf(num);
    }
    void writenum(long n1, long n2) {
        this.num = "home: " + String.valueOf(n1) + " work: " + String.valueOf(n2);
    }
    void res() {
        System.out.println(this.name);
        System.out.println(this.job);
        System.out.println(this.num);
        
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        Employee e = new Employee(name);
        String job = s.nextLine();
        if(Character.isDigit(job.charAt(0))) {
            e.writejob(Integer.parseInt(job));
        }
        else {
            e.writejob(job);
        }
        String phno = s.nextLine();
        s.close();
        if(phno.contains(" ")) {
            long num1 = Long.parseLong(phno.split(" ")[0]);
            long num2 = Long.parseLong(phno.split(" ")[1]);
            e.writenum(num1, num2);
        }
        else {
            e.writenum(Long.parseLong(phno));
        }
        e.res();
    }
}