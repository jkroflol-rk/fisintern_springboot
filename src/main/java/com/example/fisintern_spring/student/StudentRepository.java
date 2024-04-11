package com.example.fisintern_spring.student;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.first_name LIKE %?1%")
    List<Student> findStudentByName(String first_name);

    @Query(value="SELECT s.student_id, s.first_name, s.last_name, c.class_id, c.score FROM " +
            "student s INNER JOIN student_class c ON s.student_id = c.student_id",
            nativeQuery = true)
    List<Object[]> findStudentClassData();

    @Query(value="SELECT AVG(score) FROM student_class c WHERE c.student_id = ?1", nativeQuery = true)
    Double findAverageScore(Integer student_id);

    //write query to update the score in student table
    @Modifying
    @Query("UPDATE Student s SET s.score = :score WHERE s.student_id = :student_id")
    void updateScore(@Param("score") Integer score, @Param("student_id") Integer student_id);
}


