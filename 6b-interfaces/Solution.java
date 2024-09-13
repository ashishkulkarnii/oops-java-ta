import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Encryption {
    public void encrypt();
    public void decrypt();
}

class FooEncryption implements Encryption {
    String str;
    
    FooEncryption(String str) {
        this.str = str;
    }
    
    public void encrypt() {
        String res = "";
        for(int i = 0; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) - (i % 2) + 3);
            res = res + c;
        }
        this.str = res;
    }
    
    public void decrypt() {
        String res = "";
        for(int i = 0; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) + (i % 2) - 3);
            res = res + c;
        }
        this.str = res;
    }
}

class BarEncryption implements Encryption {
    String str;
    
    BarEncryption(String str) {
        this.str = str;
    }
    
    public void encrypt() {
        String res = String.valueOf(this.str.charAt(0));
        for(int i = 1; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) - ((int) this.str.charAt(i - 1)) + 80);
            res = res + c;
        }
        this.str = res;   
    }
    
    public void decrypt() {
        String res = String.valueOf(this.str.charAt(0));
        for(int i = 1; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) + ((int) this.str.charAt(i - 1)) - 80);
            res = res + c;
        }
        this.str = res;   
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String fb = input.split(" ")[0], ed = input.split(" ")[1], str = input.split(" ")[2];
        if(fb.equals("foo")) {
            FooEncryption x = new FooEncryption(str);
            if(ed.equals("en")) {
                x.encrypt();
                System.out.println(x.str);
            }
            else {
                x.decrypt();
                System.out.println(x.str);
            }
        }
        else {
            BarEncryption x = new BarEncryption(str);
            if(ed.equals("en")) {
                x.encrypt();
                System.out.println(x.str);
            }
            else {
                x.decrypt();
                System.out.println(x.str);
            }
        }
    }
}