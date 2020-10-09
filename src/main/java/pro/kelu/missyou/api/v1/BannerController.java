package pro.kelu.missyou.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
@RestController
@RequestMapping("/v1/banner")
public class BannerController {

//    @GetMapping("/test")
//    public void test(HttpServletResponse response) throws IOException {
//        response.getWriter().write("Hello，冰!");
////        return "Hello, Choi!";
//    }

    @GetMapping("test")
//    @ResponseBody
    public String test() {
        return "Hello, 冰!";
    }
}
