#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main()
{
 char* args[] = {"./ex1sa1",NULL};
 if(fork()==0)
   {
   	printf("\nChild process will have different task");
   	execvp(args[0],args);
   }
 else
   {
   	wait(NULL);
   	printf("\nI am Parent");
   }  
}
