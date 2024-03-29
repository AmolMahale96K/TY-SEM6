#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>

void readarray(int* a,int n)
{
 int i;
 printf("\nEnter %d numbers\n",n);
 for(i=0;i<n;i++)
     scanf("%d",&a[i]);
}

void printarray(int* a,int n)
{
 int i;
 for(i=0;i<n;i++)
    printf("%d\t",a[i]);
}


void bubblesort(int* a,int n)
{
 int i,j,t,cmpcnt=0,swpcnt=0;

 for(i=1;i<n;i++)
    {
     for(j=0;j<n-i;j++)
	{
	 cmpcnt++;
	 if(a[j] > a[j+1])
	   {
	    swpcnt++;
	    t = a[j];
	    a[j] = a[j+1];
	    a[j+1] = t;
	   }
	}
    }
 printf("\nTotal number of comparison : %d",cmpcnt);
 printf("\nTotal number of swapping : %d",swpcnt);
}

void insertionsort(int* a,int n)
{
    int i,j,t,cmpcnt=0;
    for(i=1;i<n;i++)
        {
            t = a[i];  // temp copy ith element            
            for(j=i-1;j>=0;j--)
                {
                    cmpcnt++;
                    if(a[j] > t)
                        a[j+1] = a[j]; //shift
                    else
                        break;  //if data is already sorted(advantage)
                }
            a[j+1] = t; // return copy (actual insertion)    
        }
    printf("\nNumber of comparison is %d",cmpcnt);
}

int main()
{
 int n;
 int *a;
 printf("\nEnter how many numbers:");
 scanf("%d",&n);
 
 a = (int*)malloc(sizeof(int)*n);
 readarray(a,n);
 
 if(fork()==0)
 {
  bubblesort(a,n);
  printf("\nSorting by Child Process\n");
  printarray(a,n);
  exit(0);
 }
 else
 {
  wait(NULL);
  insertionsort(a,n);
  printf("\nSorting by Parent process\n");
  printarray(a,n);  
 }
 return 0;
}
