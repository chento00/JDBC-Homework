package service;

import model.Topic;
import repository.TopicRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface TopicService {
    List<Topic> selectTopic() throws SQLException;
    void insertTopic(Scanner scanner);
    void updateTopicById(Integer id , Scanner scanner);
    Integer searchById(Integer id);
    void deleteTopicById(Integer id);
    List<Topic> getTopicByName(String name);
    Topic searchTopicById(Integer id);
}
