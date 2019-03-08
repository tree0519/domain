//package com.liu.domain.logging;
//
//
//import com.baomidou.mybatisplus.toolkit.IdWorker;
//import com.liu.domain.commons.Constants;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * <p>Description: 日志切面基类</p>
// * @since 2017-9-18
// * @author zyw
// * @version 1.0
// */
//@Component
//public abstract class AbstractLogAspect {
//
//	/***/
//	@Autowired
//	private MessageSource messageSource;
//
//	@Autowired
//	private SysLogService sysLogService;
//
//	@Autowired
//    private LogService logService;
//
//	@Autowired(required = false)
//	private HttpServletRequest request;
//;
//
//
//
//
//	public void setRequest(HttpServletRequest request) {
//		this.request = request;
//	}
//
//	/**
//	 *
//	 * 方法用途: 保存日志<br>
//	 * 实现步骤: <br>
//	 * @param log
//	 * 			SystemLog对象
//	 * @return 保存成功返回true
//	 */
//	protected boolean saveLog(Map<String,Object> log) {
//		try {
//            SysLog sysLog = new SysLog();
//            sysLog.setDesc(String.valueOf(log.get("desc")));
//            sysLog.setType((int)(log.get("type")));
//            sysLog.setRemark(String.valueOf(log.get("remark")));
//            sysLog.setId(IdWorker.getId());
//            sysLog.setCreateIp(getIpAddr(request));
//            sysLog.setCreateTime(DateTime.now().toDate());
//            sysLog.setCreateUser(logService.getUserName());
//            sysLog.setIsdel(Constants.STATUE_NORMAL);
//            sysLogService.insert(sysLog);
//            return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public String getIpAddr(HttpServletRequest request) {
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}
//	/**
//	 * 获取日志信息。
//	 *
//	 * @param code
//	 *            日志信息编码
//	 * @param varFieldNames
//	 *            变量字段名称
//	 * @param params
//	 *            方法参数
//	 * @return 返回日志信息。
//	 */
//	protected String getMessage(String code, String[] varFieldNames, Map<String, Object> params) {
//		List<Object> vars = new ArrayList<Object>();
//		if (CollectionUtils.isNotEmpty(varFieldNames)) {
//			for (String fieldName : varFieldNames) {
//				vars.add(AspectUtils.getParam(fieldName, params));
//			}
//		}
//        return messageSource.get(code, vars.toArray());
//	}
//}