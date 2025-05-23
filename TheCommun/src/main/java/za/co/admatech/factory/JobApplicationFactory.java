package za.co.admatech.factory;

import za.co.admatech.domain.JobApplication;
import za.co.admatech.util.Helper;

public class JobApplicationFactory {
    public static JobApplication createApplication(String jobId, String applicantId, String applicationDate, String status) {
        if (Helper.isNullOrEmpty(jobId) || Helper.isNullOrEmpty(applicantId) ||
                Helper.isNullOrEmpty(applicationDate) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        String applicationId = Helper.generateId();

        return new JobApplication.Builder()
                .setApplicationId(applicationId)
                .setJobId(jobId)
                .setApplicantId(applicantId)
                .setApplicationDate(applicationDate)
                .setStatus(status)
                .build();
    }
}
