
package com.klu.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dept")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String deptName;
  
  //One Dept -> Many Employees
  //cascade -> useful to perform updatable operations on its(dept's) child.
  //CascadeTypes are different types:1. ALL 2. DETATCH 3. REFRESH 4. PERSIST 5. MERGE 6. REMOVE
  //here fetchType must be LAZY because when I load dept I don't want to load emp automatically
  @OneToMany(mappedBy = "department", 
         cascade = CascadeType.ALL, 
         fetch = FetchType.LAZY)
  private List<Employee> employees;
}