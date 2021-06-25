package com.crudHtml.MysqlSpringHtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private Services service;


    @RequestMapping(path = "viewAll")
    public String getAll(Model model){

        List<User> userList = service.getAllUsers();
        model.addAttribute("userList",userList);

        return "all";
    }

    @RequestMapping(path = "add")
    public String addUser(Model model){

        User u = new User();
        model.addAttribute("user",u);
        return "addForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User u){

       service.addUser(u);
        return "redirect:/viewAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/viewAll";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        User user = service.get(id);
        mav.addObject("user", user);
        return mav;
    }

}
