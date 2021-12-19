package com.ilya.test.mydemoproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */
@Component
@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String name;
    private int year;
}
