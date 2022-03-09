package com.tanmay.Liv2Train.exception;

public class SpringException extends RuntimeException{
	   private String exceptionMsg;
	   
	   public SpringException(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	   public String getExceptionMsg(){
	      return this.exceptionMsg;
	   }
	   public void setExceptionMsg(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	}
