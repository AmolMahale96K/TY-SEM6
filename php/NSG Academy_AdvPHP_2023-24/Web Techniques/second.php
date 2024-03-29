<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="third.php">
        Enter java marks <input type="text" name="java" /> <br>
        Enter php marks <input type="text" name="php" /> <br>
        Enter python marks <input type="text" name="python" /> <br>
        Enter tcs marks <input type="text" name="tcs" /> <br>
        Enter OS marks <input type="text" name="os" /> <br>

        <input type="submit" value="calculate"/>
    </form>
</body>
</html>

<?php
    //cookie is a file stored in browser
    // to create cookie we have a function i.e. setcookie()
    $roll = $_REQUEST['roll'];
    setcookie("r",$roll,time()+10);

    $name = $_REQUEST['name'];
    setcookie("n",$name,time()+10);
?>