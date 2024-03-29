<?php
    $dom = new DOMDocument();
    $dom->xmlVersion = '1.0';

    $root_node = $dom->createElement("movies");
        $movie_node = $dom->createElement("movie");
            $name_node = $dom->createElement("name","fighter");
            $movie_node->appendChild($name_node);
            $actor_node = $dom->createElement("actor","Hritik");
            $movie_node->appendChild($actor_node);
            $producer_node = $dom->createElement("producer","yashraj");
            $movie_node->appendChild($producer_node);
            $id = new DOMAttr("id","111");
            $movie_node->setAttributeNode($id);
        $root_node->appendChild($movie_node);

        $movie_node = $dom->createElement("movie");
            $name_node = $dom->createElement("name","animal");
            $movie_node->appendChild($name_node);            
            $actor_node = $dom->createElement("actor","ranbirkapoor");
            $movie_node->appendChild($actor_node);
            $producer_node = $dom->createElement("producer","tseries");
            $movie_node->appendChild($producer_node);
            $id = new DOMAttr("id","222");
            $movie_node->setAttributeNode($id);
        $root_node->appendChild($movie_node);        
    $dom->appendChild($root_node);
    
    $fname = "movies.xml";
    $dom->save($fname);
    echo "<br>XML file has been created";
?>

<a href="<?=$fname?>"><?= $fname?></a>