package digitalSignature;

import java.util.ArrayList;

public class ElGamalMessageWithSignature {
        public ArrayList<Integer> message = new ArrayList<>();
        public int digitalSignatureS = 0;
        public int digitalSignatureR = 0;

    public int getDigitalSignatureR() {
        return digitalSignatureR;
    }

    public void setDigitalSignatureR(int digitalSignatureR) {
        this.digitalSignatureR = digitalSignatureR;
    }

    public void setMessage(ArrayList<Integer> message) {
            this.message = message;
        }

        public void setDigitalSignatureS(int digitalSignatureS) {
            this.digitalSignatureS = digitalSignatureS;
        }

        public ArrayList<Integer> getMessage() {
            return message;
        }

        public int getDigitalSignatureS() {
            return digitalSignatureS;
        }
    }


