
package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp1")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long empId;
  private String empName;
  private String email;
  private String desig;
  
  //Many Employees -> One Department
  //Here EAGER will be loaded dept details automatically when emp loaded.
  @ManyToOne(fetch = FetchType.EAGER)
  //to create foreign key column in emp1 table with specific name
  @JoinColumn(name = "dept_id") 
  private Department department;

  public Department getDepartment() {
	return department;
  }

  public void setDepartment(Department department) {
	this.department = department;
  }
}