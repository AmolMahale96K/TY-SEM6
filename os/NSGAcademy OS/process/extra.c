#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
int main()
{
 int pid;
 pid = fork();
 if(pid<0)
 {
  printf("FORK FAILED");
 }
 else if(pid == 0)
 {
  printf("CHILD PROCESS IS EXECUTING \n");
  execlp("/bin/ls","ls",NULL);//child process will execute pwd command
  exit(0);
 }
 else
 {
  wait(&pid);
  printf("PARENT PROCESS IS EXECUTING \n");
  exit(0);
 }
 return 0;
}
