package ccc.springboot.coconut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VirusInfo {
    @RequestMapping("/test")
    public String virusStats() {
        return "home";
    }
}
