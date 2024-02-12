<%@page import="Model.Tarefas"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gerenciador de Tarefas</title>
 <style type="text/css">
 
 .container {
  width: 50%;
  margin: 0 auto;
}

form {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 5px;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="text"],
textarea,
input[type="date"],
select {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  margin-top: 5px;
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

.task-item {
  border: 1px solid #ccc;
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 10px;
}

.task-item h3 {
  margin-top: 0;
}

.task-item p {
  margin-bottom: 5px;
}

.task-item button {
  background-color: #dc3545;
}
 
 
 .task-item {
  border: 1px solid #ccc;
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 10px;
}

.task-item h3 {
  margin-top: 0;
}

.task-item p {
  margin-bottom: 5px;
}

.task-item button {
  background-color: #dc3545;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 5px 10px;
  cursor: pointer;
  margin-right: 5px;
}

.task-item button:hover {
  background-color: #c82333;
}
 
 #show-task-list-btn {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 10px;
}

#show-task-list-btn:hover {
  background-color: #0056b3;
}
 
 
 
 </style>
</head>
<body>

  <div class="container">
    <h2>Gerenciador de Tarefas</h2>
   <a href="tarefas"> <button id="show-task-list-btn" >Mostrar Lista de Tarefas</button></a>
   
    <form id="task-form" action="add">
      <div class="form-group">
        <label for="title">Título:</label>
        <input type="text" id="title" name="title" required>
      </div>
      <div class="form-group">
        <label for="description">Descrição:</label>
        <textarea id="description" name="description"  required></textarea>
      </div>
      <div class="form-group">
        <label for="due-date">Data de Vencimento:</label>
        <input type="date" id="due-date" name="due-date" required>
      </div>
      <div class="form-group">
        <label for="priority">Prioridade:</label>
        <select id="priority" name="priority">
          <option value="baixa">Baixa</option>
          <option value="media">Média</option>
          <option value="alta">Alta</option>
        </select>
      </div>
      <button type="submit" id="add-task-btn">Adicionar Tarefa</button>
    </form>


     
    </div>
 

  

</body>
</html>
