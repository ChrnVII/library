package com.book.service;

import java.io.IOException;
import java.util.List;

import com.book.entity.Borrow;

import com.book.mapper.BorrowMapper;

import com.book.utils.MybatisUtil;

public class BorrowService {
    BorrowMapper mapper;
    public BorrowService() throws IOException {
        mapper = MybatisUtil.getSession(true).getMapper(BorrowMapper.class);

    }
    public List<Borrow> getBorrowList(){
        return mapper.getBorrowList();
    }

    public void addBorrow(int sid, int bid) {
        mapper.insert(sid, bid);
    }

    public void deleteBorrow(int id){
        mapper.delete(id);
    }
}
