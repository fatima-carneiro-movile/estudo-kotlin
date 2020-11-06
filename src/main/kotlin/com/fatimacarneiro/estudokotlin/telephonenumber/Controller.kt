package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/api/telephonenumber")
class Controller(var service: Service) {

    @PostMapping("/save")
    fun save(@Valid @RequestBody form: PhoneNumberForm) {
        return service.save(form)
    }
}