package za.co.admatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.admatech.domain.JobApplication;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, String>{
    List<JobApplication> findAll();
    List<JobApplication> findByJobId(String jobId);
    List<JobApplication> findByApplicantId(String applicantId);
}