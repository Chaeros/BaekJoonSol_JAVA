package kakaointernship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static public int diceSize;
    static public int selectedDice[];
    static public int selectedDiceNumber[];
    static public long maxWinCount=0;
    static public int resultNumber[];

    static public int[][] dices;

    public static void main(String args[]){
        int dice[][] = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        int dice2[][] = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int dice3[][] ={{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5},{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}
        ,{1, 1, 82, 80, 82, 80},{70, 73, 1, 13, 70, 70}};
        int result[] =solution(dice3);
        for(int i=0;i<diceSize;++i){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int diceNumberSum[];
    static public int unselectedDice[];
    static public int unselectedDiceNumber[];

    public static boolean isInSelectedDice(int target){
        int start=0;
        int end=diceSize-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(selectedDice[mid]==target){
                return true;
            }
            else if(selectedDice[mid]<target){
                start=mid+1;
            }
            else if(selectedDice[mid]>target){
                end=mid-1;
            }
        }
        return false;
    }

    public static void getUnselectedDice(){
        boolean isInSelecetedDice;
        int count=0;
        for(int i=0;i<diceSize*2;++i){
            isInSelecetedDice=isInSelectedDice(i);
            if(!isInSelecetedDice){
                unselectedDice[count]=i;
                count++;
                if(count==diceSize){
                    break;
                }
            }
        }
    }

    public static void dfs3(int sum, int depth){

        if(depth==diceSize){
            int diceSum=0;
            getUnselectedDice();
            for(int i=0;i<diceSize;++i){
                diceSum+=dices[unselectedDice[i]][unselectedDiceNumber[i]];
            }
            if(diceSum<sum){
                tempSum++;
            }
            return;
        }
        for(int i=0;i<6;++i){
            unselectedDiceNumber[depth]=i;
            dfs3(sum,depth+1);
        }
    }

    static public long tempSum;
    public static void dfs2(int depth){
        if(depth==diceSize){
            int diceSum=0;
            for(int i=0;i<diceSize;++i){
                diceSum+=dices[selectedDice[i]][selectedDiceNumber[i]];
            }
            dfs3(diceSum,0);
            return;
        }
        for(int i=0;i<6;++i){
            selectedDiceNumber[depth]=i;
            dfs2(depth+1);
        }
    }

    public static void dfs1(int index, int depth){
        if(depth==diceSize){
            tempSum=0;
            dfs2(0);
            if(maxWinCount<tempSum){
                maxWinCount=tempSum;
                for(int i=0;i<diceSize;++i){
                    resultNumber[i]=selectedDice[i]+1;
                }
            }
            return;
        }
        for(int i=index;i<diceSize*2;++i){
            selectedDice[depth]=i;
            dfs1(i+1,depth+1);
        }
    }

    static public void print(int str[]){
        for(int i=0;i<str.length;++i){
            System.out.print(str[i]+" ");
        }
        System.out.println();
    }
    public static int[] solution(int[][] dice) {
        int[] answer = {};
        selectedDice = new int[dice.length/2];
        selectedDiceNumber = new int[dice.length/2];
        resultNumber = new int[dice.length/2];
        unselectedDice = new int[dice.length/2];
        unselectedDiceNumber = new int[dice.length/2];
        diceSize=dice.length/2;
        dices=dice;

        dfs1(0,0);
        answer=resultNumber;
        return answer;
    }
}