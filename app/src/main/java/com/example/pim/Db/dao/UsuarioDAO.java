package com.example.pim.Db.dao;

import com.example.pim.Db.Conexao.Conexao;
import com.example.pim.Db.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public Usuario selecionaUsuario(String usuario, String senha){

        try {
            Connection conn = Conexao.conectar();
            if(conn != null){
            String sql = "select * from TBfuncionario where usuario = '"+usuario+"' and senha ='"+senha+"'";
                Statement st = null;
                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Usuario usu = new Usuario();
                    usu.setId_funcionario(rs.getInt(1));
                    usu.setusuario(rs.getString(2));
                    usu.setsenha(rs.getString(3));

                    conn.close();
                    return usu;


                }
            }
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return null;
    }
}
