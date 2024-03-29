<?php
    $dom = new DOMDocument();
    $dom->load("movies.xml");

    $root_node = $dom->documentElement;  //retrieve root node

    $movie_node = $dom->createElement("movie");
        $name_node = $dom->createElement("name","RRR");
        $movie_node->appendChild($name_node);
        $actor_node = $dom->createElement("actor","jrNTR");
        $movie_node->appendChild($actor_node);
        $producer = $dom->createElement("producer","rajamouli");
        $movie_node->appendChild($producer);    
    $root_node->appendChild($movie_node);

    $fname = "movies.xml";
    $dom->save($fname);
    echo "<br>New Record added in XML file";
?>
<a href="<?=$fname?>"><?= $fname?></a>