package JAVA_DSA_FINAL;
import java.util.*;
public class Basic_level {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
      //  System.out.print("Enter your Target : ");
       // int tar= input.nextInt();
     //   LinearSearch.LinearTarget(new int[]{4,5,12,1,2,0},tar);
      //  System.out.println(LinearSearch.StringTarget(new int[]{4,5,12,1,2,0}, tar));
       // System.out.println(LinearSearch.searchInRange(2,9,new int[]{1,2,3,4,5,6,7,13,8,9,10,12},tar));
      //  System.out.println(LinearSearch.min(new int []{1,23,34,3}));
    }
}
class LinearSearch{
    static int min(int[] arr){
        for(int i=0;i<arr.length;i++){
            if (arr[i] < arr[i + 1]){
                int t= arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=t;
            }
            return arr[i];
        }    return -1;}
    static boolean searchInRange(int start, int end, int [] arr,int target){
        for(int i=start ; i<end ;i++ ){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }
    static void LinearTarget(int [] array, int target) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }
    static boolean StringTarget(int[] arr,int tar){
        for(int i : arr){
            if(i==tar){
               return true;
            }

        }
        return false;
    }
}
