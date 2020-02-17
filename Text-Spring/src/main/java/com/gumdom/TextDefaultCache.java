package com.gumdom;

import com.gumdom.bean.DefaultCache;
import com.gumdom.config.TextBase;
import org.junit.Test;

public class TextDefaultCache extends TextBase {

    @Test
    public void testDefaultCache(){
        DefaultCache defaultCache1 = ctx.getBean("defaultCache", DefaultCache.class);
        DefaultCache defaultCache2 = ctx.getBean("defaultCache", DefaultCache.class);
        System.out.println(defaultCache1);//单例
        System.out.println(defaultCache2);
    }
}
