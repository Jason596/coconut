package ccc.springboot.coconut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VirusInfo {
    @RequestMapping("/covid19")
    public String virusStats(Model model) {
    model.addAttribute("testName", "test");
        return "home";
    }
}
