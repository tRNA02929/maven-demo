package org.example;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private int student_id;
}
