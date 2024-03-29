<?php
    $st = $_REQUEST['st'];

    pg_connect("host=localhost user=postgres password=password dbname=tyjdbc1");

    $result = pg_query("select * from state where stname='$st'");

    while($row = pg_fetch_array($result)){
        echo "<option>".$row[1]."</option>";
    }    
?>