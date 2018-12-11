package com.qa.soph.springStarterExerciseDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soph.springStarterExerciseDatabase.model.MySpringBootDataModel;

@Repository
public interface PersonRepository extends JpaRepository<MySpringBootDataModel,Long> {

}
