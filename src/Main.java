import digitalSignature.ElGamalSignature;
import digitalSignature.RSASignature;
import elMoney.Bank;
import elMoney.Bill;
import elMoney.Customer;
import hackSystem.BabyStepGiantStepSystem;
import utils.NumberOperating;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer = new Customer();
        int d = bank.getD();
        int n = bank.getN();
        customer.setNumberOfBill();
        int nt = customer.sendRequestOfBill(n, d);
        int s = bank.sendAnswerCustomer(nt);
        Bill bill = customer.getBill(s, n);
        System.out.println(bank.checkBill(bill));
    }
}
