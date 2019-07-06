package core.kmh;

public class KmhService implements IKmhService{
    public String getKMHMethod(int accountNumber) throws Exception {

        int type=accountNumber%3;

        if(type==0)
            throw new Exception("Account is Not OverDraft");

        return type%3==1?"CFN":"GUNICI";

    }
}
