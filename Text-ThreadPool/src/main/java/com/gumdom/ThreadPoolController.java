package com.gumdom;

import com.gumdom.Service.ServiceForThreadPoolText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class ThreadPoolController {
    @Autowired
    private ServiceForThreadPoolText serviceForThreadPoolText;

    @RequestMapping("/getTest")
    @ResponseBody
    public void getTest(){
        for (int i = 0; i < 30; i++) {
            serviceForThreadPoolText.get01();
            serviceForThreadPoolText.get02();
            System.out.println("第"+i+"次");
            System.out.println("----------------");
        }
    }
    @RequestMapping("/getTestParam")
    @ResponseBody
    public String getTest01(HttpServletRequest req) throws ExecutionException, InterruptedException {
        String url=req.getParameter("url")==null?"JDK1.8":req.getParameter("url");
        Future<String> execute = serviceForThreadPoolText.execute(url);
        return execute.get();
    }
}
