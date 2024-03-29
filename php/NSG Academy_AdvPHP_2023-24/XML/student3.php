<?php
    $ob = new DOMDocument();
    $ob->load("student.xml");
    $allstudents = $ob->getElementsByTagName("student"); 

    // echo "<table>";
    // echo "<tr>";
    //     echo "<th>ROLLNO</th>";
    //     echo "<th>NAME</th>";
    //     echo "<th>MARKS1</th>";
    //     echo "<th>MARKS2</th>";
    //     echo "<th>MARKS3</th>";
    // echo "</tr>";
    foreach($allstudents as $st){
        // echo "<tr>";
        //     echo "<td>".$st->getElementsByTagName("roll")->item(0)->nodeValue."</td>";
        //     echo "<td>".$st->getElementsByTagName("name")->item(0)->nodeValue."</td>";
        //     echo "<td>".$st->getElementsByTagName("mks1")->item(0)->nodeValue."</td>";
        //     echo "<td>".$st->getElementsByTagName("mks2")->item(0)->nodeValue."</td>";
        //     echo "<td>".$st->getElementsByTagName("mks3")->item(0)->nodeValue."</td>";           
        // echo "</tr>";
        echo "<br>".$st->textContent; //print all columns at a time of current row
    }
    echo "</table>";
?>
