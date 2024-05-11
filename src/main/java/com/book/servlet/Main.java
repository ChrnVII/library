// package com.book.servlet;

// import java.io.IOException;
// import java.sql.SQLIntegrityConstraintViolationException;
// import java.util.List;

// import org.apache.ibatis.exceptions.PersistenceException;
// import org.apache.ibatis.session.SqlSession;

// import com.book.entity.Borrow;
// import com.book.mapper.BorrowMapper;

// import com.book.utils.MybatisUtil;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         SqlSession session = MybatisUtil.getSession(true);
//         BorrowMapper mapper = session.getMapper(BorrowMapper.class);
//         try{
//             mapper.insert(2, 2);
//         }catch(PersistenceException e){
//             if(e.getCause().toString().contains("SQLIntegrityConstraintViolationException")){
//                 System.out.println("添加失败, 书籍已借出");
//             } else {
//                 System.out.println("添加失败, 书籍号或学号不存在");
//             }
//         }
        
//         List<Borrow> list = mapper.getBorrowList();
//         list.forEach(System.out::println);
        
//     }
// }
