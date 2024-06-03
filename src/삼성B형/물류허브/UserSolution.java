package 삼성B형.물류허브;

import java.util.*;

public class UserSolution {

    class Node{
        int index;
        int distance;
        public Node(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
    }

    List<Node> list[], reverseList[];
    Map<Integer,Integer> city;
    int size;

    int init(int N, int sCity[], int eCity[], int mCost[]){
        city = new TreeMap<>();
        int index=0;
        for ( int i = 0 ; i < N ; ++i ){
            if(!city.containsKey(sCity[i])) city.put(sCity[i],index++);
            if(!city.containsKey(eCity[i])) city.put(eCity[i],index++);
        }
        size = city.size();

        list = new ArrayList[size];
        reverseList = new ArrayList[size];
        for ( int i = 0 ; i < size; ++i ){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        for ( int i = 0 ; i < N ; ++i ){
            list[city.get(sCity[i])].add(new Node(city.get(eCity[i]),mCost[i]));
            reverseList[city.get(eCity[i])].add(new Node(city.get(sCity[i]),mCost[i]));
        }
        return size;
    }

    void add(int sCity, int eCity, int mCost){
        list[city.get(sCity)].add(new Node(city.get(eCity),mCost));
        reverseList[city.get(eCity)].add(new Node(city.get(sCity),mCost));
    }

    int cost(int mHub){
        // mHub에서 시작하여 다른 정점까지의 최단거리를 담은 정방향 그래프
        int[] distance = dikjstra(list,mHub);
        // 다른 정점들로부터 mHub까지의 최단거리를 담은 역방향 그래프
        int[] reverseDistance = dikjstra(reverseList,mHub);

        int sum = 0;
        for ( int i = 0 ; i < size ; ++i ){
            sum += distance[i];
            sum += reverseDistance[i];
        }
        return sum;
    }

    int[] dikjstra(List<Node> roads[], int start){
        PriorityQueue<Node> pQ = new PriorityQueue<>((o1,o2)->o1.distance-o2.distance);
        pQ.offer(new Node(city.get(start),0));

        int[] distance = new int[size];
        for ( int i = 0 ; i < size ; ++i ){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[city.get(start)] = 0;
        boolean[] visited = new boolean[size];

        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            if (visited[now.index]){
                continue;
            }
            visited[now.index] = true;
            for(int i = 0 ; i < roads[now.index].size() ; ++i){
                Node nextNode =roads[now.index].get(i);
                if(distance[nextNode.index] > distance[now.index]+nextNode.distance){
                    distance[nextNode.index] = distance[now.index]+nextNode.distance;
                    pQ.offer(new Node(nextNode.index,distance[nextNode.index]));
                }
            }
        }
        return distance;
    }
}