#include<stdio.h>
#include<unistd.h>
main()
{
        char command[80],t1[20],t2[20],t3[20],t4[20];
        int n;
        system("clear");
        while(1)
        {
                printf("myShell$");
                fgets(command,80,stdin);
                n = sscanf(command,"%s %s %s %s",t1,t2,t3,t4);
                switch(n)
                {
                case 1:
                        if(!fork())
                        {
                                execlp(t1,t2,NULL);
                                perror(t1);
                        }
                        break;
                case 2:
                        if(!fork())
                        {
                                execlp(t1,t2,t3,NULL);
                                perror(t1);
                        }
                        break;
                case 3:
                        if(!fork())
                        {
                                execlp(t1,t2,t3,t4,NULL);
                                perror(t1);
                        }
                        break;
                }
        }
}

