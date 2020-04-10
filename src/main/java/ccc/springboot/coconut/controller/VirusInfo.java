package ccc.springboot.coconut.controller;

import ccc.springboot.coconut.model.entity.VirusStats;
import ccc.springboot.coconut.service.CovidVarius;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VirusInfo {

  private CovidVarius covidVarius;

  @Autowired
  public VirusInfo(CovidVarius covidVarius) {
    this.covidVarius = covidVarius;
  }

  @RequestMapping("/covid19")
  public String virusStats(Model model) {
    List<VirusStats> statsArray = covidVarius.getStatsArray();
    int totalCases = statsArray.stream().mapToInt(num -> num.getLastConfirmedNum()).sum();

    model.addAttribute("localVirusStats", statsArray);
    model.addAttribute("totalCases", totalCases);
    return "home";
  }
}
