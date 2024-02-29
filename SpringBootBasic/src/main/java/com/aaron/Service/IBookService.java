package com.aaron.Service;

import com.aaron.pojo.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage, int pageSize);
}
