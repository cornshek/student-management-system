package com.zl.commons.vo;

import java.util.List;

/**
 * 响应给前端的json对象
 * @author THINK
 *
 * @param <T>
 */

public class JSONResult<T> {
	/**消息*/
	private String msg;
	/**状态码   20000 表示成功,  20001 表示失败*/
	private int code;
	
	/**集合数据*/
	private List<T> records;
	
	/**单个数据*/
	private T data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
