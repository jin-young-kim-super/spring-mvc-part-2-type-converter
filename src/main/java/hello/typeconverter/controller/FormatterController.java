package hello.typeconverter.controller;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {

        Form form = new Form();
        form.setNumber(100000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form",form);
        return "/formatter-form";

    }

    @PostMapping("/formatter/edit")
    // @ModelAttribute : 자동으로 Model에 데이터를 담아 준다는 것을 상기
    public String formatterEdit(@ModelAttribute Form form) {
        return "/formatter-view";
    }


    @Data
    static class Form {
        // "100,000" -> 100000(Integer)
        @NumberFormat(pattern = "###,###")
        private Integer number;

        // "2026.02.2T12:30" -> 2026.02.24 12:30(LocalDateTime)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }


}
