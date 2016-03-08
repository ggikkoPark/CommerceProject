package me.ggikko.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Park Ji Hong, ggikko.
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }
}
