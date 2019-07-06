package core.fraud;

public class FraudService implements IFraudService {
    public boolean Validate(int customerNumber) {
        return customerNumber % 2 == 0;
    }
}
