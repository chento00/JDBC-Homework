package view;

import controler.TopicController;
import exception.DbException;

import java.util.Scanner;

public class WelcomeView {
    private final TopicController topicController;

    public WelcomeView() {
        this.topicController = new TopicController();
    }

    public static void showMenu(){
        System.out.println("================[MENU]===================");
        System.out.println("1. Select Topic");
        System.out.println("2. Insert Topic");
        System.out.println("3. Update Topic By ID");
        System.out.println("4. Delete Topic By ID");
        System.out.println("5. Select Topic By Name");
    }
    public  void ShowWelcome(){
        Scanner scanner=new Scanner(System.in);
        ViewTopic viewTopic=new ViewTopic();
        do {
            showMenu();
            Integer opt= DbException.getIntegerValue("Choose one option : ",new Scanner(System.in));
            switch (opt){
                case 1:{
                    System.out.println(viewTopic.viewTopic().render());;
                }break;
                case 2:{
                    topicController.insertTopic(new Scanner(System.in));
                }break;
                case 3:{
                    Integer topicId=DbException.getIntegerValue("Enter ID To Search For Update : ",new Scanner(System.in));
                    topicController.updateTopicById(topicId,new Scanner(System.in));
                }break;
                case 4:{
                    Integer topicId=DbException.getIntegerValue("Enter ID To Search For Delete : ",new Scanner(System.in));
                    topicController.deleteTopicById(topicId);
                }break;
                case 5:{
                    System.out.print("Enter Name to search : ");
                    String name=scanner.nextLine();
                    System.out.println(viewTopic.viewTopicByName(name).render());
                }break;
            }
        }while (true);
    }
}
