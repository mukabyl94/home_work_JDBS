package org.example;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {



//        for (Country country : DataBase.getListCountry()) {
//            System.out.println(country);
//        }

//        for (City city : DataBase.getListCities()) {
//            System.out.println(city);
//        }

//        for (Mayor mayor : DataBase.getListMayor()) {
//            System.out.println(mayor);
//        }

        DataBase.getCityId(1);


    }


}
