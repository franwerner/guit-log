package com.guitlog.guitlog.domain.model.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private LocalDateTime registrationDate;
    private int closingDay;
}
