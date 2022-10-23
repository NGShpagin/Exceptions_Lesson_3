package Seminar.Ex_3;

public class Counter implements AutoCloseable {
    private int i = 0;

    protected Counter() {
        super();
    }

    protected void add() {
        this.i++;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Method closed");
    }
}
