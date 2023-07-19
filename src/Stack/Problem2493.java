    // https://www.acmicpc.net/problem/2493
    // 탑, Gold5
    // 2023년 7월 16일

    package Stack;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Stack;
    import java.util.StringTokenizer;

    public class Problem2493 {

        static class Top{
            int index;
            int height;

            Top(int index,int height){
                this.index=index;
                this.height=height;
            }

            public int getIndex() {
                return index;
            }

            public int getHeight() {
                return height;
            }
        }
        public static void main(String args[]) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N=Integer.parseInt(br.readLine());
            Stack<Top> stack = new Stack<>();
            st=new StringTokenizer(br.readLine());
            int result[] = new int[N];
            stack.push(new Top(0,Integer.parseInt(st.nextToken())));
            result[0]=0;
            for(int i=1;i<N;++i){
                Top temp=new Top(i,Integer.parseInt(st.nextToken()));
                while(!stack.isEmpty()){
                    if(stack.peek().getHeight()<temp.getHeight()){
                        stack.pop();
                    }
                    else{
                        result[temp.getIndex()]=stack.peek().getIndex()+1;
                        break;
                    }
                }
                stack.push(temp);
            }

            for(int i=0;i<N;++i){
                System.out.print(result[i]+" ");
            }
        }
    }
