package BinarySearch;

import java.util.Scanner;

public class Binarysearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] array ={1,2,3,4};
        System.out.print("Enter target : ");
        int target = input.nextInt();
        int ans =bs(target,array);
        System.out.println(ans);

    }
    static int bs(int target , int [] array){
        int s =0;
        int e = array.length-1 ;
        while(s<=e){
            int mid = s+(e-s)/2;
            if (array[mid] < target){
                s=mid+1;
            }
            else if (array[mid]>target){
                e=mid-1;
}
            else{
                return mid;
            }
        }
        return -1;
    }
}
