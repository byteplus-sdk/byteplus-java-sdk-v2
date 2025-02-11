package com.byteplus.ark.runtime;

/**
 * Exception indicating a SSE format error
 */
public class SSEFormatException extends Throwable{
	public SSEFormatException(String msg){
		super(msg);
	}
}