package com.cognizant.ormlearn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.country;
@Repository
public interface CountryRepository extends JpaRepository<country,String> {
}

