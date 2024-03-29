<?php      
    //HEREDOC string i.e. multiline string
    $str = <<<xml
    <?xml version="1.0"?>
    <bookstore>
        <php>
            <name>Complete Reference in PHP</name>
            <price>1000</price>
        </php>
        <php>
            <name>PHP by Orelly</name>
            <price>500</price>
        </php>
    </bookstore>
    xml;

    $fname = "book.xml";
    // $fp = fopen($fname,"w");
    // fwrite($fp,$str);
    // fclose($fp);
    
    $dom = new DOMDocument();
    $dom->loadXML($str);
    $dom->save($fname);
    echo "<br>XML file has been generated";    
?>
    <a href="<?= $fname?>"><?= $fname?></a>