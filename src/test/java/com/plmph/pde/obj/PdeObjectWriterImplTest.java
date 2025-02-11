package com.plmph.pde.obj;

import org.junit.jupiter.api.Test;

public class PdeObjectWriterImplTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        PdeObjectWriterImpl pdeObjectWriter = new PdeObjectWriterImpl(Pojo1.class);
        pdeObjectWriter.addFieldWriter("isValid");
        pdeObjectWriter.addFieldWriter("integerFieldWithLongName");
        pdeObjectWriter.addFieldWriter("floatField");
        pdeObjectWriter.addFieldWriter("stringField1");
        pdeObjectWriter.addFieldWriter("stringField2");

        byte[] dest = new byte[1024];

        Pojo1 pojo = new Pojo1();

        int bytesWritten = pdeObjectWriter.writeKeysAndValues(dest, 0, pojo, 1);

        System.out.println(bytesWritten);


    }
}
