/**
 * 
 */
package com.hedgeness.app.exception;

/**
 * @author Kuljeet
 *
 */
public class ExceptionObject extends Exception {

	/**
	 * 
	 */
	public ExceptionObject() {
		super();
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * @param message
//	 * @param cause
//	 * @param enableSuppression
//	 * @param writableStackTrace
//	 */
//	public ExceptionObject(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionObject(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ExceptionObject(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ExceptionObject(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	// technical error
	private String _localizedMessage = null;

	// error to present business layer
	private String _businessErrorMessage = null;

	private String _errorCode = null;

	/**
	 * @return the localizedMessage
	 */
	public String getLocalizedMessage() {
		return _localizedMessage;
	}

	/**
	 * @param localizedMessage
	 *            the localizedMessage to set
	 */
	public void setLocalizedMessage(String localizedMessage) {
		_localizedMessage = localizedMessage;
	}

	public ExceptionObject(Throwable e, String errorMessage, String localizedMessage, String businessErrorMessage,
			String errorCode) {

		super(errorMessage, e);

		_localizedMessage = localizedMessage;
		_businessErrorMessage = businessErrorMessage;
		_errorCode = errorCode;

	}

	public ExceptionObject(Throwable e, String businessErrorMessage, String errorCode) {

		super(e);

		_businessErrorMessage = businessErrorMessage;
		_errorCode = errorCode;

	}

	public ExceptionObject(Throwable e, String errorMessage, String businessErrorMessage, String errorCode) {

		super(errorMessage, e);

		_businessErrorMessage = businessErrorMessage;
		_errorCode = errorCode;

	}

	public ExceptionObject(String errorMessage, String businessErrorMessage, String errorCode) {

		super(errorMessage);
		_businessErrorMessage = businessErrorMessage;
		_errorCode = errorCode;

	}

	public ExceptionObject(String errorMessage, String businessErrorMessage) {

		super(errorMessage);
		_businessErrorMessage = businessErrorMessage;

	}

	/**
	 * @return the exception
	 */
	public Throwable getException() {
		return super.getCause();
	}

	// /**
	// * @param exception
	// * the exception to set
	// */
	// public void setException(Throwable exception) {
	//
	// }

	/**
	 * @return the businessErrorMessage
	 */
	public String getBusinessErrorMessage() {
		return _businessErrorMessage;
	}

	/**
	 * @param businessErrorMessage
	 *            the businessErrorMessage to set
	 */
	public void setBusinessErrorMessage(String businessErrorMessage) {
		_businessErrorMessage = businessErrorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return _errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		_errorCode = errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName() + ":" + getMessage();
	}

	public ExceptionObject getRootCause() {

		Throwable t = this.getCause();
		
		//String businessErrorMessage=null;
		if (t == null) {
			return this;
		} else {
			Throwable t1 = null;
			while (t != null) {
				if(t instanceof ExceptionObject){
					String businessErrorMessage1=((ExceptionObject)t).getBusinessErrorMessage();
					if(businessErrorMessage1 !=null){
						_businessErrorMessage=businessErrorMessage1;
					}
				}
				t1 = t;
				t = t.getCause();
//				if(t !=null && !(t instanceof  ExceptionObject)){
//					break;
//				}
				
			}
			//TODO: REVSIT not throw INITIAL Exception , throw only business exception 
			if (t1 instanceof ExceptionObject) {
				return (ExceptionObject) t1;
			} else {
				t1.printStackTrace();
				return new ExceptionObject(t1, t1.getMessage(), _businessErrorMessage, "");
			}
		}

	}

	public String getBusinessAndExceptionMessage() {
		ExceptionObject oe = getRootCause();

		//return "Business Error [" + oe.getBusinessErrorMessage() + "] Exception[" + oe.getMessage() + "]";
		return "Business Error [" + oe.getBusinessErrorMessage() + "]";
	}

}
