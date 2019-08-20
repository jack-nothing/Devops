package com.kechun.conf.kaptcha.conf;


import com.google.code.kaptcha.util.Config;
import com.kechun.conf.kaptcha.AppKaptcha;
import com.kechun.conf.kaptcha.WebKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KaptchaConfig {
//	@Bean
	public WebKaptcha getDefaultKaptcha() {

		WebKaptcha defaultKaptcha = new WebKaptcha();
		Properties properties = new Properties();
		// 图片边框
		properties.setProperty("kaptcha.border", "yes");
		// 边框颜色
		properties.setProperty("kaptcha.border.color", "105,179,90");
		// 字体颜色 已经被重写
		//properties.setProperty("kaptcha.textproducer.font.color", "red");
		// 图片宽
		properties.setProperty("kaptcha.image.width", "110");
		// 图片高
		properties.setProperty("kaptcha.image.height", "40");
		// 字体大小
		properties.setProperty("kaptcha.textproducer.font.size", "35");
		// session key
		properties.setProperty("kaptcha.session.key", "uav");
		// 验证码长度
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		// 字体
		properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier,Times New Roman,Trebuchet,Georgia,Lucida,Helvetica,Impact,Verdana,Tahoma");

		properties.setProperty("kaptcha.textproducer.char.space", "5");
		properties.setProperty("kaptcha.textproducer.char.string", "AabcDe2345678fYnmswx");

		properties.setProperty("kaptcha.noise.impl", "com.mycommon.KaptchaNoise");
		properties.setProperty("kaptcha.word.impl", "com.mycommon.KaptchaWordRender");


		//properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.FishEyeGimpy");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);

		return defaultKaptcha;
	}

	@Bean
	public AppKaptcha getAppKaptcha() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);

//		List<Object>  = new ArrayList<>();
		AppKaptcha appKaptcha = new AppKaptcha();
		Properties properties = new Properties();
		// 图片边框
		properties.setProperty("kaptcha.border", "yes");
		// 边框颜色
		properties.setProperty("kaptcha.border.color", "105,179,90");
		// 字体颜色 已经被重写
		//properties.setProperty("kaptcha.textproducer.font.color", "red");
		// 图片宽
		properties.setProperty("kaptcha.image.width", "110");
		// 图片高
		properties.setProperty("kaptcha.image.height", "40");
		// 字体大小
		properties.setProperty("kaptcha.textproducer.font.size", "35");
		// session key
		properties.setProperty("kaptcha.session.key", "uav");
		// 验证码长度
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		// 字体
		properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier,Times New Roman,Trebuchet,Georgia,Lucida,Helvetica,Impact,Verdana,Tahoma");

		properties.setProperty("kaptcha.textproducer.char.space", "5");
		properties.setProperty("kaptcha.textproducer.char.string", "AabcDe2345678fYnmswx");

		properties.setProperty("kaptcha.noise.impl", "com.mycommon.config.kaptcha.KaptchaNoise");
		properties.setProperty("kaptcha.word.impl", "com.mycommon.config.kaptcha.KaptchaWordRender");

		properties.setProperty("kaptcha.obscurificator.impl", "com.mycommon.config.kaptcha.KaptchaNoStyle");
		Config config = new Config(properties);
		appKaptcha.setConfig(config);

		return appKaptcha;
	}
}