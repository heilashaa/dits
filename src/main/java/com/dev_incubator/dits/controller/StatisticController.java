package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.service.interfaces.StatisticService;
import com.dev_incubator.dits.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/statistic")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping(value = "/by-tests")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getStatisticByTests(Model model) {
        model.addAttribute("listStatistic", statisticService.getStatisticByTests());
        model.addAttribute("statisticType", "by-tests");
        return "statistic";
    }

    @GetMapping(value = "/by-questions")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getStatisticByQuestions(Model model) {
        model.addAttribute("listStatistic", statisticService.getStatisticByQuestions());
        model.addAttribute("statisticType", "by-questions");
        return "statistic";
    }
}
