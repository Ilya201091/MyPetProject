package com.ilya.test.mydemoproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * @author Shaporto Ilya
 * @date 16.12.2021
 */
@Data
@Entity
@Table(name = "my_users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",unique = true,nullable = false, length = 25)
    private String userName;

    @Column(name = "name", nullable = false,length = 25)
    private String name;

    @Column(name = "year", nullable = false, columnDefinition = "int CHECK (year > 0 AND year < 110)")
    private int year;

    /*@Column(name = "local_date")
    private LocalDate localDate;*/

    @Column(name = "password",nullable = false)
    private String password;



}
