package elMoney;

import utils.NumberOperating;

public class Bank {
    private final int P = 17;
    private final int Q = 7;
    private final int c = 77;
    private int N;
    private int d;
    private int [] bills = {10, 9, 2, 3, 1, 10, 1, 7, 8, 3};
    private int signature;

    public Bank() {
        this.N = P * Q;
        this.d = NumberOperating.degreeInModule(c, -1, (P - 1) * (Q - 1));
    }

    public int sendAnswerCustomer(int n) {
        signature = NumberOperating.degreeInModule(n, c, N);
        return signature;
    }

    public int getN() {
        return N;
    }

    public int getD() {
        return d;
    }

    public boolean checkBill(Bill bill){
        if(bill.getS() == signature && bills[bill.getN()] != 0){
            bills[bill.getN()] = 0;
            return true;
        }
        return false;
    }
}
