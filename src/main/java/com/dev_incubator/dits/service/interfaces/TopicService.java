package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.service.dto.TopicDto;

import java.util.List;

public interface TopicService {

    List<TopicDto> getAllTopics();

    TopicDto getTopicById(Long id);

    void deleteTopicById(Long id);

    boolean saveTopic(TopicDto topicDto);
}
