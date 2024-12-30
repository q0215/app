package com.github.q0215.app.http

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun get(): String {
        return "Hello HTTP."
    }
}
