package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
@RestController
@RequestMapping("/get")
public class GetController {
    @GetMapping("/getNow")
    public String getNow(HttpServletRequest request){
        Date date = new Date();
        HttpSession session = request.getSession();
        if (session.getAttribute("count")==null){
            session.setAttribute("count",1);
        }else{
            int count =(Integer) session.getAttribute("count");
            count++;
            session.setAttribute("count",count);
        }
        return "调用get/getNow"+(int)session.getAttribute("count")+"次";
    }
}
