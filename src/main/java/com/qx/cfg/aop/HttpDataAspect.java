package com.qx.cfg.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

@Aspect
@Component
@Order(Integer.MAX_VALUE - 1)
public class HttpDataAspect {
	//private Logger logger = LoggerFactory.getLogger(getClass());

	
	@Around("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
	public Object requestMappingAspect(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) pjp;
		MethodSignature methodSign = (MethodSignature) methodJoinPoint.getSignature();
		String reqParams = JSON.toJSONString(methodJoinPoint.getArgs());
		long startTime = System.currentTimeMillis();
		System.out.println(startTime+"");
		// methodSign.getDeclaringTypeName(), methodSign.getName()
		String name = methodSign.toShortString();
		String resp = "";
		int rstatus = 0;
		String rmsg = "";
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			rstatus = 1;
			rmsg = e.getMessage();
			/*if (methodSign.getReturnType().isAssignableFrom(HttpBaseDto.class)) {
				HttpBaseDto returnDto = new HttpBaseDto();
				returnDto.setCode(RespCode.SYS_ERR.getCode());
				returnDto.setMessage(RespCode.SYS_ERR.getMsg());
				if (e instanceof BizException) {
					BizException bizException = (BizException) e;
					returnDto.setCode(bizException.getCode());
					returnDto.setMessage(bizException.getMessage());
				}
				result = returnDto;
			}*/
		}
		long time = System.currentTimeMillis() - startTime;
		resp = JSON.toJSONString(result);
		System.out.println("[HTTP] process info: [name:" + name + "][reqParams:" + reqParams + "][resp:" + resp + "][rstatus:" + rstatus + "][rmsg:" + rmsg + "][time:" + time + "]");
		//apilogService.insert(name, reqParams, resp, "", rstatus, rmsg, time);
		return result;
	}

	private Class<?> returnClass(ProceedingJoinPoint pjp) {
		MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) pjp;
		MethodSignature methodSign = (MethodSignature) methodJoinPoint.getSignature();
		// String returnType = methodSign.getReturnType().getSimpleName();
		return methodSign.getReturnType();
	}
}
