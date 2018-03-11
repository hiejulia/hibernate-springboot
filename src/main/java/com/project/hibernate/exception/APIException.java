package com.project.hibernate.exception;


import org.springframework.http.HttpStatus;



public class APIException extends ResponseException {

    private static final long serialVersionUID = -5962051580036174595L;

    private Integer errorCode;
    private HttpStatus httpStatus;
    private String APIPath;
    private String errorMessage;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAPIPath() {
        return APIPath;
    }

    public void setAPIPath(String aPIPath) {
        APIPath = aPIPath;
    }

    public APIException(
            Integer errorCode,
            HttpStatus httpStatus,
            String errorMessage,
            String APIPath) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.APIPath = APIPath;
    }

    public APIException(
            HttpStatus httpStatus,
            String APIPath,
            ResponseModel responseModel) {
        super(responseModel, new Throwable());
        this.httpStatus = httpStatus;
        this.APIPath = APIPath;
    }

}