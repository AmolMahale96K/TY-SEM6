<?php
    // step-1 open xml file 
    $doc = simplexml_load_file("student.xml");

    // step-2 extract all elements
    $allstudents = $doc->student;

    // step-3 print all elements one by one with the help of loop
    echo "<table border=1>";
    echo "<tr>";
        echo "<th>ROLLNO</th>";
        echo "<th>NAME</th>";
        echo "<th>MARKS1</th>";
        echo "<th>MARKS2</th>";
        echo "<th>MARKS3</th>";
        echo "<th>TOTAL</th>";
        echo "<th>PERCENTAGE</th>";
    echo "</tr>";
    foreach($allstudents as $st){
        $tot = $st->mks1 + $st->mks2 + $st->mks3;
        $per = $tot/3;
        if($per>=80){
            echo "<tr>";
                echo "<td>".$st->roll."</td>";
                echo "<td>".$st->name."</td>";
                echo "<td>".$st->mks1."</td>";
                echo "<td>".$st->mks2."</td>";
                echo "<td>".$st->mks3."</td>";            
                echo "<td>".$tot."</td>";
                echo "<td>".$per."</td>";
            echo "</tr>";
        }
    }
    echo "</table>";
?>