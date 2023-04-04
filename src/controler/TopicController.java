package controler;

import model.Topic;
import service.TopicServiceImp;
import java.util.List;
import java.util.Scanner;

public class TopicController {
    private final TopicServiceImp topicService;

    public TopicController() {
        this.topicService = new TopicServiceImp();
    }
    public List<Topic> getAllTopic(){
        return  topicService.selectTopic();
    }
    public void insertTopic(Scanner scanner){
        topicService.insertTopic( scanner);
    }
    public void updateTopicById(Integer id,Scanner scanner){
        topicService.updateTopicById(id,scanner);
    }
    public void deleteTopicById(Integer id){
        topicService.deleteTopicById(id);
    }
    public List<Topic> getTopicByName(String name){
        return topicService.getTopicByName(name);
    }
    public Topic searchTopicById(Integer id){
        return topicService.searchTopicById(id);
    }
}
