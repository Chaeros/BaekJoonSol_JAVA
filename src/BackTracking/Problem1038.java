// https://www.acmicpc.net/problem/1038
// 감소하는 수, Gold5
//2023년 7월 25일
// 합

package BackTracking;

import java.util.*;

public class Problem1038 {

    static List<Long> list = new ArrayList<>();
    static ArrayList<Long> q = new ArrayList<>();

    static void func(int N){
        Queue<Long> tempQ=new LinkedList<>();
        for(long i=0;i<10;++i){
            tempQ.offer(i);
            q.add(i);
        }

        while(!tempQ.isEmpty()){
            long a=tempQ.poll();
            long x=a%10;
            for(int i=0;i<x;++i){
                long num=a*10+i;
                tempQ.offer(num);
                q.add(num);
            }
        }

        if(N>=q.size()) System.out.println(-1);
        else System.out.println(q.get(N));
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        func(N);
    }
}
