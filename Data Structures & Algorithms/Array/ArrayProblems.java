package Core_Java;
import java.lang.*;
import java.util.*;
public class Basics {
    public static void main(String[] args) {
      Scanner in= new Scanner(System.in);
      System.out.println(sum(4));
      System.out.println(sumOdd(10));
      System.out.println(sumEven(10));
      System.out.println(squre(6));
      System.out.println(vowel("gopiIkaaAa"));
      System.out.println(strtoint("Hel1lo Bes2oss ,4 how are you?"));
      String[] str={"abc12","ef","jkgv12342","23","345"};
      countOfStringArray(str);
      System.out.println(sum(12234));*/
      targetIndex(new int[]{1, 3, 2, 4},5);
      fizzBuzz(15);
      fizzBuzz(8);
      fizzBuzz(12);
      fizzBuzz(20);*/
      reverseString("gopika J");
      palindrome("gopika");
      revstr("hello gopika janarthanan");


    }
    static int sumDigit(int num){
        int sum=0;
        int count=0;
        while(num>0){
            count=count + num%10;
            sum=count+num*10;
        }
        return sum;
    }
    static void revstr(String s){
        StringBuilder str = new StringBuilder(s);
        str.reverse().toString();
         }
    static void palindrome(String s){
        char[] c=s.toCharArray();
        int st=0;
        int e=c.length-1;
        while(st<e){
        if(c[st]!=c[e]){
            System.out.println("not palindrome");
            break;
        }
        else{
            st++;
            e--;
        }
            System.out.println("palindedome");
        }
    }
    static void fizzBuzz(int n){
        if(n%3==0 && n%5==0){
            System.out.println("fizz bizz");
        }
        else if (n%5==0){
            System.out.println("bizz");
        }
        else if(n%3==0){
            System.out.println("fizz");
        }
        else{
            System.out.println("nothing");
        }
    }
    static void reverseString(String s){
        char[] cs=s.toCharArray();
        String str="";
        for (int i = cs.length-1; i >= 0; i--) {
            str+=cs[i];
        }
        System.out.println(str.toUpperCase());
    }
    static void targetIndex(int[]array, int target){
        int s=0,e=array.length;
        Arrays.sort(array);
        while(s<e){
            if(array[s]+array[s+1] == target){
                System.out.println( array[s]+" "+array[s+1]);
                return;
            }


        }
    }
    static void countOfStringArray(String[] strarr){
        int [] n= new int[strarr.length];
        for (int i = 0; i < strarr.length; i++) {
            String reg = strarr[i].replaceAll("[^\\d]", "");//abc123--> 123
            if (reg.isEmpty()) {
                n[i] = 0;
            } else {
                n[i] = sum(Integer.parseInt(reg));
            }
        }
        System.out.println(Arrays.toString(n));



    }
    static int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n=n/10;
        }
        return s;
    }
    static int sums(int n){ int s=0;
        for (int i = 0; i <= n; i++) {
s+=i ;
        }
    return s;}
    static int sumOdd(int n){
        int s=0;
        for (int i=2;i<=n;i++){
            if(i%2==1){
                s+=i;
            }
        }
        return s;
    }
    static int sumEven(int n){
        int s=0;
        for (int i=2;i<=n;i++){
            if(i%2==0){
                s+=i;
            }
        }
        return s;
    }
    static int squre(int num){
        int s=0;
        for (int i = 0; i <=num; i++) {
            s+=i*i;
        }
        return s ;
    }
    static int vowel(String s){
        int sum=0;
        String vow="AEIOUaeiou";
        for (int i = 0; i < s.length(); i++) {
            if(s.contains(vow)){
                sum+=1;
            }
        }
        return sum;
    }
    static boolean p1(int n, int m){
        if(m%n==0){
            return true;}
        return false;
    }
    static boolean even(int num){
        if(num/2==0){
            return true;
        }
        return false;
    }
    static void punc(String s){
        String reg = "[a-z A-Z {1,}0-9 @a-z.a-z{0,3}]";
        String ans = s.replaceAll(reg,"");
        System.out.println(ans);
    }
    static int strtoint(String s){
        String reg= s.replaceAll("[^\\d]","");
        int regs =  Integer.parseInt(reg);
        int sc=0;
        int so=0;
        while(regs>0){
            sc+= regs%10;
            so/=10;
        }return so;
    }







}
