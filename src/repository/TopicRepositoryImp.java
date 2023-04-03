package repository;

import connection.JdbcImp;
import db_query.DbQuery;
import exception.DbException;
import model.Topic;
import util.InputUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopicRepositoryImp implements TopicRepository{

    private final JdbcImp connectionDB;
    private final DbException dbException;
    private DbQuery commandQuery;
    public TopicRepositoryImp() {
        connectionDB=new JdbcImp();
        dbException = new DbException();
        commandQuery=new DbQuery();
    }

    @Override
    public List<Topic> selectTopic() {
        try {
            PreparedStatement statement= connectionDB.dataSource().getConnection().prepareStatement(commandQuery.selectQuery("topics"));
            ResultSet resultSet=statement.executeQuery();
            List<Topic> topics=new ArrayList<>();
            while (resultSet.next()) {
                topics.add(new Topic(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("des"),
                        resultSet.getBoolean("status")
                ));
            }
            return topics;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void insertTopic(Scanner scanner) {
        try {
            System.out.print("Enter Name: ");
            String name=scanner.nextLine();
            System.out.print("Enter Description: ");
            String des=scanner.nextLine();
            String sql="INSERT INTO topics (name,des,status) VALUES(?,?,?)";
            PreparedStatement statement= connectionDB.dataSource().getConnection().prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,des);
            statement.setBoolean(3,true);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateTopicById(Integer id,Scanner scanner) {
        try {
            if(searchById(id).equals(1)){
                String sql="UPDATE topics SET name=?,des=?,status=? WHERE id=?";
                PreparedStatement statement=connectionDB.dataSource().getConnection().prepareStatement(sql);
                String name=InputUtils.inputText("Enter Name for Update : ",new Scanner(System.in));
                String des=InputUtils.inputText("Enter Description for Update : ",new Scanner(System.in));
                System.out.print("Enter a status  (true/false): ");
                boolean status = scanner.nextBoolean();
                statement.setString(1,name);
                statement.setString(2,des);
                statement.setBoolean(3,status);
                statement.setInt(4,id);
                statement.executeUpdate();
                System.out.println("Congratulation you update Success...");
            }else{
                System.out.println("Search not found");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Integer searchById(Integer id) {
        Integer count=null;
        try {

            String sql= """
                            SELECT COUNT(*) AS COUNT FROM topics WHERE id=?;
                        """;
            PreparedStatement statement=connectionDB.dataSource().getConnection().prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                count=resultSet.getInt("COUNT");
            }
            return count;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public void deleteTopicById(Integer id) {
        try {
            if(searchById(id).equals(1)){
                String sql="DELETE FROM topics WHERE id=?";
                PreparedStatement statement=connectionDB.dataSource().getConnection().prepareStatement(sql);
                statement.setInt(1,id);
                if(statement.executeUpdate()==1){
                    System.out.println("Delete Success ... ");
                }
            }else {
                System.out.println("ID search not found ...");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Topic> getTopicByName(String name) {
        try {
            String sql="SELECT * FROM topics WHERE name ILIKE '%' || ? || '%'";
            PreparedStatement statement= connectionDB.dataSource().getConnection().prepareStatement(sql);
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            List<Topic> topics=new ArrayList<>();
            while (resultSet.next()) {
                topics.add(
                    new Topic(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("des"),
                        resultSet.getBoolean("status")
                    )
                );
            }
            return topics;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
