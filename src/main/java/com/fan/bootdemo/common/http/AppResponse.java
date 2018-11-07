package com.fan.bootdemo.common.http;

/**
 * Author   : Ershuai.Fan
 * Email    : 975068649@qq.com || ershuai.fan@gmail.com
 * Create at 2018/11/7
 * Description: 返回体
 */
public class AppResponse<T> {
	private int responseCode;
	private String errorMsg;
	private T responseBody;
	
	public AppResponse() {
	}
	
	public AppResponse(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public AppResponse(int responseCode,T responseBody) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
	}
	
	public AppResponse(int responseCode, String errorMsg, T responseBody) {
		this.responseCode = responseCode;
		this.errorMsg = errorMsg;
		this.responseBody = responseBody;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public T getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}
	
	

}
