package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.StudyRecord;

@Repository
public interface StudyRecordRepository extends JpaRepository<StudyRecord, Long> {
}