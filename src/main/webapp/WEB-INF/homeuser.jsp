<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Tu home de usuario/a</title>
        <link rel="stylesheet" type="text/css" href="css/homeuser.css">
    </head>
    <body>
        <header>
            <div class="head"><img src="images/profile.png" width="55" height="55"><h3>Bienvenido/a ${name_user}</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="images/bananas_medio.png"></a></div>
            <div class="head"><h4><a href="LogoutController">Logout</a></h4></div>    
        </header>
        <main>
            
            <sidebar class="tareas">
                <nav>
                    <h2>Tus tareas</h2>
                    <img src="images/search.png">
                    <input type="text" name="navegador" placeholder="Search">
                    <p>
                        <div class="tareas_2">
                            <h3>Tarea 1 ${task1_description}</h3>
                        </div>
                        <div class="tareas_2">
                            <h3>Tarea 2 ${task2_description}</h3>
                        </div>
                        <div class="tareas_2">
                               <h3>Tarea 3 ${task3_description}</h3>
                        </div>
                    </p>
                </nav>    
            </sidebar>
            <section class="botones">
                    <p>
                    <a href="createproject.jsp">
                        <input type="submit" name="boton" value="Crear proyecto" style="width:60%">
                   	</a>
                   	<a href="#"> 
                        <img src="images/add.png" style="width:3%">
                    </a> 
                </p>
               	<p>
                   	<a href="createtask.jsp">
                        <input type="submit" name="boton" value="Crear tarea" style="width:60%">
                  	</a>
                    <a href="createtask.jsp">
                        <img src="images/add.png" style="width:3%">
                    </a>
                </p>    
                <p>
                    <a href="#">
                        <input type="submit" name="boton" value="Lista proyectos" style="width:40%">
                    </a>
                </p>
            </section>
        </main>
        <br>
        <footer>
            <div class="row">
                <span class="col-xs-12 col-sm-12 col-md-12 col-lg-12">Banana GEST - Todos los derechos reservados</span>
            </div>
        </footer>
</body>
</html>