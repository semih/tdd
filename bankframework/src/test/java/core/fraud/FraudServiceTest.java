package core.fraud;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudServiceTest {

    @ParameterizedTest(name="{index} => {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("Should be true if it is even else is false")
    void validate(int customerNumber) {
        //SETUP
        FraudService service = new FraudService();

        //RUN
        boolean actual = service.Validate(customerNumber);

        //ASSERT
        assertEquals(customerNumber % 2 == 0, actual);

    }
}