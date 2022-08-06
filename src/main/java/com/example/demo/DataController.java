package com.example.demo;

import com.example.demo.model.DataDto;
import com.example.demo.model.DataVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RequestMapping("/data")
@Controller
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = true, defaultValue = "1") Long id, Model model){
        DataVo vo = dataService.search(id);
        model.addAttribute("vo", vo.getCol1());

        return "data";
    }

}
