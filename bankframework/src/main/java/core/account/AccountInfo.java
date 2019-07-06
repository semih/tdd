package core.account;

import java.math.BigDecimal;

public class AccountInfo {

    private int accountNumber;
    private double balance;
    private double usableBalance;
    private boolean isOverDraft;
    private AccountType accountType;

    public AccountInfo() {}

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getUsableBalance() {
        return usableBalance;
    }

    public void setUsableBalance(double usableBalance) {
        this.usableBalance = usableBalance;
    }

    public boolean isOverDraft() {
        return isOverDraft;
    }

    public void setOverDraft(boolean overDraft) {
        isOverDraft = overDraft;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
