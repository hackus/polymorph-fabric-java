package com.plmph.pde.obj;

import com.plmph.pde.PdeFieldTypes;
import com.plmph.pde.util.TestConstants;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PdeObjectWriterImplTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        PdeObjectWriterImpl pdeObjectWriter = new PdeObjectWriterImpl(Pojo1.class).addAllFields();

        byte[] dest = new byte[1024];

        Pojo1 pojo = new Pojo1();

        int bytesWritten = pdeObjectWriter.writeKeysAndValues(dest, 0, pojo, 1);
        assertEquals(106, bytesWritten);

        int offset = 0;
        assertEquals(PdeFieldTypes.OBJECT_1_LENGTH_BYTES, 0xFF & dest[offset++]);
        assertEquals(104, 0xFF & dest[offset++]);  // the 1 length byte should contain the value 104
        assertEquals(PdeFieldTypes.KEY_7_BYTES, 0xFF & dest[offset++]);
        assertEquals('i', 0xFF & dest[offset++]);
        assertEquals('s', 0xFF & dest[offset++]);
        assertEquals('V', 0xFF & dest[offset++]);
        assertEquals('a', 0xFF & dest[offset++]);
        assertEquals('l', 0xFF & dest[offset++]);
        assertEquals('i', 0xFF & dest[offset++]);
        assertEquals('d', 0xFF & dest[offset++]);
        assertEquals(PdeFieldTypes.BOOLEAN_FALSE, 0xFF & dest[offset++]);

        assertEquals(PdeFieldTypes.KEY_1_LENGTH_BYTES, 0xFF & dest[offset++]);
        assertEquals( 24, 0xFF & dest[offset++]);
        assertEquals('i', 0xFF & dest[offset++]);
        assertEquals('n', 0xFF & dest[offset++]);
        assertEquals('t', 0xFF & dest[offset++]);
        assertEquals('e', 0xFF & dest[offset++]);
        assertEquals('g', 0xFF & dest[offset++]);
        assertEquals('e', 0xFF & dest[offset++]);
        assertEquals('r', 0xFF & dest[offset++]);
        assertEquals('F', 0xFF & dest[offset++]);
        assertEquals('i', 0xFF & dest[offset++]);
        assertEquals('e', 0xFF & dest[offset++]);
        assertEquals('l', 0xFF & dest[offset++]);
        assertEquals('d', 0xFF & dest[offset++]);
        assertEquals('W', 0xFF & dest[offset++]);
        assertEquals('i', 0xFF & dest[offset++]);
        assertEquals('t', 0xFF & dest[offset++]);
        assertEquals('h', 0xFF & dest[offset++]);
        assertEquals('L', 0xFF & dest[offset++]);
        assertEquals('o', 0xFF & dest[offset++]);
        assertEquals('n', 0xFF & dest[offset++]);
        assertEquals('g', 0xFF & dest[offset++]);
        assertEquals('N', 0xFF & dest[offset++]);
        assertEquals('a', 0xFF & dest[offset++]);
        assertEquals('m', 0xFF & dest[offset++]);
        assertEquals('e', 0xFF & dest[offset++]);

        assertEquals(PdeFieldTypes.INT_POS_1_BYTES, 0xFF & dest[offset++]);
        assertEquals(189, 0xFF & dest[offset++]);


        //todo test correct encoding of all the remaining Pojo1 fields.

        //String str = new String(Arrays.copyOfRange(dest, 0, bytesWritten), StandardCharsets.US_ASCII);

        //assertEquals(TestConstants.pojo1AsASCIIString, str);
        //assertEquals(TestConstants.pojo1AsASCIIString.length(), bytesWritten);
    }
}
