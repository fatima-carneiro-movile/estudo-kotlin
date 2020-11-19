package com.fatimacarneiro.estudokotlin.phonenumber

import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/phonenumber")
class PhoneNumberController(
        var service: PhoneNumberService
) {

    @PostMapping
    fun save(@Valid @RequestBody form: PhoneNumberForm) {
        return service.save(form)
    }

    @GetMapping
    fun getAll(): List<PhoneNumberView> {
        return service.getAll()
    }

    @GetMapping("/{ddd}")
    fun getUsingDDD(@PathVariable("ddd") ddd: Int): PhoneNumberView {
        return service.findByDDD(ddd)
    }
}