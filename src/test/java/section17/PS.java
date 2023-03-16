package section17;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

    public void doThis(){
        System.out.println("do this");
    }

    @BeforeMethod
    public void beforeRun(){
        System.out.println("run first");
    }

    @AfterMethod
    public void AfterRun(){
        System.out.println("run after");
    }

}
