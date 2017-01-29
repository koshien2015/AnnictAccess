package cx.myhome.ckoshien.annict.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.seasar.framework.aop.interceptors.ThrowsInterceptor;
import org.seasar.framework.container.SingletonS2Container;

public class AAThrowsInterceptor extends ThrowsInterceptor  {

	/** 生成シリアル・バージョンID */
	private static final long serialVersionUID = -1316270822409456537L;

	static Logger logger = Logger.getLogger("GPThrowsInterceptor");

	public void handleThrowable(Throwable e, MethodInvocation invocation) throws Throwable {

		//MUser mUser = get(Constants.SESSION_KEY_LOGIN_INFO);

		HttpServletRequest request = SingletonS2Container.getComponent("request");
		HttpServletResponse response = SingletonS2Container.getComponent("response");

		StringBuffer sb = new StringBuffer();

		for (Enumeration<?> headerNames = request.getHeaderNames(); headerNames.hasMoreElements();) {
			String key = (String) headerNames.nextElement();
			sb.append("\n[header]");
			sb.append(key);
			sb.append("=");
			sb.append(request.getHeader(key));
		}

		Enumeration<?> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()){
			String name = (String) paramNames.nextElement();
			sb.append("\n[param]");
			sb.append(name);
			sb.append("=");
			sb.append(request.getParameter(name));
	    }

//		if ( null == mUser) {
//			sb.append("\n【セッションタイムアウト】");
//		} else {
//			sb.append("loginId=");
//			sb.append(mUser.loginId);
//		}

		sb.append("\n");
		sb.append(e.getStackTrace());
		logger.error(sb.toString(), e);
		response.sendRedirect(request.getContextPath() + "/systemErr");


	}

	public static Object get(String key) {

		// セッションを取得
		Map<String, Object> sessionScope = SingletonS2Container.getComponent("sessionScope");

		// セッションからオブジェクトを取得
		return sessionScope.get(key);

	}

}
