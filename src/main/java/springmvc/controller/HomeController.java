package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/first")
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("This is home url");
        model.addAttribute("name", "Rohit Kumar");
        List<String> friends = new ArrayList<String>();
        friends.add("Thomas");
        friends.add("Newton");
        friends.add("Law");
        model.addAttribute("f", friends);
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("This is about url");
        return "about";
    }
    @RequestMapping("/help")
    public ModelAndView help(){
        System.out.println("This is help url");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Rohit Kumar");
        modelAndView.addObject("rollNumber", 123456);
        LocalDateTime now = LocalDateTime.now();
        modelAndView.addObject("time", now);
        modelAndView.setViewName("help");
        return modelAndView;
    }
    @RequestMapping("/contact")
    public ModelAndView contact(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Rohit Kumar Singh");
        modelAndView.addObject("phone", "+919876543210");
        modelAndView.setViewName("contact");
        List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(24);
        list.add(36);
        list.add(48);
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
