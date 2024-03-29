#include<stdio.h>
#include<conio.h>

typedef struct pagetable
{
 int fno;
 char status;
}pagetable;
pagetable pt[10];

typedef struct node
{
 int data;
 struct node* next;
}node;

node *front,*rear;

int prefstr[]={5,4,9,3,4,9,1,2,8,7,2,6,5,3,9};
int nprefstr;

int* freeframe;
int fno,n;

int dpage,vpage,pagefault;
int r=5,c=25;

int getfreeframe()
{
 int i;
 for(i=0;i<n;i++)
    if(freeframe[i]==0)
      return i;
 return -1;
}

void appendnode(int no)
{
 node* temp;
 temp=(node*)malloc(sizeof(node));
 temp->data=no;
 temp->next=NULL;

 if(front==NULL)
  {
   front=temp;
   rear=temp;
  }
 else
  {
   rear->next=temp;
   rear=rear->next;
  }
}

int deletenode()
{
 int no;
 node* temp;
 temp=front;
 if(front==rear)
   {
    front=NULL;
    rear=NULL;
   }
 else
   front=front->next;

 temp->next=NULL;
 no=temp->data;
 free(temp);
 return no;
}

void displaynode()
{
 node* p;
 p=front;
 while(p!=NULL)
      {
       printf("%d-->",p->data);
       p=p->next;
     }
 printf("NULL");
}

int main()
{
 int i,j;
 clrscr();
 printf("\nEnter how many frames:");
 scanf("%d",&n);

 freeframe=(int*)malloc(sizeof(int)*n);
 for(i=0;i<n;i++)
    freeframe[i]=0;

 nprefstr=sizeof(prefstr)/sizeof(int);
 for(i=0;i<10;i++)
    pt[i].status='i';

 printf("\n\nReference page ");
 for(i=0;i<nprefstr;i++)
    {
     dpage=prefstr[i];
     printf("\nDemanded page is %d",dpage);
     getch();
     if(pt[dpage].status=='i') //page is not in the frame
       {
		pagefault++;
		fno=getfreeframe();
		if(fno!=-1)  //free frame available
		  {
		   pt[dpage].fno=fno;
		   pt[dpage].status='v';
		   freeframe[fno]=dpage;
		  }
		else //page replacement
		  {
		   vpage=deletenode();
		   pt[dpage].fno=pt[vpage].fno;
		   pt[vpage].status='i';
		   pt[dpage].status='v';
		   freeframe[pt[vpage].fno]=dpage;
		   }
		   appendnode(dpage);
		}
		 
	 printf("\nData of linked list ");     
	 displaynode();
		 
	 printf("\nData of freeframe");
	 for(j=0;j<n;j++)
		{	 
		if(freeframe[j]!=0)
			printf("\n%d",freeframe[j]);
		}    
	 printf("\nNumber of page fault is %d",pagefault);
	 getch();
    }
 return 0;
}

