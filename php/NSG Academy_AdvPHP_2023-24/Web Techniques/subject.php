<html>
	<body>
		<form action="<?= $_SERVER['PHP_SELF'] ?>">
			SELECT your subject <br>
			<input type="checkbox" name="sub[]" value="C" 
				<?php 
                    if(isset($_REQUEST['sub'])){
					    if(in_array('C',$_REQUEST['sub'])) 
						    echo "checked"; 
                    }
				?>
            >C</input>
			<input type="checkbox" name="sub[]" value="CPP" 
            <?php 
                    if(isset($_REQUEST['sub'])){
					    if(in_array('CPP',$_REQUEST['sub'])) 
						    echo "checked"; 
                    }
				?>
            >CPP</input>

			<input type="checkbox" name="sub[]" value="JAVA"
            <?php 
                    if(isset($_REQUEST['sub'])){
					    if(in_array('JAVA',$_REQUEST['sub'])) 
						    echo "checked"; 
                    }
				?>
            >JAVA</input>

			<input type="checkbox" name="sub[]" value="PHP"
            <?php 
                    if(isset($_REQUEST['sub'])){
					    if(in_array('PHP',$_REQUEST['sub'])) 
						    echo "checked"; 
                    }
				?>
            >PHP</input>

			<input type="checkbox" name="sub[]" value="PYTHON"
            <?php 
                    if(isset($_REQUEST['sub'])){
					    if(in_array('PYTHON',$_REQUEST['sub'])) 
						    echo "checked"; 
                    }
				?>
            >PYTHON</input>		

			<input type="submit" name="ok" value="ok" />
		</form>
	</body>
</html>

<?php
	if(isset($_REQUEST['ok'])){
		print_r($_REQUEST['sub']);
	}
?>