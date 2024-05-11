package com.book.entity;

import lombok.Data;

@Data
public class Students {
    int sid;
    String name;
    String gender;
    String phoneNumber;
    String department;
    int borrowTimes;
}
