package 삼성B형.병사관리;

import java.util.Arrays;

public class UserSolution {

    class Soldier{
        int mId;
        int v;
        Soldier next;
        public Soldier() {
        }
        public Soldier(int mId, Soldier next) {
            this.mId = mId;
            this.next = next;
        }
    }

    class Team{
        Soldier head[] = new Soldier[6];
        Soldier tail[] = new Soldier[6];
    }

    Soldier soldiers[];
    Team teams[];
    int version[];
    int teamNumber[];
    int size;


    void init() {
        soldiers = new Soldier[200101];
        teams = new Team[6];
        version = new int[100100];
        teamNumber = new int[100100];
        size=0;
        for ( int i = 0 ; i <= 200100 ; ++i ) {
            soldiers[i] = new Soldier();
        }
        for ( int i = 0 ; i <= 5 ; ++i ) {
            teams[i] = new Team();
            for ( int j=0;j<=5;++j) {
                teams[i].head[j]=teams[i].tail[j]=getSoldier(0,null);
            }
        }
        for(int i=0;i<=100000;++i) {
            version[i]=0;
            teamNumber[i]=0;
        }
    }

    Soldier getSoldier(int mID,Soldier next) {
        Soldier soldier = soldiers[++size];
        soldier.mId=mID;
        soldier.v=++version[mID];
        soldier.next=next;
        return soldier;
    }

    void hire(int mID, int mTeam, int mScore) {
        Soldier soldier = getSoldier(mID,null);
        teams[mTeam].tail[mScore].next=soldier;
        teams[mTeam].tail[mScore]=soldier;
        teamNumber[mID]=mTeam;
    }

    void fire(int mID) {
        version[mID]=-1;
    }

    void updateSoldier(int mID, int mScore) {
        hire(mID,teamNumber[mID],mScore);
    }

    void updateTeam(int mTeam, int mChangeScore) {
        if(mChangeScore>0) {
            for(int i=5;i>=1;--i) {
                int k=(i+mChangeScore>5)?5:i+mChangeScore;
                if(i==k) continue;
                if(teams[mTeam].head[i].next==null) continue;
                teams[mTeam].tail[k].next=teams[mTeam].head[i].next;
                teams[mTeam].tail[k]=teams[mTeam].tail[i];
                teams[mTeam].head[i].next=null;
                teams[mTeam].tail[i]=teams[mTeam].head[i];
            }
        }
        if(mChangeScore<0) {
            for(int i=1;i<=5;++i) {
                int k=(i+mChangeScore<1)?1:i+mChangeScore;
                if(i==k) continue;
                if(teams[mTeam].head[i].next==null) continue;
                teams[mTeam].tail[k].next=teams[mTeam].head[i].next;
                teams[mTeam].tail[k]=teams[mTeam].tail[i];
                teams[mTeam].head[i].next=null;
                teams[mTeam].tail[i]=teams[mTeam].head[i];
            }
        }
    }

    int bestSoldier(int mTeam) {
        int resultNumber=0;
        for(int i=5;i>=1;--i) {
            Soldier soldier = teams[mTeam].head[i].next;
            while(soldier!=null) {
                if(soldier.v==version[soldier.mId] && resultNumber<soldier.mId) {
                    resultNumber=soldier.mId;
                }
                soldier=soldier.next;
            }
            if(resultNumber!=0){
                return resultNumber;
            }
        }
        return resultNumber;
    }
}

