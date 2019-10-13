package digitalSignature;

import java.util.ArrayList;

public class RSAMessageWithSignature {
    public ArrayList<Integer> message = new ArrayList<>();
    public int digitalSignature = 0;

    public void setMessage(ArrayList<Integer> message) {
        this.message = message;
    }

    public void setDigitalSignature(int digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public ArrayList<Integer> getMessage() {
        return message;
    }

    public int getDigitalSignature() {
        return digitalSignature;
    }
}
