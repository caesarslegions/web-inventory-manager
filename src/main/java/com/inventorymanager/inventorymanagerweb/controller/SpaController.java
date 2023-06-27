package com.inventorymanager.inventorymanagerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    @RequestMapping({"/", "/otherPath/**"})
    public String forwardSpa() {
        return "forward:/index.html";
    }
}
