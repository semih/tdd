package core.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountServiceTest {

    private AccountService accountService;
    private IDataProvider<AccountInfo> mockedAccountDataProvider;

    @BeforeAll
    public void BeforeAll() {

        this.mockedAccountDataProvider = Mockito.mock(AccountDataProvider.class);
        this.accountService = new AccountService(mockedAccountDataProvider);
    }

    @ParameterizedTest(name = "Accounts")
    @MethodSource("accountProvider")
    public void IsOverdraftMustBeFalseIfAccountTypeNotVadeli(AccountInfo obj) {
        //SETUP
        Mockito.when(mockedAccountDataProvider.get(1)).thenReturn(obj);

        AccountInfo actual = null;

        //ACTION
        try {
            actual = accountService.GetAccountInfo(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (obj.getAccountType() == AccountType.Vadeli) {
            assertEquals(false, actual.isOverDraft());
        }
    }

    @Test
    public void UsableBalanceMustBeGreaterThanOrEqualZero() {
        //SETUP
        AccountInfo ai = new AccountInfo();
        ai.setAccountType(AccountType.Vadeli);
        ai.setBalance(100);
        ai.setUsableBalance(-1);
        Mockito.when(mockedAccountDataProvider.get(1)).thenReturn(ai);

        //ACTION
        assertThrows(Exception.class, () -> {
            AccountInfo actual = accountService.GetAccountInfo(1);
        });
    }

    private static Stream<AccountInfo> accountProvider() {
        AccountInfo ai = new AccountInfo();
        ai.setAccountType(AccountType.Vadeli);
        ai.setBalance(100);
        ai.setUsableBalance(2000);

        AccountInfo ai2 = new AccountInfo();
        ai.setAccountType(AccountType.Vadesiz);
        ai.setBalance(100);
        ai.setUsableBalance(2000);

        AccountInfo ai3 = new AccountInfo();
        ai.setAccountType(AccountType.Vadeli);
        ai.setBalance(100);
        ai.setUsableBalance(0);
        return Stream.of(ai, ai2, ai3);
    }

}
