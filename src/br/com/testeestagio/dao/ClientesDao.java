/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testeestagio.dao;

import br.com.testeestagio.jdbc.ConnectionFactory;
import br.com.testeestagio.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PabloVirtual
 */
public class ClientesDao {
        private Connection con;

    public ClientesDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void salvarCliente(Clientes obj) {
        try {
            //passo 1:criar comando sql
            String sql = "insert into tb_aue_contatos(nome,sexo,cidade) "+ "values(?,?,?)";

            //passo 2:conectar ao banco e organizar o comando sql
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSexo());
            pst.setString(3, obj.getCidade());
            //comando 3executar comando sql
            pst.execute();
            pst.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException erroSql) {
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente!" + erroSql);

        }
    }

  
    
    
   
    
    public List<Clientes> listarClientes(){

        try {
            //criação da lista 
            List<Clientes> lista = new ArrayList<>();

            //criar comando sql, organizar e executar
            String sql = "select * from tb_aue_contatos";
            PreparedStatement pst = con.prepareStatement(sql);

            //quando se faz um selec no bunacop temos que armazenar em um objeto do tipo resultset
            ResultSet rst = pst.executeQuery();

            //pegar resultados do resultset percorrendo todos os campos  retornado
            while (rst.next()) {

                //criando objeto cliente para receber os valores , objj recebe o valor com o nome do campo do banco
                Clientes obj = new Clientes();
               
                
                obj.setCodContato(rst.getInt("codContato"));
                obj.setNome(rst.getString("nome"));
                obj.setSexo(rst.getString("sexo"));
                obj.setCidade(rst.getString("cidade"));
                

                //adicionar o objeto na lista 
                lista.add(obj);

            }

            //retorna a lista 
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    
    
    }
    public void excluirCliente(Clientes obj) {
        //criar o sql

        try {
            //passo 1:criar comando sql
            String sql = "delete from tb_aue_contatos where codContato=?";

            //passo 2:conectar ao banco e organizar o comando sql
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, obj.getCodContato());
            System.out.println(obj.getCodContato());

            //comando 3executar comando sql
            pst.execute();
            pst.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");

        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Cliente!" + erroSql);

        }
    }
    public void alterarCliente(Clientes obj) {
        try {
            //passo 1:criar comando sql
            String sql = "update tb_aue_contatos set nome=?,sexo=?,cidade=? where codContato=?";

            //passo 2:conectar ao banco e organizar o comando sql
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSexo());
            pst.setString(3, obj.getCidade());
            pst.setInt(4, obj.getCodContato());
            

            //comando 3executar comando sql
            pst.execute();
            pst.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Cliente!" + erroSql);

        }

    }
}
