package com.kechun.util.weixin;

import com.kechun.conf.Contants;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;


@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class MessageController {
    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

//    @Autowired
//    private MessageService messageService;


    @RequestMapping("/getMessage")
    public String getMessage(WeiXinContent wx, HttpServletRequest rq) {
        System.out.println(wx);
        LOG.info("微信接口进入:"+wx);
//        String signature = "7a0139f5c162e5794854344bc3a0a4e88d393a96";
//        String timestamp = "1543936455";
//        String nonce = "272696921";
        String signature = wx.getSignature();
        String timestamp = wx.getNonce();
        String nonce = wx.getTimestamp();
        String echostr = wx.getEchostr();
        String[] strs = new String[]{Contants.TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        String strss = "";
        for (String str : strs) {
            strss += str;
        }
        String sign = DigestUtils.sha1Hex(strss);
        if (signature.equals(sign)) {
            if(echostr != null){
                return echostr;
            }
//            Map<String, String> map = XMLUtil.xml2Map(rq);
            Map<String, String> map = null;
//            messageService.saveMessage(map);
            LOG.info("入库消息:"+map);
            System.out.println(map);
        }
        return null;
    }
}