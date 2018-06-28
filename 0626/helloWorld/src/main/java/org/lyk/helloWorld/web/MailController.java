package org.lyk.helloWorld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by yuankliu on 28/06/2018.
 */
@Controller
@RequestMapping("/MailController/")
public class MailController
{
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;

    @ResponseBody
    @RequestMapping("sendMail")
    public Object sendMail(String to, String subject,String content)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try
        {
            this.mailSender.send(simpleMailMessage);
            return "邮件已发送到" + to;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "发送异常";
        }
    }



    @ResponseBody
    @RequestMapping("sendFromTemplate")
    public Object sendFromTemplate(String to, String subject, String nickName) throws MessagingException
    {
        Context context = new Context();
        context.setVariable("nickName", nickName);
        String content = this.templateEngine.process("emailTemplate", context);


        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(this.from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
        return "发送成功";
    }

    @RequestMapping("showEmailTemplate")
    public String showEmailTemplate(String nickName, ModelMap modelMap)
    {
        modelMap.addAttribute("nickName",nickName);
        return "emailTemplate";
    }
}
