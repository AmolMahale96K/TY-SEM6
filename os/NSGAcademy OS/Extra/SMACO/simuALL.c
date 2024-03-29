#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char fname[20];
FILE* fp;

int pc,lc,flag;

long mem[1000];
int reg[4];
int cc[6]={0,0,0,0,0,1};

int address;
long content;
int opcode,r,operand;

void load()
{
 fp=fopen(fname,"r");
 if(fp==NULL)
    printf("\n%s file is not found",fname);
 else
   {
    while(!feof(fp))
	     {
	      fscanf(fp,"%d %ld\n",&address,&content);

	      if(address==-1)
		     pc=content;
	      else
		    {
			 lc=address;
		     mem[lc]=content;
		    }
	     }
    fclose(fp);
   }
}

void print()
{
 int i;
 for(i=pc;i<=lc;i++)
     printf("\n%ld",mem[i]);
}

void accept()
{
 fp=fopen(fname,"w");
 printf("\nWrite Smaco code");

 do
 {
  printf("\nEnter address:");
  scanf("%d",&address);
  printf("\nEnter content:");
  scanf("%ld",&content);

  fprintf(fp,"%d %ld\n",address,content);

  if(address==-1)
	 pc=content;
  else
	{
	 lc=address;
	 mem[lc]=content;
	}
 }while(address!=-1);
 fclose(fp);
}

void execute()
{
int i;
while(pc)
	{
	 opcode=mem[pc]/10000;
	 r=(mem[pc]%10000)/1000-1;
	 operand=(mem[pc]%10000)%1000;
	 switch(opcode)
		   {
			case 0 : pc=-1;
					 break;
				
			case 1 : reg[r]=reg[r]+mem[operand];
					 break;

			case 2 : reg[r]=reg[r]-mem[operand];
					 break;

			case 3 : reg[r]=reg[r]*mem[operand];
					 break;

			case 4 : reg[r]=mem[operand];
					 break;

			case 5 : mem[operand]=reg[r];
					 break;

			case 6 : if(reg[r]<mem[operand])
						cc[0]=1;
					 if(reg[r]<=mem[operand])
						cc[1]=1;
					 if(reg[r]==mem[operand])
						cc[2]=1;
					 if(reg[r]>mem[operand])
						cc[3]=1;
					 if(reg[r]>=mem[operand])
						cc[4]=1;
						
					 break;

			case 7 : if(cc[r]==1)
						pc=operand-1;
					 for(i=0;i<5;i++)
						cc[i]=0;
					 break;
					 
			case 8 : reg[r]=reg[r]/mem[operand];
					 break;

			case 9 : printf("\nEnter value:");
					 scanf("%ld",&mem[operand]);
					 break;

			case 10: printf("\nValue is %ld",mem[operand]);
					 break;
		}
	if(flag==1)
	  {
	   printf("\nConditional Register");
	   printf("\nLT LE EQ GT GE ANY\n");
	   for(i=0;i<6;i++)
	       printf("%d  ",cc[i]);

	   printf("\nRegisters");
	   printf("\nAREG\tBREG\tCREG\tDREG\n");
	   for(i=0;i<4;i++)
	      printf("%d\t",reg[i]);
	   getch();
	  }
	pc++;
	}
}

void main(int argc,char* argv[])
{
 int ch;
 clrscr();

 strcpy(fname,argv[1]);

 do
 {
  printf("\n1: Load");
  printf("\n2: Print");
  printf("\n3: Accept");
  printf("\n4: Run");
  printf("\n5: Trace");
  printf("\n6: Quit");

  printf("\nEnter your choice:");
  scanf("%d",&ch);

  switch(ch)
	    {
		 case 1:load();
				break;
		 case 2:print();
				break;
		 case 3:accept();
				break;
		 case 4:execute();
				break;
		 case 5:flag=1;
				execute();
				break;
		}
 }while(ch!=6);
}