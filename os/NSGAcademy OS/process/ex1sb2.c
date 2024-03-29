//getpid() returns process id of current process
//getppid() returns process id of parent of current proces
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main()
{
 int y,z;
 printf("\nHELLO\n");
 
 if(fork()==0)
 {
  printf("\nI am Child Process...");
  y = getpid(); //  child process id
  z = getppid(); // parent process id of current child process
  printf("\nChild process id : %d",y);
  printf("\nParent process id printed by child process : %d",z);
  sleep(5);
  printf("\nParent terminated. I became orphan");
 }
 else
 {
  printf("\nI am Parent Process...");
  z = getpid(); // parent process id
  printf("\nParent process id : %d\n",z);
 }
 return 0;
}
