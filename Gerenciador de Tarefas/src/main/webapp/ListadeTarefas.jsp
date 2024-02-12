<%@page import="Model.Tarefas"%>
<%@page import="Dao.Tarefadao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    ArrayList<Tarefas> listar = (ArrayList<Tarefas>) request.getAttribute("tarefa");
    
    
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Lista de Tarefas</title>

<style type="text/css">
.container {
  width: 80%;
  margin: 20px auto;
}

#task-table {
  width: 100%;
  border-collapse: collapse;
}

#task-table th, #task-table td {
  border: 1px solid #ccc;
  padding: 8px;
}

#task-table th {
  background-color: #f2f2f2;
}

#task-table th, #task-table td:last-child {
  text-align: center;
}

.delete-btn{
padding: 10px 20px;
  background-color: rgb(255,0,0);
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;


}

.delete-btn:hover{
background-color: #8b0000;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.return-btn {
  display: block;
  margin-top: 10px;
  color: #007bff;
  text-decoration: none;
}

.return-btn:hover {
  text-decoration: underline;
}

</style>
</head>
<body>

  <div class="container">
    <h2>Lista de Tarefas</h2>
    <table id="task-table">
      <thead>
        <tr>
          <th>Título</th>
          <th>Descrição</th>
          <th>Data de Vencimento</th>
          <th>Prioridade</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr class="task-item">
        <%for(int i = 0 ; i<listar.size() ; i++){%>
          <td><%=listar.get(i).getTitulo() %></td>
          <td><%=listar.get(i).getDescricao() %></td>
          <td><%=listar.get(i).getData()%></td>
          <td><%=listar.get(i).getPrioridade() %></td>
          <td>
            <a href="update?id=<%=listar.get(i).getId()%>"><button class="edit-btn">Editar</button></a>
            <a href="excluir?id=<%=listar.get(i).getId()%>"><button class="delete-btn">Excluir</button></a>
          </td>
        </tr>
       <%}%>
      </tbody>
    </table>
    <a href="Tarefas.jsp" class="return-btn">Voltar para a Lista de Tarefas</a>
  </div>

</body>
</html>
