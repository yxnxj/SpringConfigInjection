package com.example.demo;

import com.example.demo.model.DataDto;
import com.example.demo.model.DataForm;
import com.example.demo.model.DataVo;
import org.mariadb.jdbc.plugin.codec.LocalDateTimeCodec;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        DataDto dataDto1 = DataDto.builder()
                .col1("col1")
                .uuid(UUID.randomUUID())
                .build();

        DataDto dataDto2 = DataDto.builder()
                .col1("col2")
                .uuid(UUID.randomUUID())
                .build();

        DataDto dataDto3 = DataDto.builder()
                .col1("col3")
                .uuid(UUID.randomUUID())
                .build();

        DataForm dataForm = new DataForm();
        List<DataDto> dtoList = new ArrayList<>();
        dtoList.add(dataDto1);
        dtoList.add(dataDto2);
        dtoList.add(dataDto3);
        dataForm.setDtoList(dtoList);


        model.addAttribute("dataForm", dataForm);

        model.addAttribute("vo", vo.getCol1());

        return "data";
    }

    @PostMapping("/mark")
    public String mark(@RequestBody DataForm dataForm, Model model){
        List<DataDto> dtoList = dataForm.getDtoList();

        System.out.println(dtoList.size());

        return "redirect::";
    }

}
