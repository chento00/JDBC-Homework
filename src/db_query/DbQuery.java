package db_query;

import java.util.Arrays;

public class DbQuery {
    public String selectQuery(String table) {
        return "SELECT *FROM " + table+" ORDER BY id ASC";
    }
    public String insertQuery(String table,String ...value){
        String labell="";
        String temp=null;
        for(String val:value){
            labell+=val;
            temp+="?";
        }
        return "INSERT INTO "+table+" (id,"+labell+") VALUES(default,"+temp+")";
    }
}
