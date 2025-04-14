package com.tour_travel.tour_management.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

//    @GetMapping("/my_booking")
//    public String mybookingPage(Model model)
//    {
//        String username= (String) model.getAttribute("username");
//       // System.out.println(username);
//        //if(username != null)
//            return "my_booking";
//        //else
//           // return "login";
//    }

    @GetMapping("/contact_us")
    public String contact_usPage() {
        return "contact_us";
    }

    @GetMapping("/img")
    public  String showImg() {
        return "img";
    }
}
