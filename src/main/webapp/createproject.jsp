<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="saveTask" class="com.generation.jwd.p1.beans.TaskBean" scope="request"></jsp:useBean>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear tarea | Banana GEST</title>
        <link rel="stylesheet" type="text/css" href="css/createtask.css">
    </head>
    <body>
        <header>
            <div class="head"><img src="images/profile.png" width="55" height="55"><h3>Bienvenido/a (User)</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="images/bananas_medio.png"/></a></div>
            <div class="head"><h4><a href="login.jsp">Logout</a></h4></div>
        </header>
        <h2>Registro de nuevo proyecto</h2>
        <hr>
        <main>
            <form method="post" action="createtask" id = "formtask">
                <p>
                    <table id="basic">
                        <tr class="contenttable">
                            <th class="namecontent">
                                Nombre del proyecto
                            </th>
                            <th class="contenttable">
                                <input style="background-color:#F5BFB2;" type="text" placeholder="Nombre del proyecto" required="true"
                                name="name_task" autofocus/>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Descripción del proyecto
                            </th>
                            <th class="contenttable">
                                <textarea name="desc_task" required="true" rows="15" cols="60"></textarea>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Notas del proyecto
                            </th>
                            <th class="contenttable">
                                <textarea name="notes_task" required="true" rows="15" cols="60"
                                 ></textarea>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Añadir archivos adjuntos del proyecto
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Fecha de inicio / Fecha de fin
                            </th>
                            <th class="contenttable">
                                <input id="dateform" type="text" name="dateBegin_task" required="true"/>
                                 hasta 
                                <input id="dateform" type="text" name="dateEnd_task" required="true"/> 
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Responsable
                            </th>
                            <th class="contenttable">
                                <select  class="selectionbuton" name="name_user" required="true">
                                    <option value= "0" >---Elige una opción---</option>
                                    <option value= "1">Juan Maria</option>
                                    <option value= "2">Jerges Gonzalez</option>
                                    <option value= "3">Rubén López</option>
                                    <option value= "4">David Bisbal</option>
                                    <option value= "5">Chenoa</option>
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Estado
                            </th>
                            <th class="contenttable">
                                <select  class="selectionbuton" name="status_task" required="true">
                                    <option value="0">---Elige una opción---</option>
                                    <option value="1">Acabado</option>
                                    <option value="2">Sin empezar</option>
                                    <option value="3">En curso</option>
                                </select>
                            </th>
                        </tr>
                    </table>
                </p>
                <div id="boton">
                    <button onclick = "validar()" style="width:200px; height:50px;">Crear proyecto</button>
                    <button onclick = "cancelar()" name="cancel_task" value="Cancelar tarea" style="width:200px; height:50px;">Cancelar Proyecto</button>
                </div>
            </form>
        </main>
        <footer>
            <span>Banana GEST - Todos los derechos reservados</span>
        </footer>
        <script>
            function validar(){
                var inpObj = document.getElementById("formtask");
                if (inpObj.checkValidity() == false) {
                    alert("project has not created")
                } else{ 
                    alert("project has been created")
                }            
            }
        </script>
    </body>
    </html>