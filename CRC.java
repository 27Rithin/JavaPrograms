import java.io.*;

class CRC {
    int[] data = new int[30], divisor = new int[10], rem = new int[30], quo = new int[30], tx = new int[30];
    int dLen, pLen, tLen;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void input() throws IOException {
        System.out.println("Enter polynomial length");
        pLen = Integer.parseInt(br.readLine());

        System.out.println("Enter polynomial coefficients");
        for (int i = 0; i < pLen; i++) divisor[i] = Integer.parseInt(br.readLine());

        System.out.println("Enter data length");
        dLen = Integer.parseInt(br.readLine());

        System.out.println("Enter data bits");
        for (int i = 0; i < dLen; i++) data[i] = Integer.parseInt(br.readLine());

        tLen = dLen + pLen - 1;
        for (int i = dLen; i < tLen; i++) data[i] = 0;

        System.out.print("Given polynomial is:\n");
        for (int i = 0; i < pLen; i++) System.out.print(divisor[i] + " ");
        System.out.println("\nGiven data is:");
        for (int i = 0; i < dLen; i++) System.out.print(data[i] + " ");
        System.out.println();
    }

    void sender() {
        System.arraycopy(data, 0, rem, 0, tLen);
        for (int i = 0; i < dLen; i++) {
            quo[i] = rem[i];
            if (rem[i] == 1)
                for (int j = 0; j < pLen; j++) rem[i + j] ^= divisor[j];
        }

        System.out.println("AT sender side\nQuotient is:");
        for (int i = 0; i < dLen; i++) System.out.print(quo[i] + " ");

        System.out.println("\nRemainder is:");
        for (int i = 0; i < pLen - 1; i++) System.out.print(rem[dLen + i] + " ");

        for (int i = 0; i < dLen; i++) tx[i] = data[i];
        for (int i = 0; i < pLen - 1; i++) tx[dLen + i] = rem[dLen + i];

        System.out.println("\nTransmitted frame is:");
        for (int i = 0; i < tLen; i++) System.out.print(tx[i] + " ");
        System.out.println();
    }

    void receiver() {
        int[] rcv = new int[30], quo2 = new int[30];
        System.arraycopy(tx, 0, rcv, 0, tLen);

        for (int i = 0; i < dLen; i++) {
            quo2[i] = rcv[i];
            if (rcv[i] == 1)
                for (int j = 0; j < pLen; j++) rcv[i + j] ^= divisor[j];
        }

        System.out.println("AT RECEIVER SIDE\nReceived Quotient is:");
        for (int i = 0; i < dLen; i++) System.out.print(quo2[i] + " ");

        System.out.println("\nReceived Remainder is:");
        for (int i = 0; i < pLen - 1; i++) System.out.print(rcv[dLen + i] + " ");

        System.out.println("\nReceived frame is:");
        for (int i = 0; i < dLen; i++) System.out.print(tx[i] + " ");
        System.out.println();
    }
}

public class CRC {
    public static void main(String[] args) throws IOException {
        CRC c = new CRC();
        c.input();
        c.sender();
        c.receiver();
    }
}
