package repository;

import model.Topic;

import java.sql.SQLException;
import java.util.*;
public interface TopicRepository {
     List<Topic> selectTopic() throws SQLException;
     void insertTopic(Scanner scanner);
     void updateTopicById(Integer id , Scanner scanner);
     Integer searchById(Integer id);
     void deleteTopicById(Integer id);
     List<Topic> getTopicByName(String name);
     Topic searchTopicById(Integer id);
}
