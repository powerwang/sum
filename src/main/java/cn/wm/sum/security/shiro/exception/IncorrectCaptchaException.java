package cn.wm.sum.security.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

public class IncorrectCaptchaException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321458946346878114L;

	public IncorrectCaptchaException() {
		// TODO Auto-generated constructor stub
	   super();
	}
	
	public IncorrectCaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectCaptchaException(String message) {
		super(message);
	}

	public IncorrectCaptchaException(Throwable cause) {
		super(cause);
	}
}
