package com.qianfeng.manager.security.dao;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface BookDao {
    List<Books> getAllBooks();

    void deleteById(String id);
}
