<?php
    // $_GET,$_POST,$_REQUEST

    // echo "<br>Content of GET array<br>";
    // print_r($_GET);

    // echo "<br>Content of POST array<br>";
    // print_r($_POST);
    
    // echo "<br>Content of REQUEST array<br>";
    // print_r($_REQUEST);
    
    // echo "<br>Roll No : ".$_REQUEST['roll'];

    // print_r($_SERVER);

    echo "<table border=1>";   
    echo "<tr>"; 
        echo "<th>KEY</th>";
        echo "<th>VALUE</th>";
    echo "</tr>"; 
    foreach($_SERVER as $k=>$v ){
        echo "<tr>";
            echo "<td>".$k."</td>";
            echo "<td>".$v."</td>";
        echo "</tr>";
    }        
    echo "</table>";


    // echo "<br>Browser Name : ".$_SERVER['HTTP_USER_AGENT'];
    // echo "<br>FILE NAME : ".$_SERVER['PHP_SELF'];
    // echo "<br>SERVER NAME : ".$_SERVER['SERVER_NAME'];
    // echo "<br>REQUEST METHOD : ".$_SERVER['REQUEST_METHOD'];
?>