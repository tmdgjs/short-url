package com.hansheon.shorturl;

import com.hansheon.shorturl.global.common.Base62;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base62Test {

    @Test
    public void testEncodeAndDecode() throws Exception{
        String url = "https://google.co.kr";
        String encoding = Base62.encode(url);
        System.out.println("Encode : " + encoding);

        assertEquals(url, Base62.decode(encoding));
    }
}
