package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        int[] states = {1,0,0,0,0,1,0,0};

        System.out.println(cellComplete(states, 1));

//        int arr[] = { 2, 3, 4, 5, 6 };
//        int n = arr.length;
//        System.out.println(generalizedGcd(5, arr));
    }

    public static List<Integer> cellComplete(int[] states, int days){
        if(days == 0 || states== null || states.length ==0){
            return Arrays.stream(states).boxed().collect(Collectors.toList());
        }

        List<Integer> s1 = new ArrayList<>();
        for(int i = 0; i < states.length+2; i++) {
            if (i == 0 || i == states.length + 1) {
                s1.add(0);
            }else {
                s1.add(states[i-1]);
            }
        }

        for(int i=0 ;i < days; i++){
            int left=0, right = s1.get(2);
            for(int j = 1 ; j < s1.size()-2 ; j++){
                int currentCellState = s1.get(j);
                s1.set(j, left==right? 0 : 1);
                left = currentCellState;
                right = s1.get(j+2);
            }
            s1.set(s1.size()-1, left==right? 0 : 1);
        }

        return s1.subList(1, 9);
    }

    public static int generalizedGcd(int num, int arr[]) {
        int gcd = arr[0];
        for (int i = 1; i < num; i++) {
            gcd = findGCD(arr[i], gcd);
        }
        return gcd;
    }
    public static int findGCD(int n1, int n2) {
        if (n1 == 0)
            return n2;
        return findGCD(n2 % n1, n1);
    }
}
