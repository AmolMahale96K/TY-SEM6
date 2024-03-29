<?php
    if(isset($_COOKIE['abcd']))
        $cnt = $_COOKIE['abcd'];
    else
        $cnt = 0;

    $cnt++;
    setcookie('abcd',$cnt,time()+3); //first time create and then replace    
    echo "<br>Number of visitors : ".$cnt;
?>

