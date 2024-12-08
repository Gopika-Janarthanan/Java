package BinarySearch;

import java.util.Scanner;

public class Floor {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int [] array ={1,3,5,7,9};
        System.out.print("Enter target : ");
        int target = input.nextInt();
        int ans =ceiling(target,array);
        System.out.println(ans);

    }
    static int ceiling(int target, int[] array){
        int s =0;
        int e= array.length-1;
        while (s<=e){
            int mid = s+(e-s)/2;
            if (target<array[mid]){
                e=mid-1;
            }
            else if (target> array[mid]){
                s=mid+1;
            }
            else{
                return array[mid] ;
            }
        }
        return array[e];
    }
}
