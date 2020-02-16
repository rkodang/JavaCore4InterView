package com.gumdom;

import com.gumdom.Pojo.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TextGoodsMapper extends TestBase {
    @Test
    public void testInsertObject(){
        //1.创建Goods对象
        long size= (long) ((Math.random()*102)*(Math.random()*100));

        Goods goods=new Goods();
        goods.setId(size);
        goods.setName("MyBa2");
        goods.setRemark("ReMark...6");

        SqlSession session=build.openSession();
        String statment="com.gumdom.Dao.GoodMapper.insertObject";
        int insert = session.insert(statment, goods);
        session.commit();
        System.out.println(insert);
        size++;
    }
}
