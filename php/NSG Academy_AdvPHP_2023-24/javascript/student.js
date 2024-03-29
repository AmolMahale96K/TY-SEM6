function fun()
        {
            form1.usr.focus();
        }


        function validate(){
            uname = form1.usr.value;
            contact = form1.contact.value;
            pwd = form1.pwd.value;
            cpwd = form1.cpwd.value;

            if(uname==null || uname=="")
            {
                document.getElementById('usrspan').style.color = "red";
                document.getElementById('usrspan').innerHTML = "Name field can not be empty";
                return false;
            }else if(uname.length<6){                    
                document.getElementById('usrspan').style.fontWeight = "bold";
                document.getElementById('usrspan').innerHTML = "Length : "+uname.length+" You should atleast enter 6 characters";
                return false;
            }else if(contact==null || contact==""){
                document.getElementById('contactspan').style.fontStyle = "italic";
                document.getElementById('contactspan').innerHTML = "Contact number is mandatory";
                return false;
            }else if(isNaN(contact)){
                document.getElementById('contactspan').style.fontFamily = "arial";
                document.getElementById('contactspan').innerHTML = "Enter numbers only";
                return false;
            }else if(contact.length!=10){
                document.getElementById('contactspan').innerHTML = "Contact number must be of 10 digits only";
                return false;
            }else if(pwd!=cpwd){
                document.getElementById('cpwdspan').style.backgroundColor = "green";
                document.getElementById('cpwdspan').innerHTML = "password doesnot match";
                return false;
            }else{
                return true;
            }
        }

        
        function register(){
            location = "register.html";
        }