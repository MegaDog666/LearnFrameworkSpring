package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "/first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int firstValue,
                                 @RequestParam(value = "b", required = false) int secondValue,
                                 @RequestParam(value = "operation", required = false) String operation,
                                 Model model) {
        // Хотел вот таким хитрым и интересным способом сделать, причем почти получилось кроме одного но, я не могу сделать этап сложения
        // Просто потому что получая гет запрос в командной строке в виде =+ почему он не видит этот + и игнорирует его, делая строку пустой
        // Ну и в итоге думаю как по видео стоит делать, не столь замудренно как я
//        try {
//            switch (operation) {
//                case "+" -> model.addAttribute("result", Integer.parseInt(firstValue) + Integer.parseInt(secondValue));
//                case "-" -> model.addAttribute("result", Integer.parseInt(firstValue) - Integer.parseInt(secondValue));
//                case "*" -> model.addAttribute("result", Integer.parseInt(firstValue) * Integer.parseInt(secondValue));
//                case "/" -> model.addAttribute("result", Integer.parseInt(firstValue) / Integer.parseInt(secondValue));
//                default -> model.addAttribute("result", 0);
//            }
//        } catch (NullPointerException e) {
//            model.addAttribute("result", 0);
//        }

        double resoult = 0;
        switch (operation) {
            case "addition" -> resoult = firstValue + secondValue;
            case "subtraction" -> resoult = firstValue - secondValue;
            case "multiplication" -> resoult = firstValue * secondValue;
            case "division" -> resoult = (double) firstValue / secondValue;
            default -> resoult = 0;
        }

        model.addAttribute("result", resoult);
        return "/first/calculator";
    }
}
