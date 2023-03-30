package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user_name = "postgres";
    private static final String password = "00001";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, user_name, password);
            System.out.println("Connection to the postgresql successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public static void creatCountry() {
        String SQL_Country = "CREATE TABLE countries(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "capital_city VARCHAR(50) NOT NULL," +
                "president VARCHAR(50) NOT NULL," +
                "language VARCHAR(50) NOT NULL," +
                "population INTEGER);";
        try (Connection connection = DataBase.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_Country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void creatCity() {
        String SQL_City = "CREATE TABLE cities(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(80) NOT NULL," +
                "mayor VARCHAR(80) NOT NULL," +
                "population_city INTEGER);";
        try (Connection connection = DataBase.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_City);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void creatMayor() {
        String SQL_Mayor = "CREATE TABLE mayors(" +
                "id SERIAL PRIMARY KEY," +
                "first_name VARCHAR(80) NOT NULL," +
                "last_name VARCHAR(80) NOT NULL," +
                "age INTEGER);";
        try (Connection connection = DataBase.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_Mayor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCountry(String name, String capital_city, String president,
                                  String language, int population) {
        String SQL_Country2 = "INSERT INTO countries (name, capital_city, president, language, population)" +
                "VALUES (?,?,?,?,?)";
        try (Connection con = connection();
             PreparedStatement statement = con.prepareStatement(SQL_Country2)) {
            statement.setString(1, name);
            statement.setString(2, capital_city);
            statement.setString(3, president);
            statement.setString(4, language);
            statement.setInt(5, population);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCity(String name, String mayor, int population_city){
        String SQL_City2 = "INSERT INTO cities(name, mayor, population_city)"+
                "VALUES (?,?,?)";
        try (Connection con = connection();
        PreparedStatement statement = con.prepareStatement(SQL_City2)){
            statement.setString(1,name);
            statement.setString(2,mayor);
            statement.setInt(3,population_city);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addMayor(String first_name, String last_name, int age){
        String SQL_Mayor2 = "INSERT INTO mayors(first_name, last_name, age)"+
                "VALUES (?,?,?)";
        try (Connection con = DataBase.connection();
        PreparedStatement statement = con.prepareStatement(SQL_Mayor2)){
            statement.setString(1,first_name);
            statement.setString(2,last_name);
            statement.setInt(3,age);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static java.util.List<Country> getListCountry(){
        String SQL_listCountry = "SELECT * FROM countries";
        List<Country> countries = new ArrayList<>();
        try(Connection connection = DataBase.connection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL_listCountry);
            while(resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCapital_city(resultSet.getString("Capital_city"));
                country.setPresident(resultSet.getString("President"));
                country.setLanguage(resultSet.getString("Language"));
                country.setPopulation(resultSet.getInt("Population"));
                countries.add(country);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return countries;
    }

    public static List<City> getListCities(){
        String SQL_listCity = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        try(Connection connection = connection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL_listCity);
            while(resultSet.next()){
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setMayor(resultSet.getString("Mayor"));
                city.setPopulation_city(resultSet.getInt("Population_city"));
                cities.add(city);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cities;
    }
    public static List<Mayor> getListMayor(){
        String SQL_listMayor = "SELECT * FROM mayors";
        List<Mayor> mayors = new ArrayList<>();
        try(Connection connection = connection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL_listMayor);
            while(resultSet.next()){
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setFirst_name(resultSet.getString("First_name"));
                mayor.setLast_name(resultSet.getString("Last_name"));
                mayor.setAge(resultSet.getInt("Age"));
                mayors.add(mayor);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return mayors;
    }

    public static void getCityId( int id) {
        String SQL = "SELECT * FROM cities WHERE id = " + id;
        try (Connection con = DataBase.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" name: " + resultSet.getString("name"));
                System.out.print(" mayor: " + resultSet.getString("mayor"));
                System.out.println(" population_city " + resultSet.getInt("population_city"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

