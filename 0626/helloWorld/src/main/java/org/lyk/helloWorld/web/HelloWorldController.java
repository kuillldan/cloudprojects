package org.lyk.helloWorld.web;

import org.lyk.helloWorld.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yuankliu on 26/06/2018.
 */
@Controller
public class HelloWorldController
{

    @RequestMapping("/hello")
    public String hello(ModelMap map)
    {
        map.addAttribute("message","http://www.google.com");
        return "hello";
    }

}
