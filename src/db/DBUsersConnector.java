package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.City;
import models.Street;
import models.User;

public class DBUsersConnector {

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/g114-JavaEE-JDBC",
          "postgres",
          "postgres");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<User> getUsers() {
    List<User> users = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select u.id, u.full_name, u.age, c.id as city_id, c.name, c.code, "
              + "s.id as street_id,s.name as street_name, s.index from users u "
              + "inner join cities c on u.city_id = c.id "
              + "inner join streets s on c.street_id = s.id");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFullName(resultSet.getString("full_name"));
        user.setAge(resultSet.getInt("age"));

        City city = new City();
        city.setId(resultSet.getLong("city_id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));

        Street street = new Street();
        street.setId(resultSet.getLong("street_id"));
        street.setName(resultSet.getString("street_name"));
        street.setIndex(resultSet.getString("index"));

        city.setStreet(street);

        user.setCity(city);
        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }
}
