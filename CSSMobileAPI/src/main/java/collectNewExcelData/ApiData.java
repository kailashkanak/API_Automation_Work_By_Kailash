package collectNewExcelData;

public class ApiData
{
    private String APIName;
    private String APIUrl;
    private String ApiRequest;
    private String requestBody;
    private String testCasetype;
    private String expected_statusCode;
    private String remark;
    private String token_key;
    private String APImodule;

    public String getAPImodule()
    {
        return APImodule;
    }
    public void setAPImodule(String aPImodule)
    {
        APImodule = aPImodule;
    }
    public String getAPIName()
    {
        return APIName;
    }
    public void setAPIName(String aPIName)
    {
        APIName = aPIName;
    }
    public String getAPIUrl()
    {
        return APIUrl;
    }
    public void setAPIUrl(String aPIUrl)
    {
        APIUrl = aPIUrl;
    }
    public String getApiRequest()
    {
        return ApiRequest;
    }
    public void setApiRequest(String apiRequest)
    {
        ApiRequest = apiRequest;
    }
    public String getRequestBody() {
        return requestBody;
    }
    public void setRequestBody(String requestBody)
    {
        this.requestBody = requestBody;
    }
    public String getTestCasetype()
    {
        return testCasetype;
    }
    public void setTestCasetype(String testCasetype)
    {
        this.testCasetype = testCasetype;
    }
    public String getExpected_statusCode()
    {
        return expected_statusCode;
    }
    public void setExpected_statusCode(String expected_statusCode)
    {
        this.expected_statusCode = expected_statusCode;
    }
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    public String getToken_key()
    {
        return token_key;
    }
    public void setToken_key(String token_key)
    {
        this.token_key = token_key;
    }

    public ApiData(String APImodule, String APIName, String APIUrl, String ApiRequest, String requestBody, String testCasetype, String expected_statusCode, String remark, String token_key)
    {
        this.APImodule=APImodule;
        this.APIName=APIName;
        this.APIUrl=APIUrl;
        this.ApiRequest=ApiRequest;
        this.requestBody=requestBody;
        this.testCasetype=testCasetype;
        this.expected_statusCode=expected_statusCode;
        this.remark=remark;
        this.token_key=token_key;
    }

    @Override
    public String toString() {
        return "ApiData{" +
                "APImodule='" + APImodule + '\'' +
                ", APIName='" + APIName + '\'' +
                ", APIUrl='" + APIUrl + '\'' +
                ", ApiRequest='" + ApiRequest + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", testCasetype='" + testCasetype + '\'' +
                ", expected_statusCode='" + expected_statusCode + '\'' +
                ", remark='" + remark + '\'' +
                ", token_key='" + token_key + '\'' +
                '}';
    }
}
