package com.gumdom;

import com.gumdom.bean.DefaultCache;
import com.gumdom.config.TextBase;

public class TextDefaultCache extends TextBase {

    public void testDefaultCache(){
        ctx.getBean("defaultCache", DefaultCache.class);
    }
}
