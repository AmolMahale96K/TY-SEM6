<?php
    $usr = $_REQUEST['usr'];
    $pwd = $_REQUEST['pwd'];

    pg_connect("host=localhost user=postgres password=password dbname=tyjdbc1");

    $result = pg_query("select * from login where uname='$usr' and pname='$pwd'");

    $row = pg_fetch_array($result);

    if($row)
        echo "valid user";
    else
        echo "invalid user";
?>