
import java.util.*;

class FibonaccieSeries{
    static void FibonaccieSeriesWithoutRecursion(int terms){
        int first = 0;
        int second = 1;
        System.out.print(first+" ");
        System.out.print(second+" ");
        for(int i=2;i<terms;i++){
            int next = first+second;
            System.err.print(next+" ");
            first= second;
            second=next;
        }
        System.out.println("");
    }
    static int FibonaccieSeriesWithRecursion(int i){
        if(i<=1){
            return i;
        }
        return FibonaccieSeriesWithRecursion(i-1)+FibonaccieSeriesWithRecursion(i-2);
    }
    public static void main(String[] args) {
        System.out.println("Enter no of terms in series : ");
        Scanner sc = new Scanner(System.in);
        int terms= sc.nextInt();
        System.out.println("Fibonacci without recusion");
        FibonaccieSeriesWithoutRecursion(terms);
        System.out.println("Fibonacci with recusion");
        for(int i=0;i<terms;i++){
            System.out.print(FibonaccieSeriesWithRecursion(i)+" ");
        }
    }
}