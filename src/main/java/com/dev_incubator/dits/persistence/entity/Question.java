//package com.dev_incubator.dits.persistence.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String description;
//    @ManyToOne
//    private Set<Answer> answers = new HashSet<>();
//    @OneToMany
//    private Test test;
//    @ManyToOne
//    private Set<Literature> literatures = new HashSet<>();
//}
