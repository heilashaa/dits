package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.repository.TopicRepository;
import com.dev_incubator.dits.service.dto.TopicDto;
import com.dev_incubator.dits.service.dto.mapper.TopicMapper;
import com.dev_incubator.dits.service.interfaces.TopicService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@Transactional
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    private final TopicMapper topicMapper;

    @Override
    public List<TopicDto> getAllTopics(){
        return topicRepository.findAll().stream().map(topicMapper::toDto).collect(Collectors.toList());
    }
}
