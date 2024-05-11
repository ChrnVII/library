package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.book.entity.Borrow;

public interface BorrowMapper {
    // id, students.sid, students.name, books.bid, books.name, borrowDate
    
    @Select("select id, students.sid sid, students.name sname, books.bid bid, books.name bname, borrowDate, limitDays from students join borrow on students.sid = borrow.sid join books on borrow.bid = books.bid order by id desc")
    // @Results({
    //         @Result(column = "id", property = "id"),
    //         @Result(column = "`borrow`.`sid`", property = "sid"),
    //         @Result(column = "students.name", property = "sname"),
    //         @Result(column = "borrow.bid", property = "bid"),
    //         @Result(column = "books.name", property = "bname"),
    //         @Result(column = "borrowDate", property = "borrowDate"),
    //         @Result(column = "limit", property = "limit")

    // })
    List<Borrow> getBorrowList();

    @Insert("INSERT INTO borrow(sid,bid) VALUES(#{sid}, #{bid})")
    void insert(@Param("sid") int sid, @Param("bid") int bid);

    @Delete("Delete from borrow where id=#{id}")
    void delete(@Param("id") int id);
}
