package com.gumdom.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextBase {
    protected AnnotationConfigApplicationContext ctx;

    @Before
    public void init(){
        ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    @Test
    public void testCtx(){
        System.out.println(ctx);
    }

    @After
    public void close(){
        ctx.close();
    }
}
