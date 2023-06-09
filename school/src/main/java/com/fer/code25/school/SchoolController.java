package com.fer.code25.school;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

  private final SchoolService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
   public void save(@RequestBody School school){
      service.saveSchool(school);
  }

  @GetMapping
  public ResponseEntity<List<School>> findAllStudent(){
      return ResponseEntity.ok(service.findAllSchool());}

  @GetMapping("/with-student/{school-id}")
  public ResponseEntity<FullSchoolResponse> findAllStudent(@PathVariable("school-id") Integer schoolId){

      return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
  }

}
