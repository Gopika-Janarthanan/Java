package Java_DSA_Course;

public class Array {
    public static void main(String[] args){
        avgTemp(new int []{1,3,4,6,8});
        System.out.println(missingNum(new int[]{1,2,3,5}));
    }
    static void avgTemp( int []arg ){
        int length = arg.length;
        int s=0;
        for (int i : arg){
            s+=i;

        }
        System.out.println("sum : "+s);
        System.out.println("length : "+length);
        System.out.println("avg : "+s/length);

    }

static int missingNum(int []arr){
        int s=0;
       int c=0;
        int a;
        int i;
    for (i= 1; i < arr.length; i++) {
        s+= arr[i];
        c+=i;

    }
    a= s-c;
    return a;
}
}

