import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SignUp {
    String email = "";
    long phone_num = -1;
    
    SignUp(String contact) {
        this.email = contact;
    }
    SignUp(long contact) {
        this.phone_num = contact;
    }
    String get_contact() {
        if(this.phone_num == -1) {
            return this.email;
        }
        else {
            long sum;
            for(sum=0; this.phone_num!=0; this.phone_num=this.phone_num/10) {  
                sum = sum + this.phone_num % 10;
            }
            return Long.toString(sum);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        String[] contacts = input.split(",");
        for(String c: contacts) {
            if(c.contains("@")) {
                SignUp x = new SignUp(c);
                System.out.println(x.get_contact());
            }
            else {
                SignUp x = new SignUp(Long.parseLong(c));
                System.out.println(x.get_contact());
            }
        }
    }
}
