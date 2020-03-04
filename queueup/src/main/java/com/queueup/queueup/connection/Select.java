package com.queueup.queueup.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Select {
	
	Connection connection = new Conexao().getConnection();

    //imprime o nome de todos os usuarios
    public void getUsers() throws InterruptedException, SQLException {

        try {

            String sh;
            sh = connection.getSchema();
            System.out.println("Successful connection: " + sh);

            // seleciona todos os users
            String selectSql = "SELECT * FROM Usuario";
            
            
            // preparando query
            PreparedStatement st;
            st = connection.prepareStatement(selectSql);

            try (ResultSet resultSet = st.executeQuery();) {

                //loop de registros
                while (resultSet.next()) {

          // Aqui está pegando o campo 2 da tabela 
                    // no caso o campo 2 é String, então fica resultSet.getString(2). Se fosse int, seria resultSet.getInt(2) e etc.
                    System.out.println("=================");
                    System.out.println("idUsuario: " + resultSet.getInt(1));

                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("erro" + e);
        }

    }

/*    public int getIDMaquina(Cpu cpu) throws InterruptedException, SQLException {

        int id = 0;
        try {

            String sh;
            sh = connection.getSchema();
            System.out.println("Successful connection: " + sh);
            String selectSql = "SELECT ID_MAQU_CD_MAQUINA from NW_CD_TB_MAQUINA_MAQU where MAQU_NU_IP = " + "'" + cpu.getIpMaq() + "'";
            PreparedStatement st;
            st = connection.prepareStatement(selectSql);

            try (ResultSet resultSet = st.executeQuery();) {

                //loop de registros
                while (resultSet.next()) {
                    id = resultSet.getInt(1);
                    System.out.println("ID CLASSE SELECT: " + id);
                }
                connection.close();
                return id;
            }
        } catch (SQLException e) {
            System.out.println("erro: " + e);
            return 0;
        }
*/
    }
	
	
