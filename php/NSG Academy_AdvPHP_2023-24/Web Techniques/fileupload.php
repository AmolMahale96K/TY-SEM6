<?php
    // // $_FILES is a 2D array
    // // print_r($_FILES);
    //  // echo "<br>File Name : ".$name;
    // // echo "<br>File Type : ".$_FILES['src']['type'];
    // // echo "<br>File Temp Name : ".$temp_name;
    // // echo "<br>File Error : ".$_FILES['src']['error'];
    // // echo "<br>File size : ".$_FILES['src']['size'];
    // echo "<br>";

    $name = $_FILES['src']['name'];
    $temp_name = $_FILES['src']['tmp_name'];  

    if($_FILES['src']['type']=='image/jpeg' && $_FILES['src']['size']<66000){
        move_uploaded_file($temp_name,$name);    
        echo "<img src=".$name." height=200 width=200></img>";
        echo "<br> <a href=".$name.">Download</a>";
    }else
        echo "<br>Please upload only jpeg image and size must be less than 66kb";
?>

