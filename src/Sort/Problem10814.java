// https://www.acmicpc.net/problem/10814
// 나이순 정렬, Silver5
// 2023년 8월 7일
// 통과

package Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem10814{

    static class Member implements Comparable<Member> {
        int age;
        String name;

        public Member(int age, String name){
            this.age=age;
            this.name=name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age-o.age; // age기준 오름차순 정렬
        }

        public int getAge() {
            return age;
        }
        public String getName() {
            return name;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> members = new ArrayList<>();

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            members.add(new Member(num,str));
        }
        Collections.sort(members);

        for(Member member:members){
            bw.write(member.getAge()+" "+member.getName()+"\n");
        }
        bw.flush();
        bw.close();
    }
}