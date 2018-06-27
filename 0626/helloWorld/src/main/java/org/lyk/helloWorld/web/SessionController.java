package org.lyk.helloWorld.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuankliu on 27/06/2018.
 */

@RequestMapping("SessionController")
@RestController
public class SessionController
{


    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message", "hello spring session");
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession")
    public Object getSession(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }
}
