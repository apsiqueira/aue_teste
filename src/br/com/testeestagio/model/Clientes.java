/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testeestagio.model;

import java.util.Date;

/**
 *
 * @author PabloVirtual
 */
public class Clientes {

    protected int codContato;
    private String nome;
    private String sexo;
    private Date data;
    private String Cidade;

    public int getCodContato() {
        return codContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setCodContato(int codContato) {
        this.codContato = codContato;
    }

}
