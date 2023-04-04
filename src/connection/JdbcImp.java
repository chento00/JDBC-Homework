package connection;

import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;


public class JdbcImp {

    public JdbcImp() {}

    public DataSource dataSource(){
        PGSimpleDataSource dataSource=new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword(("chento"));
        dataSource.setDatabaseName("learning");
        dataSource.setPortNumbers(new int[]{5433});
        return dataSource;
    }
}
