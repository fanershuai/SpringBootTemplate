package com.fan.bootdemo.common.http;

/**
 * Author   : Ershuai.Fan
 * Email    : 975068649@qq.com || ershuai.fan@gmail.com
 * Create at 2018/11/7
 * Description: 响应消息码
 */
public class ResponseCode {
	/**请求成功*/
	public static final int SUCCESS=200;
	/**请求失败*/
	public static final int ERROR=500;
	/**手机号码已被注册*/
	public static final int TEL_HAS_USED=5001;
	/**您登录的帐号异常，请重新登录*/
	public static final int ACCOUNT_ERROR=5002;
	
}
