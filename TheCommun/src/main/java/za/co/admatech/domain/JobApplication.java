package za.co.admatech.domain;

public class JobApplication {
    private String applicationId;
    private String jobId;
    private String applicantId;
    private String applicationDate;
    private String status;

    public JobApplication() {
    }

    private JobApplication(Builder builder) {
        this.applicationId = builder.applicationId;
        this.jobId = builder.jobId;
        this.applicantId = builder.applicantId;
        this.applicationDate = builder.applicationDate;
        this.status = builder.status;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getJobId() {
        return jobId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", applicantId='" + applicantId + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private String applicationId;
        private String jobId;
        private String applicantId;
        private String applicationDate;
        private String status;

        public Builder setApplicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public Builder setJobId(String jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder setApplicantId(String applicantId) {
            this.applicantId = applicantId;
            return this;
        }

        public Builder setApplicationDate(String applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public JobApplication build() {
            return new JobApplication(this);
        }
    }
}
