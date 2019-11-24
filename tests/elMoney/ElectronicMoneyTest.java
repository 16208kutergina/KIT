package elMoney;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectronicMoneyTest {

    @Test
    void checkElMoney() {
        Bank bank = new Bank();
        Customer customer = new Customer();
        int d = bank.getD();
        int n = bank.getN();
        customer.setNumberOfBill();
        int nt = customer.sendRequestOfBill(n, d);
        int s = bank.sendAnswerCustomer(nt);
        Bill bill = customer.getBill(s, n);
        assertTrue(bank.checkBill(bill));
    }
}