package section17;

import org.testng.annotations.Test;

public class PS1 extends PS{

    @Test
    public void testRun(){
        doThis();

        PS2 ps2 = new PS2(6);
        System.out.println( ps2.increment());
        System.out.println(ps2.multiplyTwo());



    }


}
