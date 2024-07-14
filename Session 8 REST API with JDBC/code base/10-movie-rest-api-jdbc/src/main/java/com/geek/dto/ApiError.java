package com.geek.dto;

public class ApiError {
private String msg;
public ApiError() {
	// TODO Auto-generated constructor stub
}

public ApiError(String msg) {
	super();
	this.msg = msg;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

}
