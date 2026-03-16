package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudyRecord;
import com.example.demo.repositories.StudyRecordRepository;

@RestController
@RequestMapping("/api")
public class StudyRecordController {
    
    @Autowired
    StudyRecordRepository repository;

    @GetMapping("/records")
    public List<StudyRecord> getRecords() {
        return repository.findAll();
    }

}
