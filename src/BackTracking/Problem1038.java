// https://www.acmicpc.net/problem/1038
// 감소하는 수, Gold5
//2023년 7월 25일
// 불합

package BackTracking;

import java.util.Scanner;

public class Problem1038 {

    static int count=0;

    static boolean promising(int num,int size, int[] array){
        for(int i=0;i<=size;++i)
        {
            array[i]=(num/(int)(Math.pow(10,size-i))%10);
            if(i>0 && array[i]>=array[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if(N==0){
            System.out.println(0);
            return;
        }
        int array[] = new int[N+1];

        int i=1;
        while(count<N){
            int k=0;
            int temp=i;
            while(temp>=10){
                temp/=10;
                ++k;
                if(k>10){
                    System.out.println(-1);
                    return;
                }
            }
            if(promising(i,k,array)){
                System.out.print(i+" ");
                count++;
            }
            ++i;
        }
        System.out.println();
        System.out.println(i-1);
    }
}
