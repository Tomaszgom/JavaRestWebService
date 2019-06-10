package com.tg.restdemo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * ErrorMsg entity representing errors
 *
 */

	@XmlRootElement
	public class ErrorMsg {

		private String errorMsg;
		private int errorNumber;
		private String documentation;
		
		public ErrorMsg() {
			
		}
			
		public ErrorMsg(String errorMsg, int errorNumber, String documentation) {
			super();
			this.errorMsg = errorMsg;
			this.errorNumber = errorNumber;
			this.documentation = documentation;
		}
		public String getErrorMessage() {
			return errorMsg;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMsg = errorMessage;
		}
		public int getErrorCode() {
			return errorNumber;
		}
		public void setErrorCode(int errorCode) {
			this.errorNumber = errorCode;
		}
		public String getDocumentation() {
			return documentation;
		}
		public void setDocumentation(String documentation) {
			this.documentation = documentation;
		}
		
		
	}

