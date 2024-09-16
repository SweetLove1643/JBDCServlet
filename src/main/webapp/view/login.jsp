<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .registerbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    
    <center> <h1> Login Form </h1> </center>   
    <form action = "login" method = "post">  
        <div class="container">   
            <label>Username : </label>   
            <input type="text" placeholder="Enter Username" name="uname" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" name="pwd" required>  
            <button type="submit" name="action" value="login">Login</button>   
            <input type="checkbox" checked="checked" name="remember"> Remember me   
            <button type="submit" name="action" value="register" class = "registerbtn"> Register</button>   
            Forgot <a href="#"> password? </a>   
        </div>   
    </form>     
</body>     
</html> 