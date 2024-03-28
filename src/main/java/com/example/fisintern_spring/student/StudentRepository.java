package com.example.fisintern_spring.student;

import org.springframework.data.jpa.repository.*;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.first_name LIKE %?1%")
    List<Student> findStudentByName(String first_name);


}
