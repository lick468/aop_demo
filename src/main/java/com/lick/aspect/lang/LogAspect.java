package com.lick.aspect.lang;

import com.lick.aspect.lang.annotation.Log;
import com.lick.aspect.lang.enums.BusinessStatus;
import com.lick.domain.OperateLog;
import com.lick.domain.User;
import com.lick.service.OperateLogService;
import com.lick.utils.IpUtils;
import com.lick.utils.ServletUtils;
import com.lick.utils.StringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 操作记录处理
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private OperateLogService operateLogService;

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);



    //配置织入点
    @Pointcut("@annotation(com.lick.aspect.lang.annotation.Log)")
    public void logPointCut() {
    }

    /**
     * 处理玩请求后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint){
        handleLog(joinPoint,null);
    }

    /**
     * 拦截异常操作
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e){
        handleLog(joinPoint,e);
    }
    protected void handleLog(final JoinPoint joinPoint,final Exception e) {
        try{
            //获得注解
            Log controllerLog = getAnnotation(joinPoint);
            if(controllerLog == null) {
                return;
            }
            UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
            String hostIp = IpUtils.getHostIp();
            String os = userAgent.getOperatingSystem().getName();
            String browser = userAgent.getBrowser().getName();

            OperateLog operateLog = new OperateLog();
            //主机地址
            operateLog.setOperIP(hostIp);
            //事务状态
            operateLog.setStatus(BusinessStatus.SUCCESS.name());
            //浏览器类型
            operateLog.setBrowser(browser);
            //操作系统类型
            operateLog.setOs(os);

            HttpServletRequest request = ServletUtils.getRequest();
            //请求地址
            operateLog.setOperURL(request.getRequestURI());

            HttpSession session = ServletUtils.getSession();
            try {
                User currentUser = (User)session.getAttribute("currentUser");
                //操作人
                operateLog.setOperator(currentUser.getUsername());
            }
            catch(Exception exp) {
                exp.printStackTrace();
            }



            if (e != null)
            {   //事务状态 错误的情况
                operateLog.setStatus(BusinessStatus.FAIL.name());
                //错误消息
                operateLog.setErrorMSG(StringUtils.substring(e.getMessage(), 0, 2000));
            }
           //设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            //操作的方法
            operateLog.setMethod(className + "." + methodName + "()");

            //处理设置注解上的参数
            getControllerMethosDescription(controllerLog,operateLog);

            operateLog.setOperTime(new Date());
            //保存数据库
            operateLogService.insertOperateLog(operateLog);

        }catch (Exception exp){
            //记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常消息{}",exp.getMessage());
            exp.printStackTrace();
        }
    }
    public void getControllerMethosDescription(Log log, OperateLog operateLog) throws Exception {
        //设置action 动作
        //业务类型
        operateLog.setOperAction(log.businessType().name());
        //设置标题
        //模块标题
        operateLog.setTitle(log.title());

    }

    private Log getAnnotation(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }

}
