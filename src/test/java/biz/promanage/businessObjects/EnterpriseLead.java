package biz.promanage.businessObjects;

public class EnterpriseLead {
    private String customerName;
    private String mobileNo;
    private String email;
    private String storeCount;
    private String jobTitle;
    private String companyName;
    private String companyWebsiteUrl;
    private String cityName;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCompanyWebsiteUrl(String companyWebsiteUrl) {
        this.companyWebsiteUrl = companyWebsiteUrl;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setStoreCount(String storeCount) {
        this.storeCount = storeCount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public EnterpriseLead() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNo() {  return mobileNo; }

    public String getEmail() {
        return email;
    }

    public String getStoreCount() {
        return storeCount;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyWebsiteUrl() {
        return companyWebsiteUrl;
    }

    public String getCityName() {
        return cityName;
    }

    public Boolean acceptTerms() {
        return Boolean.TRUE;
    }
}
