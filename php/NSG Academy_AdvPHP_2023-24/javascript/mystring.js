function countvowels()
{
    str = document.getElementById('str').value;
    cnt = 0;
    for(i=0;i<str.length;i++)
    {
        // if(str[i]=='a' || str[i]=='e' || str[i]=='i'|| str[i]=='o' || str[i]=='u')
        // {
        //     cnt++;
        // }

        switch(str[i])
        {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U': cnt++;
        }
    }
    document.getElementById('result').innerHTML = "Number of Vowels : "+cnt;
    // alert("Number of vowels : "+cnt);
    // console.log("Number of vowels : "+cnt);
    // document.write("Number of Vowels :"+cnt);
}


function occurvowels()
{
    str = document.getElementById('str').value;
    acnt=0;ecnt=0;icnt=0;ocnt=0;ucnt=0;
    for(i=0;i<str.length;i++)
    {       
        switch(str[i])
        {
            case 'a':
            case 'A': acnt++;
                      break;
            case 'e':
            case 'E': ecnt++;
                      break;
            case 'i':
            case 'I': icnt++;
                      break;
            case 'o':
            case 'O': ocnt++;
                      break;
            case 'u':
            case 'U': ucnt++;
        }
    }
    document.getElementById('result').innerHTML += "Total number of a vowel : "+acnt+"<br>";
    document.getElementById('result').innerHTML += "Total number of e vowel : "+ecnt+"<br>";
    document.getElementById('result').innerHTML += "Total number of i vowel : "+icnt+"<br>";
    document.getElementById('result').innerHTML += "Total number of o vowel : "+ocnt+"<br>";
    document.getElementById('result').innerHTML += "Total number of u vowel : "+ucnt+"<br>";    
}


function changestyle()
{
    str = document.getElementById('str').value;
    // Following are built-in functions of string in javascript
    str = str.bold();
    str = str.italics();
    str = str.fontcolor("red");
    str = str.fontsize(50);

    document.getElementById('result').innerHTML = str;
}

function getchars()
{
    pos = parseInt(prompt("Enter position"));
    str = document.getElementById('str').value;

    ch = str.charAt(pos);
    document.getElementById('result').innerHTML = "Character is "+ch;
}

function palin()
{
    str = document.getElementById('str').value;
    i = 0;
    j = str.length-1;

    flag = 1;
    while(i<j)
    {
        if(str[i] != str[j])
        {
            flag = 0;
            break;
        }
        i++;
        j--;
    }
    if(flag==1)
        document.getElementById('result').innerHTML = str+" is palindrome string";
    else
        document.getElementById('result').innerHTML = str+" is not palindrome string";
}