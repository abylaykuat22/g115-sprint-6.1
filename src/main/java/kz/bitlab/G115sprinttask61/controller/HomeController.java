package kz.bitlab.G115sprinttask61.controller;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.ApplicationRequest;
import kz.bitlab.G115sprinttask61.service.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @Autowired
  private ApplicationRequestService appReqService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<ApplicationRequest> appRequests = appReqService.getAppRequests();
    model.addAttribute("zayavki", appRequests);
    return "home";
  }

  @PostMapping("/add-app-req")
  public String addAppReq(ApplicationRequest appReq) {
    appReqService.addAppReq(appReq);
    return "redirect:/";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model) {
    ApplicationRequest appReq = appReqService.getAppReqById(id);
    model.addAttribute("zayavka", appReq);
    return "details";
  }
}
