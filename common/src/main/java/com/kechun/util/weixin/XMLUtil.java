package com.kechun.util.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLUtil {
    private static final Logger LOG = LoggerFactory.getLogger(XMLUtil.class);

//    public static Map<String, String> xml2Map(HttpServletRequest request) {
//        try {
//            Map<String, String> map = new HashMap<>();
//            SAXReader reader = new SAXReader();
//            InputStream inputStream = request.getInputStream();
//            Document doc = reader.read(inputStream);
//            Element root = doc.getRootElement();
//            List<Element> list = root.elements();
//            for (Element e : list) {
//                map.put(e.getName(), e.getText());
//            }
//            inputStream.close();
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOG.info(e.getMessage());
//        }
//        return null;
//    }
}