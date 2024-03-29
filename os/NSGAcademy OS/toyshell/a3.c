#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void count (char c[], char *fn)
{
  int lc = 0, wc = 0, cc = 0, handle;
  char ch;
  if ((handle = open (fn, O_RDONLY)) == -1)
    {
      printf ("File %s not found\n", fn);
      return;
    }
  while (read (handle, &ch, 1) != 0)
    {
      if (ch == '\n')
	{
	  lc++;
	  cc++;
	  wc++;
	}
      else if (ch == ' ')
	{
	  wc++;
	  cc++;
	}
      else
	{
	  cc++;
	}

    }
  close (handle);
  if (c[0] == 'c' && c[1] == 'w')
    {
      printf ("Total No.of Characters = %d\n", cc);
      printf ("Total No.of Words = %d\n", wc);
    }
  else if (c[0] == 'c' && c[1] == 'l')
    {
      printf ("Total No.of Characters = %d\n", cc);
      printf ("Total No.of Lines = %d\n", lc);
    }
  else if (c[0] == 'c' && c[1] == 'w' && c[2] == 'l')
    {
      printf ("Total No.of Characters = %d\n", cc);
      printf ("Total No.of Words = %d\n", wc);
      printf ("Total No.of Lines = %d\n", lc);
    }
  else if (c[0] == 'w' && c[1] == 'l')
    {
      printf ("Total No.of Words = %d\n", wc);
      printf ("Total No.of Lines = %d\n", lc);
    }
  else
    printf ("Invalid");
}

main ()
{
  char command[80], t1[20], t2[20], t3[20], t4[20];
  int n;
  system ("clear");
  while (1)
    {
      printf ("myShell$");
      fgets (command, 80, stdin);
      n = sscanf (command, "%s %s %s %s", t1, t2, t3, t4);
      switch (n)
	{
	case 1:
	  if (!fork ())
	    {
	      execlp (t1, t1, NULL);
	      perror (t1);
	    }
	  break;
	case 2:
	  if (!fork ())
	    {
	      execlp (t1, t1, t2, NULL);
	      perror (t1);
	    }
	  break;
	case 3:
	  if (strcmp (t1, "count") == 0)
	    count (t2, t3);
	  else
	    {
	      if (!fork ())
		{
		  execlp (t1, t1, t2, t3, NULL);
		  perror (t1);
		}
	    }
	  break;
	case 4:
	  if (!fork ())
	    {
	      execlp (t1, t1, t2, t3, t4, NULL);
	      perror (t1);
	    }
	}
    }
}
