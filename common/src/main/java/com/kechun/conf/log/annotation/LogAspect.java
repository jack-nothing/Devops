package com.kechun.conf.log.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

	public static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	//@Autowired
	//private SysLogDao logMapper;

	/*@Pointcut("@annotation(com.xuhui.invmode.config.log.annotation.Log)")
	private void pointcut() {

	}*/

	/*@After("pointcut()")
	public void insertLogSuccess(JoinPoint jp) {
		addLog(jp, getDesc(jp));
	}*/
	private void addLog(JoinPoint jp, String text) {
		log.debug("addLog:"+text);

	}
	/*private void addLog(JoinPoint jp, String text) {
		StringBuffer buffer = null;
		try {
			Log.LOG_TYPE type = getType(jp);
			SysLog log = new SysLog();
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			// 一些系统监控
			if (requestAttributes != null) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				String ip = IpUtil.getIp(request);
				log.setIp(ip);
			}
			log.preInsert();
			log.setType(type.toString());
			log.setText(text);

			Object[] obj = jp.getArgs();
			buffer = new StringBuffer();
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					buffer.append("[参数" + (i + 1) + ":");
					Object o = obj[i];
					if (o instanceof Model) {
						continue;
					}
					String parameter = null;
					try {
						parameter = JSON.toJSONString(o);
					} catch (Exception e) {
						continue;
					}
					buffer.append(parameter);
					buffer.append("]");
				}
			}
			log.setParam(buffer.toString());
			CurrentUser currentUser = ShiroUtil.getCurrentUser();
			log.setUserName(currentUser.getName());
			logMapper.insert(log);
			buffer.setLength(0);
		} catch (Exception e) {
			log.error(e.getMessage());
		}finally {
			if(buffer != null) {
				try {
					buffer.setLength(0);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		}
	}*/

	/**
	 * 记录异常
	 *
	 * @param joinPoint
	 * @param e
	 */
	/*@AfterThrowing(value = "pointcut()", throwing = "e")
	public void afterException(JoinPoint joinPoint, Exception e) {
		addLog(joinPoint, getDesc(joinPoint) + e.getMessage());
	}*/

	/*private String getDesc(JoinPoint joinPoint) {
		MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
		Method method = methodName.getMethod();
		return method.getAnnotation(Log.class).desc();
	}

	private Log.LOG_TYPE getType(JoinPoint joinPoint) {
		MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
		Method method = methodName.getMethod();
		return method.getAnnotation(Log.class).type();
	}*/
}
