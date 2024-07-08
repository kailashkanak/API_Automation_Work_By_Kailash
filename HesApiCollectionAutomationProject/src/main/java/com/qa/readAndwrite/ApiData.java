package com.qa.readAndwrite;

public class ApiData {

    private String apiName;
    private String apiLink;
    private String apiRequest;
    private String requestBody;
    private String testCaseType;
    private String expected_code;
    private String remark;
    private String token_key;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiLink() {
        return apiLink;
    }

    public void setApiLink(String apiLink) {
        this.apiLink = apiLink;
    }

    public String getApiRequest() {
        return apiRequest;
    }

    public void setApiRequest(String apiRequest) {
        this.apiRequest = apiRequest;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getTestCaseType() {
        return testCaseType;
    }

    public void setTestCaseType(String testCaseType) {
        this.testCaseType = testCaseType;
    }

    public String getExpected_code() {
        return expected_code;
    }

    public void setExpected_code(String expected_code) {
        this.expected_code = expected_code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToken_key() {
        return token_key;
    }

    public void setToken_key(String token_key) {
        this.token_key = token_key;
    }

    public ApiData(String apiName, String apiLink, String apiRequest, String requestBody, String testCaseType, String expected_code, String remark, String token_key) {

        this.apiName = apiName;
        this.apiLink = apiLink;
        this.apiRequest = apiRequest;
        this.requestBody = requestBody;
        this.testCaseType = testCaseType;
        this.expected_code = expected_code;
        this.remark = remark;
        this.token_key = token_key;
    }


   @Override
    public String toString() {
        return "ApiData{" +
                ", apiName='" + apiName + '\'' +
                ", apiLink='" + apiLink + '\'' +
                ", apiRequest='" + apiRequest + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", testCaseType='" + testCaseType + '\'' +
                ", expected_code='" + expected_code + '\'' +
                ", remark='" + remark + '\'' +
                ", token_key='" + token_key + '\'' +
                '}';
    }
}

