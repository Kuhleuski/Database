package program;

import java.sql.*;

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
            statement.addBatch("insert into car (name, price, id_engine, color, id_wheel) values ('LADA', '12000', 2,'red',3) ");
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


            } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}

