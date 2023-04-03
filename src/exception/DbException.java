package exception;


import connection.JdbcImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbException {
    public ResultSet handleResultSet(JdbcImp connection, String query){
        try{
            PreparedStatement statement= connection.dataSource().getConnection().prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            return resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Integer getIntegerValue(String label, Scanner scanner){
        do {
            try {
                System.out.print(label);
                String name= scanner.nextLine();
                return Integer.parseInt(name);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
}
