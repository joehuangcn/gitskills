package business.service;

public class UseFunctionService {

    Testfunction testfunction;

    public void setTestfunction(Testfunction testfunction){
        this.testfunction=testfunction;
    }

    public String Sayhi(String word){
        return testfunction.sayhello(word);
    }
}
