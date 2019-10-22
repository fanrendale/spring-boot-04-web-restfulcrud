package study;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 学习Junit
 * @author xjf
 * @date 2019/3/25 19:18
 */
public class TestJunit {

    @Test
    public void testAdd(){
        String str = "Junit is a working fine";
        assertEquals("Junit is a working fine",str);
    }
}
