package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexao.BancoConexao;
import Model.Tarefas;

public class Tarefadao {
	BancoConexao conn = new BancoConexao();
public void InserirTarefa(Tarefas tarefa) {
	String insert = "insert into lista (titulo , descricao , date_vencimento , prioridade) values (?, ?, ? , ?)";
	
	try {
		Connection con = conn.creaConnection();
		PreparedStatement pst = con.prepareStatement(insert);
		pst.setString(1, tarefa.getTitulo());
		pst.setString(2, tarefa.getDescricao());
		pst.setString(3, tarefa.getData());
		pst.setString(4, tarefa.getPrioridade());
		
		pst.executeUpdate();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}

public ArrayList<Tarefas> ListarTarefas(){
	String sel = "select*from lista";
	ArrayList<Tarefas> listar = new ArrayList<>();
	
	try {
		Connection con = conn.creaConnection();
		PreparedStatement pst = con.prepareStatement(sel);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String titulo = rs.getString(2);
			String descricao = rs.getString(3);
			String data = rs.getString(4);
			String prioridade = rs.getString(5);
			
	listar.add(new Tarefas(id , titulo , descricao , data , prioridade));		
			
		}
		
		con.close();
		return listar;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
}

public void select(Tarefas tarefa) {
	String sel = "select*from lista where id_tarefas = ?";
	try {
		Connection con = conn.creaConnection();
		PreparedStatement pst = con.prepareStatement(sel);
		pst.setInt(1, tarefa.getId());
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			tarefa.setId(rs.getInt(1));
			tarefa.setTitulo(rs.getString(2));
			tarefa.setDescricao(rs.getString(3));
			tarefa.setData(rs.getString(4));
			tarefa.setPrioridade(rs.getString(5));
			
			
			
		}
		con.close();
			
		
	} catch (Exception e) {
	System.out.println(e);
	}
}

public void Update(Tarefas tarefa) {
	String up = "update lista set titulo = ? , descricao = ? ,  date_vencimento = ? ,  prioridade = ? where id_tarefas = ?";
	try {
		Connection con = conn.creaConnection();
		PreparedStatement pst = con.prepareStatement(up);
		pst.setString(1, tarefa.getTitulo());
		pst.setString(2, tarefa.getDescricao());
		pst.setString(3, tarefa.getData());
		pst.setString(4, tarefa.getPrioridade());
		pst.setInt(5, tarefa.getId());
		
		pst.executeUpdate();
		con.close();
		
				
	} catch (Exception e) {
		System.out.println(e);
	}
	
}


public void delete(Tarefas tarefa) {
	String del  = "delete from lista where id_tarefas = ?";
try {
	Connection con = conn.creaConnection();
	PreparedStatement pst = con.prepareStatement(del);
	pst.setInt(1, tarefa.getId());
	pst.executeUpdate();
	con.close();
	
	
} catch (Exception e) {
	System.out.println(e);
}	
	
}



}
