package com.fatimacarneiro.estudokotlin.telephonenumber

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/telephonenumber")
class Controller(var service: Service) {

    @PostMapping("/add")
    fun add(@RequestBody form: TelephoneNumberForm) {
        return service.add(form)
    }
}