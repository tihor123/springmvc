package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

//    @ModelAttribute
//    public void commonDataForModel(Model model){
//        model.addAttribute("title", "Registration Form");
//        model.addAttribute("desc", "This is just a demo");
//        System.out.println("Adding common data to model");
//    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/form2")
    public String form2() {
        return "form2";
    }

    @RequestMapping(path = "/processForm", method = RequestMethod.POST)
    public String handleForm(@RequestParam(value = "email", required = true) String email,
                             @RequestParam("userName") String userName,
                             @RequestParam("password") String password, Model model) {
        System.out.println(email + " " + userName + " " + password);
        model.addAttribute("email", email);
        model.addAttribute("name", userName);
        model.addAttribute("password", password);
        return "success";
    }

    @RequestMapping(path = "/processForm2", method = RequestMethod.POST)
    public String handleForm2(@RequestParam(value = "email", required = true) String email,
                              @RequestParam("userName") String userName,
                              @RequestParam("password") String password, Model model) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        model.addAttribute("user", user);
        return "success2";
    }

    @RequestMapping("/form3")
    public String form3(Model model, @ModelAttribute("nameError") String nameError) {
        System.out.println("creating form" + nameError);
        model.addAttribute("nameError", nameError);
//        model.addAttribute("desc", "This is just a demo");
        return "form3";
    }

    @RequestMapping(path = "/processForm3", method = RequestMethod.POST)
    public String handleForm3(@ModelAttribute User user, Model model, RedirectAttributes attributes) {
        boolean error = false;
        if(user.getUserName().isEmpty()){
            error = true;
            attributes.addAttribute("nameError", "Please provide a valid user name");
        }
        if(user.getEmail().isEmpty()){
            error = true;
            attributes.addAttribute("emailError", "Please provide a valid email");
        }
        if(user.getPassword().isEmpty()){
            error = true;
            attributes.addAttribute("pError", "Please provide a valid password");
        }
        if(error){
            return "redirect:/form3";
        }
        System.out.println("handling form");
        System.out.println(user);
        int id = this.userService.createUser(user);
        model.addAttribute("msg", "User created successfully with id " + id);
        return "success3";
    }
}
