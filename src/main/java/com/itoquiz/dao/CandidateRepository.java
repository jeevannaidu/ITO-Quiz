package com.itoquiz.dao;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import com.itoquiz.entity.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> { // We need to specify <Model Name , Datatype of the prirmary key>

}
