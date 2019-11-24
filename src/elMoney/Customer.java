package elMoney;

import utils.NumberOperating;

public class Customer {
    private int r;
    private int n;

    public void setNumberOfBill() {
        this.n = (int) ((Math.random() * 1e2) % 10);
    }

    public int sendRequestOfBill(int N, int d) {
        r = NumberOperating.findRandMutuallyPrime(N);
        return (n * NumberOperating.degreeInModule(r, d, N)) % N;
    }

    public Bill getBill(int s, int N) {
        int id = (s * NumberOperating.degreeInModule(r, -1, N)) % N;
        return new Bill(n, s);
    }
}
