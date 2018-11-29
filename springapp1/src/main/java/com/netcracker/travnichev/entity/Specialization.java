package com.netcracker.travnichev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "specialization")
@Scope(value = "prototype")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Student> studentList;

    public Specialization(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = new ArrayList<>(studentList.size());
        this.studentList.addAll(studentList);
    }
}

