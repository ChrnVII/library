package com.book.entity;

import lombok.Data;

@Data
public class Borrow {
    int id;
    int sid;
    String sname;
    int bid;
    String bname;
    String borrowDate;
    int limitDays;
}
