package com.example.Tome

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Books {

   @GetMapping("/books")
   fun getBookss(): List<Books>{
        return List();
    }
}