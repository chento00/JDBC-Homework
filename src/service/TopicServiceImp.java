package service;

import model.Topic;
import repository.TopicRepository;
import java.util.List;
import java.util.Scanner;

public class TopicServiceImp implements TopicService{
    private final TopicRepository topicRepository;

    public TopicServiceImp() {
        this.topicRepository = new TopicRepository();
    }

    public List<Topic> selectTopic() {
        return topicRepository.selectTopic();
    }

    public void insertTopic(Scanner scanner) {
        topicRepository.insertTopic(scanner);
    }

    public void updateTopicById(Integer id, Scanner scanner) {
        topicRepository.updateTopicById(id, scanner);
    }

    public Integer searchById(Integer id) {
        return topicRepository.searchById(id);
    }

    public void deleteTopicById(Integer id) {
        topicRepository.deleteTopicById(id);
    }

    public List<Topic> getTopicByName(String name) {
        return topicRepository.getTopicByName(name);
    }

    public Topic searchTopicById(Integer id) {
        return topicRepository.searchTopicById(id);
    }
}
