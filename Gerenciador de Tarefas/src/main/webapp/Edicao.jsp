<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Tarefa</title>
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
  
  
  
  </style>
</head>
<body>

  <div class="container">
    <h2>Editar Tarefa</h2>
    <form id="edit-task-form" action="novatarefa">
    
    <div class="form-group">
        <label for="edit-title">Id:</label>
        <input type="text" value="<%out.print(request.getAttribute("id")); %>" id="edit-title" name="edit-id" readonly>
      </div>
      <div class="form-group">
        <label for="edit-title">Novo Título:</label>
        <input type="text" id="edit-title" value="<%out.print(request.getAttribute("titulo")); %>" name="edit-title" required>
      </div>
      <div class="form-group">
        <label for="edit-description">Nova Descrição:</label>
        <textarea id="edit-description"  value="<%out.print(request.getAttribute("descricao")); %>" name="edit-description"></textarea>
      </div>
      <div class="form-group">
        <label for="edit-due-date">Nova Data de Vencimento:</label>
        <input type="date" id="edit-due-date"  value="<%out.print(request.getAttribute("data")); %>" name="edit-due-date" required>
      </div>
      <div class="form-group">
        <label for="edit-priority">Nova Prioridade:</label>
        <select id="edit-priority" name="edit-priority" required>
          <option value="baixa">Baixa</option>
          <option value="media">Média</option>
          <option value="alta">Alta</option>
        </select>
      </div>
      <button type="submit" id="save-task-btn">Salvar Alterações</button>
    </form>
  </div>

</body>
</html>
