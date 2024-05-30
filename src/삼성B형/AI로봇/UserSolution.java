package 삼성B형.AI로봇;

class Robot{
    int rID;
    int iq;
    int wID;
    long beginTime;
    boolean isBroken;
    int minIndex, maxIndex;

    Robot() {
        rID = 0;
        iq = 0;
        wID = 0;
        beginTime = 0;
        isBroken = false;
    }
}

class Job{
    Robot[] robots;
    int count;

    Job() {
        count = 0;
        robots = new Robot[0];
    }
}

class Que<C extends RobotComparator>{

    private static final int MAX = 100010;
    int size;
    C com;
    Robot[] robots = new Robot[MAX];

    void init(int size, C com, Robot[] robots) {
        this.size = size;
        this.com = com;
//		this.robots = robots;
        for( int n = 0 ; n < size ; ++n ) {
            this.robots[n] = robots[n+1];
            this.com.set(this.robots[n], n);
        }
    }

    void push(Robot r) {
        robots[size] = r;
        com.set(robots[size], size);
        int current = size++;
        while( current > 0 ) {
            int parent = (current-1)/2;
            if ( com.compare(robots[current], robots[parent]) <= 0 ) {
                break;
            }
            swap2(robots,current,parent);
//			swap(robots[current],robots[parent]);
            com.set(robots[current], current);
            com.set(robots[parent], parent);
            current = parent;
        }
    }

    Robot pop() {
        if ( size == 0 ) {
            return null;
        }

        Robot result = robots[0];
        robots[0] = robots[--size];
        com.set(robots[0], 0);
        int current = 0;
        while ( current*2+1 < size ) {
            int child = (current*2+2 < size)
                    && (com.compare(robots[current*2+1], robots[current*2+2]) < 0)
                    ? current*2+2 : current*2+1;
            if ( com.compare(robots[child], robots[current]) <= 0 ) break;
            swap2(robots,current,child);
//			swap(robots[child],robots[current]);
            com.set(robots[child], child);
            com.set(robots[current], current);
            current = child;
        }
        return result;
    }

    void remove(int index) {
        if ( index >= size ) {
            return;
        }

        robots[index] = robots[--size];
        com.set(robots[index], index); // robots[]안의 수를 ,size/index 둘 다 해도됨. 왜냐하면 어차피 같은 로봇 객체를 나타내므로
        int current = index;

        while ( current > 0 ) {
            int parent = (current-1)/2;
            if ( com.compare(robots[current], robots[parent]) <= 0 ) {
                break;
            }
            swap2(robots,current,parent);
//			swap(robots[current], robots[parent]);
            com.set(robots[current], current);
            com.set(robots[parent], parent);
            current = parent;
        }

        while ( current*2+1 < size ) {
            int child = (current*2+2 < size) &&
                    (com.compare(robots[current*2+1], robots[current*2+2]) < 0)
                    ? current*2+2 : current*2+1;
            if ( com.compare(robots[child], robots[current]) <= 0 ) {
                break;
            }
            swap2(robots,current,child);
//			swap(robots[child],robots[current]);
            com.set(robots[child], child);
            com.set(robots[current], current);
            current = child;
        }
    }

    void swap2(Robot[] arr, int i, int j) {
        Robot temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void swap(Robot r1, Robot r2) {
        Robot temp = r1;
        r1 = r2;
        r2 = temp;
    }

}

class MinRobotComparator implements RobotComparator{
    // r1이 하위 노드, r2가 상위 노드
    // r1과 r2의 아이큐가 같다면, ID 번호가 더 작은 로봇이 우선시됨.
    // MinHeap이므로 r2.rID - r2.rID =< 0 이라면, r2(상위 노드)가 r1(하위 노드)보다 ID 번호가 작다는 뜻으로,
    // 변화가 없어도 됨을 의미한다.(rID는 중복되지 않음으로 같지않고 작음)
    // 반면, r1.iq != r2.iq 라면, r2.iq - r1.iq =< 0 의 뜻은 상위 노드가 하위 노드의 iq보다 작거나 같다는 뜻으로 그대로
    @Override
    public int compare(Robot r1, Robot r2) {
        return (r1.iq != r2.iq) ? (r2.iq - r1.iq) : (r2.rID-r1.rID);
    }

    @Override
    public void set(Robot r, int index) {
        r.minIndex = index;
    }
}

class MaxRobotComparator implements RobotComparator{
    @Override
    public int compare(Robot r1, Robot r2) {
        return (r1.iq != r2.iq) ? (r1.iq - r2.iq) : (r2.rID - r1.rID);
    }

    @Override
    public void set(Robot r, int index) {
        r.maxIndex = index;
    }
}


interface RobotComparator {
    int compare(Robot r1, Robot r2);
    void set(Robot r, int index);
}

public class UserSolution {
    private final int MAXN = 50010;
    private final int MAXJ = 50010;
    Robot[] robots;
    Job[] jobs;
    Que<MaxRobotComparator> maxQue = new Que<>();
    Que<MinRobotComparator> minQue = new Que<>();

    void init(int N) {
        robots = new Robot[MAXN+1];
        jobs = new Job[MAXJ+1];

        for ( int i = 1 ; i <= N ; ++i ) {
            robots[i] = new Robot();
            robots[i].rID = i;
            robots[i].iq = 0;
            robots[i].beginTime = 0;
            robots[i].wID = 0;
            robots[i].isBroken = false;
        }

        for ( int i = 0 ; i <= MAXJ ; ++i ) {
            jobs[i] = new Job();
        }

        maxQue.init(N, new MaxRobotComparator(), robots);
        minQue.init(N, new MinRobotComparator(), robots);
    }

    int callJob(int cTime, int wID, int mNum, int mOpt) {
        jobs[wID].robots = new Robot[mNum];

        int result = 0;
        if ( mOpt == 0 ) { // 높은 지능 우선 방식
            int count = 0;
            while ( count < mNum ) {
                if ( maxQue.size == 0 ) break;
                Robot robot = maxQue.pop();
                robot.wID = wID;
                robot.beginTime = cTime;
                jobs[wID].robots[count++] = robot;
                result += robot.rID;
                minQue.remove(robot.minIndex);
            }
            jobs[wID].count = count;
        }
        else if ( mOpt == 1 ) { // 낮은 지능 우선 방식
            int count = 0;
            while( count < mNum ) {
                if ( minQue.size == 0 ) break;
                Robot robot = minQue.pop();
                robot.wID = wID;
                robot.beginTime = cTime;
                jobs[wID].robots[count++] = robot;
                result += robot.rID;

                maxQue.remove(robot.maxIndex);
            }
            jobs[wID].count = count;
        }
        return result;
    }

    void returnJob(int cTime, int wID) {
        int n = jobs[wID].count;
        for ( int i = 0; i < n ; ++i ) {
            Robot robot = jobs[wID].robots[i];
            // 고장난 상태에서는 Que로 복귀해서는 안 되고,
            // 또한 작업 중 고장났다가 수리 후, 다른 작업에 투입되어 있는 로봇이 있을 수 있으므로
            // 2가지 경우에는 예외처리 해줘야 한다.
            if ( robot.isBroken || robot.wID != wID ) {
                continue;
            }
            robot.iq -= cTime - robot.beginTime;
            robot.wID = 0;
            maxQue.push(robot);
            minQue.push(robot);
        }
    }

    void broken(int cTime, int rID) {
        if ( robots[rID].wID != 0) {
            robots[rID].isBroken = true;
            robots[rID].wID = 0;
        }
    }

    void repair(int cTime, int rID) {
        if ( robots[rID].isBroken ) {
            robots[rID].iq = -cTime;
            robots[rID].isBroken = false;

            maxQue.push(robots[rID]);
            minQue.push(robots[rID]);
        }
    }

    int check(int cTime, int rID) {
        if ( robots[rID].isBroken ) {
            return 0;
        }
        else if ( robots[rID].wID != 0 ) {
            return -robots[rID].wID;
        }
        return cTime + robots[rID].iq;
    }
}
