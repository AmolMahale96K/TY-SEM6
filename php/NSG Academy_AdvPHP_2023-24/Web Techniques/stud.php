<!DOCTYPE html>
<html lang="en">

<body>
    <form action="<?= $_SERVER['PHP_SELF'] ?>" method="POST" autocomplete="off">
        Enter roll number <input type="text" name="roll" 
        value="<?php if(isset($_REQUEST['roll'])) echo $_REQUEST['roll']; ?>"/> <br>
        Enter name <input type="text" name="name" 
        value="<?php if(isset($_REQUEST['name'])) echo $_REQUEST['name']; ?>"></input> <br>
        Enter marks <input type="text" name="mks" 
        value=" <?php if(isset($_REQUEST['mks'])) echo $_REQUEST['mks'];  ?> "/> <br>
        <input type="submit" name="ok" value="submit" />
    </form>
</body>
</html>

<?php    
// Example of self processing PHP
// Example of sticky form in PHP
    if(isset($_REQUEST['ok'])){
        echo "<br>Roll No : ".$_REQUEST['roll'];
        echo "<br>NAME : ".$_REQUEST['name'];
        echo "<br>MARKS : ".$_REQUEST['mks'];   
    }
?>