package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.BancoConexao;
import Dao.Tarefadao;
import Model.Tarefas;
import Utilitarios.FormatData;

@WebServlet(urlPatterns = { "/controller" , "/tarefas" , "/add" , "/update" , "/excluir" , "/novatarefa"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public controller() {
        super();
      
    }

	Tarefas tarefa = new Tarefas();
	Tarefadao tarefadao = new Tarefadao();
	BancoConexao conexao = new BancoConexao();
	FormatData dataf = new FormatData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/add")) {
			
			NovaTarefa(request, response);
			
			
		}
		
		else if(action.equals("/tarefas")) {
			
			Lista(request, response);
			
		}
		else if(action.equals("/update")) {
			
			Select(request, response);
			
		}
		else if(action.equals( "/novatarefa")) {
			
			Edicao(request, response);
			
		}
		else if(action.equals( "/excluir")) {
			
			Excluir(request, response);
			
		}
		else {
			
			response.sendRedirect("Tarefas.jsp");
		}
		conexao.testedeconexao();
	}

	
	
	protected void NovaTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("due-date"));
		System.out.println(request.getParameter("priority"));
		
		
		tarefa.setTitulo(request.getParameter("title"));
		tarefa.setDescricao(request.getParameter("description"));
		tarefa.setData(dataf.formatarData(request.getParameter("due-date")));
		tarefa.setPrioridade(request.getParameter("priority"));
		
		tarefadao.InserirTarefa(tarefa);
	    
		response.sendRedirect("Tarefas.jsp");
	}
	
	protected void Lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	ArrayList<Tarefas> listar = tarefadao.ListarTarefas();
	
	request.setAttribute("tarefa", listar);
	
	RequestDispatcher rd = request.getRequestDispatcher("ListadeTarefas.jsp");
	rd.forward(request, response);
	
	response.sendRedirect("tarefas");
		
	}
	
	protected void Select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		String id = request.getParameter("id");
		
		tarefa.setId(Integer.parseInt(id));
		
		tarefadao.select(tarefa);
		
		request.setAttribute("id", tarefa.getId());
		request.setAttribute("titulo", tarefa.getTitulo());
		request.setAttribute("descricao", tarefa.getTitulo());
		request.setAttribute("data", tarefa.getTitulo());
		request.setAttribute("prioridade", tarefa.getTitulo());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Edicao.jsp");

		rd.forward(request, response);
		
		response.sendRedirect("Edicao.jsp");
	}
	
	
	protected void Edicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(request.getParameter("edit-id"));
	System.out.println(request.getParameter("edit-title"));
	System.out.println(request.getParameter("edit-description"));
	System.out.println(request.getParameter("edit-due-date"));
	System.out.println(request.getParameter("edit-priority"));
	
	tarefa.setId(Integer.parseInt(request.getParameter("edit-id")));
	tarefa.setTitulo(request.getParameter("edit-title"));
	tarefa.setDescricao(request.getParameter("edit-description"));
	tarefa.setData(dataf.formatarData(request.getParameter("edit-due-date")));
	tarefa.setPrioridade(request.getParameter("edit-priority"));

	tarefadao.Update(tarefa);
	
	response.sendRedirect("tarefas");
	
	
	
	}
	
	
	protected void Excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id =Integer.parseInt(request.getParameter("id"));
	
	tarefa.setId(id);
	tarefadao.delete(tarefa);
	response.sendRedirect("Tarefas.jsp");
	
	
	}
		
}
