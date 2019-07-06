package core.account;

public class AccountService implements IAccountService {

    IDataProvider<AccountInfo> dataProvider;

    public AccountService(IDataProvider<AccountInfo> dataProvider) {
        dataProvider = dataProvider;
    }

    public AccountInfo GetAccountInfo(int accountNumber) throws Exception {
        AccountInfo accountInfo = (AccountInfo) dataProvider.get(accountNumber);
        if(accountInfo.getUsableBalance() < 0) {
            throw new Exception("Usable balance must not be smaller than 0");
        }

        AccountType accountType = accountInfo.getAccountType();
        if(accountType == AccountType.Vadeli) {
            accountInfo.setOverDraft(false);
        }
        
        return accountInfo;
    }
}
