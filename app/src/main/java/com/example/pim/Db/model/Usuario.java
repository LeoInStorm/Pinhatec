package com.example.pim.Db.model;

public class Usuario {
    private Integer id_funcionario;
    private String usuario;
    private String senha;


    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getusuario() { return usuario; }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }
}
