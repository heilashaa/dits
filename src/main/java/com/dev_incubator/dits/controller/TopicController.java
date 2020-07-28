package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.service.dto.TopicDto;
import com.dev_incubator.dits.service.interfaces.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/topics")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAllTopics(Model model) {
        model.addAttribute("listTopics", topicService.getAllTopics());
        model.addAttribute("topic", new TopicDto());
        return "topic";
    }
}
