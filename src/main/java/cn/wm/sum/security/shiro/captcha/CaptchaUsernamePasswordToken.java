package cn.wm.sum.security.shiro.captcha;

import org.apache.shiro.authc.UsernamePasswordToken;
/**
 * 
 * @author wang
 * 添加验证码
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2679484803655214514L;
	private String captcha;

	public CaptchaUsernamePasswordToken(String username, char[] password,  
            boolean rememberMe, String host, String captcha) {
		// TODO Auto-generated constructor stub
		
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}
	
	
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}
