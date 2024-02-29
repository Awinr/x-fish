package com.aaron.controller;


import com.aaron.Service.IBookService;
import com.aaron.authcheck.AuthCheck;
import com.aaron.designPattern.PayChannelEnum;
import com.aaron.designPattern.PayFactory;
import com.aaron.designPattern.PayHandler;
import com.aaron.pojo.Book;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    private PayFactory payFactory;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Integer id) {
        PayHandler payHandler = payFactory.getPayHandler(PayChannelEnum.BANK_PAY);
        payHandler.pay();
        Book book = new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setDescription("四大名著之一");
        book.setType("小说");
        return book;
    }


    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean updateById(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return bookService.removeById(id);
    }
    @DeleteMapping
    public Boolean deleteAll() {
        return bookService.remove(null);
    }
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return bookService.getPage(currentPage, pageSize);
    }
    @GetMapping("aop")
    @AuthCheck(role = "admin")
    public String serviceExecute() {
        System.out.println("开始执行业务。");
        return "业务执行成功！";
    }
}
