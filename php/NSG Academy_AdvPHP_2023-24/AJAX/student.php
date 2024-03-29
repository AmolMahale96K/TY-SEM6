<?php
    $m = $_REQUEST['abcd'];

    pg_connect("host=localhost user=postgres password=password dbname=tyjdbc1");
    $result = pg_query("select * from student where mks>=$m");


    echo "<table>";
    echo "<tr>";
        echo "<th>ROLL</th>";
        echo "<th>NAME</th>";
        echo "<th>MARKS</th>";
    echo "</tr>";
    while($row = pg_fetch_array($result))
    {
        echo "<tr>";
            echo "<td>".$row[0]."</td>";
            echo "<td>".$row[1]."</td>";
            echo "<td>".$row[2]."</td>";
        echo "</tr>";
    }
    echo "</table>";
?>