package com.pcehr.base.utils;

public class CustomException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String message=null;

		public CustomException(String message) {
			super(message);
			this.message = message;
		}

		@Override
		public String toString() {
			return message;
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return message;
		}

	}


