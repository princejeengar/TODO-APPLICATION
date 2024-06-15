package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.TodoDao;
import com.entities.Todo;



@Controller
public class HomeControl {

    //@Autowired
    //private ServletContext context;

    @Autowired
    TodoDao todoDao;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("page", "home");
        List<Todo> list = this.todoDao.getAll();
        model.addAttribute("todos", list);
        return "home";
    }

    @RequestMapping("/add")
    public String addTodo(Model model) {
        Todo t = new Todo();
        model.addAttribute("page", "add");
        model.addAttribute("todo", t);
        return "home";
    }

    @RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo t, Model model) {
        model.addAttribute("page", "home");
        t.setTodoDate(Date.valueOf(LocalDate.now()));
        this.todoDao.save(t);
        model.addAttribute("msg", "Successfully added.");
        return "home";
    }
}
