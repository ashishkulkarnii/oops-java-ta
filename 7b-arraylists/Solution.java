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