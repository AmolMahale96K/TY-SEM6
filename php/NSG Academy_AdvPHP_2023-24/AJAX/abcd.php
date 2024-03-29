<?php
    $fname = $_REQUEST['fname'];

    $fp = fopen($fname,"r");
    while(($line = fgets($fp,80))!=false)
        echo "<br>".$line;
?>