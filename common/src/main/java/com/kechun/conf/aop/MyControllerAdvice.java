package com.kechun.conf.aop;

import com.kechun.conf.ContentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * 全局性异常拦截
 */
@RestControllerAdvice
@ControllerAdvice
public class MyControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(MyControllerAdvice.class);
    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ContentSet errorHandler(Exception ex) {
        String exStr = ex.getMessage();
        System.out.println(exStr);
        int st = 0;
        if(!"".equals(exStr)){
            if(exStr.length() < 100){
                st = exStr.length();
            }else{
                st = 100;
            }
        }
        ContentSet cs = ContentSet.getContentSet(500,null,"异常如下:"+exStr.substring(0,st));
        LOG.info("#################:error");
        LOG.info(ex.getMessage());
        LOG.info("#################:error");
        return cs;
    }
}