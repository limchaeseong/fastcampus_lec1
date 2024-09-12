package org.example.counter;

public class RaceConditionDemo {
    /**
     *  RaceCondition : 여러 쓰레드가 하나의 자원을 차지하기 위해 경쟁하는 상태
     *  => 한계 : 쓰레드가 safe 하지 않음.(쓰레드가 원하는 대로 작동하지 않을 수 있음)
     *  => 해결방법 : 쓰레드 동기화(synchronized) = 현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막음
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter,"Thread-1");
        Thread t2 = new Thread(counter,"Thread-2");
        Thread t3 = new Thread(counter,"Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
