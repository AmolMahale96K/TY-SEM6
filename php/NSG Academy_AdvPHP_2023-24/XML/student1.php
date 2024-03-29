<!-- <?php
    $doc = simplexml_load_file("student1.xml"); //step-1
    $all = $doc->student; //step-2
    foreach($all as $st){           //step-3
        foreach($st->attributes() as $k=>$v){
            echo "<br>".$k." : ".$v;
        }
        echo "<br>Name : ".$st->name;
        echo "<br>Class : ".$st->class;
        echo "<br>Percentage : ".$st->percentage;
    }
?> -->

<?php
    $dom = new DOMDocument();   //step-1
    $dom->load("student1.xml");

    $all = $dom->getElementsByTagName("student");   //step-2

    foreach($all as $st){       //step-3
        echo "<br>".$st->textContent;
        // echo "<br>Roll NO  : ".$st->getAttribute("roll");
        // echo "<br>College  : ".$st->getAttribute("college");
        // echo "<br>Name : ".$st->getElementsByTagName("name")->item(0)->nodeValue;
        // echo "<br>Class : ".$st->getElementsByTagName("class")->item(0)->nodeValue;
        // echo "<br>Percentage : ".$st->getElementsByTagName("percentage")->item(0)->nodeValue;
    }

    $dom->save("stud1.xml");
?>


