// package com.book.servlet;

// import java.io.IOException;

// import org.apache.ibatis.session.SqlSession;

// import com.book.entity.User;
// import com.book.mapper.UserMapper;
// import com.book.utils.MybatisUtil;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         SqlSession session = MybatisUtil.getSession(true);
//         UserMapper usermapper = session.getMapper(UserMapper.class);
//         User user = usermapper.getUser("admin", "123456");
//         System.out.println(user);
//     }
// }
