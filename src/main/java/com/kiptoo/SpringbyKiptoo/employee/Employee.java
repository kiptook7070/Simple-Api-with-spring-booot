package com.kiptoo.SpringbyKiptoo.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_employee"
)
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long empId;
    @Column(
            nullable = false,
            length = 40,
            columnDefinition = "TEXT"
    )
    private String empName;
    @Column(
            nullable = false,
            length = 6,
            columnDefinition = "TEXT"
    )
    private String empCode;
}
