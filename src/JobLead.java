public class JobLead {
    private String companyName;
    private String contactName;
    private String contactPhoneNum;
    private String jobTitle;
    private String jobDescription;

    //Overloaded constructor that sets all values.
    public JobLead(String companyName, String contactName, String contactPhoneNum, String jobTitle, String jobDescription) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactPhoneNum = contactPhoneNum;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    //Getters and setters for all 5 attributes.
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNum() {
        return contactPhoneNum;
    }

    public void setContactPhoneNum(String contactPhoneNum) {
        this.contactPhoneNum = contactPhoneNum;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    //Overridden toString that gives us back a string containing all the information regarding the JobLead
    @Override
    public String toString() {
        return "Company:"
                + companyName
                + ",Contact:"
                + contactName
                + ",Phone: "
                + contactPhoneNum
                + ",Title: "
                + jobTitle
                + ",Description: "
                + jobDescription;
    }

}
