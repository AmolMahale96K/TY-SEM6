<?php
    $name = $_REQUEST['name'];

    $ob = new DOMDocument(); //$doc = simplexml_load_file("item.xml");
    $ob->load("item.xml");  

    $allitems = $ob->getElementsByTagName("item"); //$allitems = $doc->item;

    $flag = 0;
    foreach($allitems as $item){
        // if($item->name == $name){
        if($item->getElementsByTagName("name")->item(0)->nodeValue == $name){
            $flag = 1;
            break;
        }
    }

    if($flag==0)
        echo "<br>item not found";
    else{
        echo "<br>Name:".$item->getElementsByTagName("name")->item(0)->nodeValue; //$item->name
        echo "<br>Quantity:".$item->getElementsByTagName("qty")->item(0)->nodeValue;
        echo "<br>Price:".$item->getElementsByTagName("price")->item(0)->nodeValue;
    }
?>