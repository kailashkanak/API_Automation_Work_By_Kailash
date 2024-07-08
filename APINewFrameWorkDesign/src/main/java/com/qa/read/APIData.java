package com.qa.read;

public class APIData {
    private String apiName;
    private String apiLink;
    private String apiRequest;
    private String testcaseType;
    private String expectedCode;
    private String requestBody;
    private String remark;
    private String token_key;

    //creating constructor

    public APIData(String apiName,String apiLink,String apiRequest,String testcaseType,String expectedCode,String requestBody,String remark,String token_key)
    {
        this.apiName=apiName;
        this.apiLink=apiLink;
        this.apiRequest=apiRequest;
        this.requestBody=requestBody;
        this.testcaseType=testcaseType;
        this.expectedCode=expectedCode;
        this.remark=remark;
        this.token_key=token_key;
    }

    //Creating getters and setters


    public java.lang.String getApiName() {
        return apiName;
    }

    public void setApiName(java.lang.String apiName) {
        this.apiName = apiName;
    }

    public java.lang.String getApiLink() {
        return apiLink;
    }

    public void setApiLink(java.lang.String apiLink) {
        this.apiLink = apiLink;
    }

    public java.lang.String getApiRequest() {
        return apiRequest;
    }

    public void setApiRequest(java.lang.String apiRequest) {
        this.apiRequest = apiRequest;
    }

    public java.lang.String getTestcaseType() {
        return testcaseType;
    }

    public void setTestcaseType(java.lang.String testcaseType) {
        this.testcaseType = testcaseType;
    }

    public java.lang.String getExpectedCode() {
        return expectedCode;
    }

    public void setExpectedCode(java.lang.String expectedCode) {
        this.expectedCode = expectedCode;
    }

    public java.lang.String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(java.lang.String requestBody) {
        this.requestBody = requestBody;
    }

    public java.lang.String getRemark() {
        return remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getToken_key() {
        return token_key;
    }

    public void setToken_key(java.lang.String token_key) {
        this.token_key = token_key;
    }
}
