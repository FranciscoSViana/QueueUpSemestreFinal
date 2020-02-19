package com.queueup.queueup.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	String host = "queueup.database.windows.net";      //URL do database
    String name = "queueup";                           //Nome do banco de dados
    String user = "queueupadmin";                      //User do banco de dados 
    String password = "Bandtec1";                      //Senha do banco de dados

    String url = String.format("jdbc:sqlserver://%s:1433;"
            + "database=%s;"
            + "user=%s;"
            + "password=%s;"
            + "encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;",
            host, name, user, password);

    Connection connection = null;
    
    public Connection getConnection() {
        /*@try: tenta conectar ao banco usando jdbc junto da url
          @catch: Caso não consiga, vai retornar um erro */
        try {
            connection = (Connection) DriverManager.getConnection(url);
            System.out.println("Successful connection!");
            
        } catch (SQLException e) {
            System.out.println("Connection error");
            throw new RuntimeException(e);

        }
        return connection;
    }
}
