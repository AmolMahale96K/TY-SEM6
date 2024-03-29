<html>
	<body>
		<form action="<?= $_SERVER['PHP_SELF'] ?>">
			SELECT your college <br>

            <select name="college[]" multiple>
                <option value="pvg" 
                <?php 
                    if(isset($_REQUEST['college'])){
					    if(in_array('pvg',$_REQUEST['college'])) 
						    echo "selected"; 
                    }
				?>
                >PVG</option>
                <option value="mmcc">MMCC</option>
                <option value="fc">FC</option>
                <option value="sp">SP</option>
                <option value="garware">GARWARE</option>
            </select>
			
			<input type="submit" name="ok" value="ok" />
		</form>
	</body>
</html>

<?php
	if(isset($_REQUEST['ok'])){
		print_r($_REQUEST['college']);
	}
?>