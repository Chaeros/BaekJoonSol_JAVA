package kakaointernship;

class Solution1 {

    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        System.out.println(solution(friends,gifts));
        printGiftTable();
        printGiftToReceive();
        printResultTable();
    }

    public static void printGiftTable(){
        System.out.println("===========giftTable============");
        for(int i=0;i<friendsCount;++i){
            for(int j=0;j<friendsCount;++j){
                System.out.print(giftTable[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printGiftToReceive(){
        System.out.println("===========giftToReceive============");
        for (int x:giftToReceive){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void printResultTable(){
        System.out.println("===========resultTable============");
        for(int i=0;i<friendsCount;++i){
            for(int j=0;j<3;++j){
                System.out.print(resultTable[i][j]+" ");
            }
            System.out.println();
        }
    }

    static public int giftTable[][];
    static public int resultTable[][];
    static public int friendsCount;
    static public int giftToReceive[];

    public static int getIndex(String[] friends, String name){
        for(int i=0;i<friends.length;++i){
            if(friends[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void calculateResultTable(){
        for(int i=0;i<friendsCount;++i){
            for(int j=0;j<friendsCount;++j){
                resultTable[i][0]+=giftTable[i][j]; // 준 선물
                resultTable[i][1]+=giftTable[j][i]; // 받은 선물
            }
            resultTable[i][2]=resultTable[i][0]-resultTable[i][1]; // 선물 지수
        }
    }

    public static void calculateGiftToReceive(){
        for(int i=0;i<friendsCount;++i){
            for(int j=i;j<friendsCount;++j){
                if(giftTable[i][j]>giftTable[j][i]){ // j가 받은게 더 큼
                    giftToReceive[i]++;
                    System.out.println(i+"->"+j);
                }
                else if(giftTable[i][j]<giftTable[j][i]){ // i가 받은게 더 큼
                    giftToReceive[j]++;
                    System.out.println(i+"->"+j);
                }
                else if(giftTable[i][j]==giftTable[j][i]){
                    calculateIfEqualGiftScore(i,j);
                }
            }
        }
    }

    public static void calculateIfEqualGiftScore(int x,int y){
        if(resultTable[x][2]>resultTable[y][2]){
            giftToReceive[x]++;
            System.out.println("equal"+y+"->"+x);
        }
        else if(resultTable[x][2]<resultTable[y][2]){
            giftToReceive[y]++;
            System.out.println("equal"+x+"->"+y);
        }
    }

    public static int getMaxReceiceGiftCount(){
        int answer=0;
        for(int x:giftToReceive){
            if(answer<x) answer =x;
        }
        return answer;
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        giftTable = new int[friends.length][friends.length];
        resultTable = new int[friends.length][3];
        friendsCount=friends.length;
        giftToReceive = new int[friends.length];

        for(String str:gifts){
            String result[]=str.split(" ");
            int giver=getIndex(friends,result[0]);
            int reciver=getIndex(friends,result[1]);
            giftTable[giver][reciver]++;
        }

        calculateResultTable();
        calculateGiftToReceive();
        answer = getMaxReceiceGiftCount();

        return answer;
    }
}