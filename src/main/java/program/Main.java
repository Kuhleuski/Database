package program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;

        Consumer<Statement> update = (statement) -> {
            try {
                statement.executeUpdate("update car set name = 'okjghkjsdgbds' " +
                        "where id =4");
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        };

        update(update);


        try {
            conn = DriverManager.getConnection(JDBCUtils.getValue(JDBCUtils.URL_KEY),
                    JDBCUtils.getValue(JDBCUtils.USER_KEY),
                    JDBCUtils.getValue(JDBCUtils.PASSWORD_KEY));

//           DatabaseMetaData metadata = conn.getMetaData();
//           List tables = getTablesMetadata();
//           getColumnsMetadata(tables);
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();


            statement.executeUpdate("update car set name = 'klvnbkldflkn' " +
                    "where id =1");

            ResultSet resultSet = statement.executeQuery("select * from car");
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3) + " "
                        + resultSet.getDouble(4));

            }
            statement.addBatch("insert into car (name, price, id_engine, wheel_id) values ('LADA', 1559, 2,2) ");
            int[] updateCounts = statement.executeBatch();
            conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    // ------------ Не заработоло--------------
//    private static List getTablesMetadata() throws SQLException{
//        String table[] = {"TABLE"};
//        ResultSet rs = null;
//        rs = metadata.getTables(null,null,null, table);
//        List tables = new ArrayList();
//        while (rs.next()){
//            tables.add(rs.getString("TABLE_NAME"));
//        }
//        return tables;
//    }
//    private static void getColumnsMetadata(List<String> tables) throws SQLException{
//        ResultSet rs = null;
//        for (String actualTable : tables){
//            rs = metadata.getColumns(null, null, actualTable, null);
//            System.out.println(rs.getString("COLUMN_NAME") + " "
//            + rs.getString("TYPE_NAME") + " "
//            + rs.getString("COLUMN_SIZE"));
//        }
//    }
    private static void update(Consumer<Statement> update) {
        try  (Connection conn = DriverManager.getConnection(JDBCUtils.getValue(JDBCUtils.URL_KEY),
                    JDBCUtils.getValue(JDBCUtils.USER_KEY),
                    JDBCUtils.getValue(JDBCUtils.PASSWORD_KEY));
            Statement statement = conn.createStatement()) {
            conn.setAutoCommit(false);
            try {
                update.accept(statement);
                conn.commit();
            } catch (SQLException sqlException){
                conn.rollback();
            }

            update.accept(statement);
            //statement.executeUpdate(UPDATE_CAR_2);

            } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}

