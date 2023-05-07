package srp;

import java.awt.print.Book;

/**
 * @author : Lex Yu
 * @date : 07/05/2023
 */
public class BankService {

    /*
     1. Withdraw
     2. Deposit
     3. Print Pass Book
     4. Get Loan Info
     5. Send OTP
     */

    // TODO: Following SRP
    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

    /*
    public void printPassbook() {
        //update transaction info in passbook
    }
     */

    /*
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }
     */

    /*
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
     */
}
