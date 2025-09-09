package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {
    private long id;
    private String name;
    private String branch;
    private Integer age;
    private String address;
    private String phoneNo;
}
