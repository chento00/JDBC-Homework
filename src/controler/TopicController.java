package controler;

import model.Topic;
import repository.TopicRepositoryImp;
import java.util.List;
import java.util.Scanner;

public class TopicController {
    private final TopicRepositoryImp topicRepositoryImp;

    public TopicController() {
        this.topicRepositoryImp = new TopicRepositoryImp();
    }
    public List<Topic> getAllTopic(){
        return  topicRepositoryImp.selectTopic();
    }
    public void insertTopic(Scanner scanner){
        topicRepositoryImp.insertTopic( scanner);
    }
    public void updateTopicById(Integer id,Scanner scanner){
        topicRepositoryImp.updateTopicById(id,scanner);
    }
    public void deleteTopicById(Integer id){
        topicRepositoryImp.deleteTopicById(id);
    }
    public List<Topic> getTopicByName(String name){
        return topicRepositoryImp.getTopicByName(name);
    }
}
