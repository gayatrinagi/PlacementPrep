import java.util.*;


public class recursion{
    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printDecreasing(n-1);
    }
    public static void printIncreasing(int n){
        if(n==0){
            
            return;
        }
        printIncreasing(n-1);
        System.out.print(n+" ");
        
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    public static int fib(int n){// O(2^n) time complexity
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static boolean checkSorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        } 
        return arr[index]<=arr[index+1] && checkSorted(arr,index+1);
    }
    public static int firstOccurence(int[] arr,int index,int key){
        if(index==arr.length){
            return -1;
        }
        if(key==arr[index]){
            return index;
        }
        return firstOccurence(arr,index+1,key);
    }
    public static int lastOccurence(int[] arr,int index, int key){
        if(index==arr.length) return -1;
        int result=lastOccurence(arr,index+1,key);
        if(result!=-1) return result;
        if(arr[index]==key) return index;
        return -1;

    }
    public static void removeDuplicates(String str,StringBuilder result,int index,boolean[] check){//google microsoft
        if(index ==str.length()){
            System.out.print(result);
            return ;
        }
        if(check[str.charAt(index)-'a']==true){
            removeDuplicates(str,result,index+1,check);
        }else{
            result.append(str.charAt(index));
            check[str.charAt(index)-'a']=true;
            removeDuplicates(str,result,index+1,check);
        }

    }
    public static int power(int x,int n){
        if(n==0) return 1;
        if(n%2==0) return power(x,n/2) * power(x,n/2);//if power is even
        else return x*power(x,n/2) * power(x,n/2);//if power is odd
    
    }
    public static int tileways(int n){//n= length of floor
        if(n==0 ||n==1) return 1;
        return tileways(n-1)+tileways(n-2);
    }
    public static long countFriendsPairings(int n) {
        if(n==1 || n==2){
            return n;
        }
        return countFriendsPairings(n-1)+(n-1)*countFriendsPairings(n-2);//single ways+pair ways
    }
    public static void printBS(int n,int lastPlace,String  str){
        if(n==0) {
            System.out.println(str);
            return;
        }
        printBS(n-1,1,str+"1");//0 
        if(lastPlace==1){
            
            printBS(n-1,0,str+"0");
        }  
       

    }
    public static void findAll(int[] arr,int key,int index,List<Integer> result){//to find all occurences of a key
        if(index==arr.length){
            return;
        }
        if(arr[index]==key){
            result.add(index);
        }
        findAll(arr,key,index+1,result);
    }
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numToEng(int n){
        if(n==0){
            return;
        }
        numToEng(n/10);
        int rem=n%10;
        System.out.print(digits[rem]+ " ");
       
    }
    public static int lenstr(String str,int index){
        if(index==str.length()){
            return index;
        }
        return lenstr(str,index+1);

    } 
    
    public static int sameChar(String str,int start,int end){
        if(end==str.length()){
            return 0;
        }
        int count=0;
        if(str.charAt(start)==str.charAt(end)){
            count=1;
        }
        return count+sameChar(str,start,end+1);
    }
    public static void main(String[] args){
        printDecreasing(10);
        System.out.println();
        printIncreasing(10);   
        System.out.println();
        System.out.print( fact(5));
        System.out.println();
        System.out.print( sum(0));
        System.out.println();
        System.out.print( fib(5));
        System.out.println();
        int arr[]={2,4,6,2,7,2,8,9,2,8,2,10};
        System.out.print( checkSorted(arr,0));
        System.out.println();
        
        System.out.print( firstOccurence(arr,0,8));
        System.out.println();
        
        System.out.print( lastOccurence(arr,0,8));
        System.out.println();
        
        System.out.print( power(2,8));//O(logN)

        System.out.println();
        
        System.out.print( tileways(5));//O(logN)

         System.out.println();
        
        removeDuplicates("appnnacollege",new StringBuilder(),0,new boolean[26]);
        
        System.out.print(countFriendsPairings(5));
        System.out.println();
        printBS(3,1,"");
        System.out.println();
        List<Integer> result=new ArrayList<>();
        findAll(arr,2,0,result);
        System.out.print(result);
         System.out.println();
       
        numToEng(2019);
        System.out.println();
       System.out.print( lenstr("gayatri",0));

    }
}
