package 삼성B형.리스트복사;

import java.util.HashMap;
import java.util.Map;

public class UserSolution {

    class Pair{
        int index;
        int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    int initNumber;
    int[][] initList;

    int addressNumber;
    Map<String,Integer> address;

    int changeNumber;
    int[] preChange;
    Pair[] currentChange;
    int[] lastChange;

    void init() {
        initNumber = 0;
        initList = new int[11][200001];
        addressNumber = 0;
        address=new HashMap<String, Integer>();
        changeNumber=0;
        preChange=new int[110001];
        currentChange=new Pair[110001];
        lastChange=new int[6001];
    }

    String getName(char mName[]) {
        String name="";
        for(int i=0;mName[i]!=0;++i) {
            name+=mName[i];
        }
        return name;
    }

    void makeList(char mName[], int mLength, int mListValue[]) {
        System.arraycopy(mListValue, 0, initList[initNumber], 0, mLength);
        ++initNumber;

        address.put(getName(mName),addressNumber);
        ++addressNumber;

        preChange[changeNumber]=-1;
        currentChange[changeNumber]=new Pair(-1,initNumber-1);
        lastChange[address.get(getName(mName))]=changeNumber;
        ++changeNumber;
    }

    void copyList(char mDest[], char mSrc[], boolean mCopy) {
        if(mCopy) {
            address.put(getName(mDest),addressNumber);
            ++addressNumber;

            preChange[changeNumber]=lastChange[address.get(getName(mSrc))];
            currentChange[changeNumber]=new Pair(-1,-1);
            lastChange[address.get(getName(mDest))]=changeNumber;
            ++changeNumber;
        }
        else {
            address.put(getName(mDest),address.get(getName(mSrc)));
        }
    }

    void updateElement(char mName[], int mIndex, int mValue) {
        preChange[changeNumber]=lastChange[address.get(getName(mName))];
        currentChange[changeNumber]=new Pair(mIndex,mValue);
        lastChange[address.get(getName(mName))]=changeNumber;
        ++changeNumber;
    }

    int element(char mName[], int mIndex) {
        int c = lastChange[address.get(getName(mName))];
        while(true) {
            if(preChange[c]==-1) {
                return initList[currentChange[c].value][mIndex];
            }
            if(currentChange[c].index==mIndex) {
                return currentChange[c].value;
            }
            c = preChange[c];
        }
    }
}
