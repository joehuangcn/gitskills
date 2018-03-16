package business.controller;

import business.aop.Action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangqiao on 2017/8/13.
 */
@Controller
@RequestMapping("demoControll")
public class DemoController {
    @RequestMapping("/change")
    public ModelAndView changetype(){
        return new ModelAndView("demo1");
    }

    @RequestMapping("changedemo")
    @Action(desc = "test aop!!!")
    public String changeDemo(){
        return "demo2";
    }
}
