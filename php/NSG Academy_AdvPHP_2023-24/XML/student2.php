<?php
    $roll = $_REQUEST['roll'];

    $doc = simplexml_load_file("student.xml");
    $allstudents = $doc->student;

    $flag = 0;
    foreach($allstudents as $st){
        if($st->roll == $roll){
            $flag = 1;
            break;
        }
    }

    if($flag == 0)
        echo "<br>$roll not found";
    else{
        echo "<br>Student found";
        echo "<br>Roll No : ".$st->roll;
        echo "<br>Name : ".$st->name;
        $tot = $st->mks1 + $st->mks2 + $st->mks3;
        echo "<br>Total Marks : ".$tot;
    }
?>