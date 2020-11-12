package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController("/api/phonenumber")
class Controller(var service: Service) {

    @PostMapping
    fun save(@Valid @RequestBody form: PhoneNumberForm) {
        return service.save(form)
    }

    @GetMapping
    fun getAll(): List<View> {
        return service.getAll()
    }

    @GetMapping("/{ddd}")
    fun getUsingDDD(@PathVariable("ddd") ddd: Int): View {
        return service.findByDDD(ddd)
    }
}