
package com.smarthire.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.smarthire.entity.Vacancy;

@Repository
@Component
public interface SmartHireRepository extends JpaRepository<Vacancy, Long> {


	List<Vacancy> findByJobId(Long jobId);

	// List<Vacancy> findByVacancyName(String vacancyName);

}
