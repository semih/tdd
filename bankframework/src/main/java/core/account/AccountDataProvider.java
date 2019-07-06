package core.account;

import java.util.HashMap;

public class AccountDataProvider implements IDataProvider<AccountInfo> {

    public AccountInfo get(int accountNumber) {
        HashMap<Integer, AccountInfo> accountInfoList = new HashMap<Integer, AccountInfo>();

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNumber(1);
        accountInfo.setAccountType(AccountType.Vadeli);
        accountInfo.setBalance(1000);
        accountInfo.setUsableBalance(680);
        accountInfoList.put(accountInfo.getAccountNumber(), accountInfo);

        accountInfo.setAccountNumber(3);
        accountInfo.setAccountType(AccountType.Vadesiz);
        accountInfo.setBalance(2000);
        accountInfo.setUsableBalance(1450);
        accountInfoList.put(accountInfo.getAccountNumber(), accountInfo);

        return (AccountInfo) accountInfoList.get(accountNumber);
    }
}
