#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct MNT  //macro name table
{
 char mname[20];
 int pp,kp,mdtp,kpdtp,pntp;
}mnt[5];

char pnt[15][15]; //all parameters name table
char apt[15][15]; //actual parameter table

struct KPDT	 //keyword parameter default table
{
 char pname[15],def[15];
}kpdt[15];

struct MDT  	// macro definition table
{
 char opcode[15],value[35];
}mdt[30];


int mnt_ptr,pnt_ptr,kpdt_ptr,mdt_ptr,apt_ptr;

int m,n,k;

char fname[20];
char buffer[80], tok1[35], tok2[35], tok3[35];
char temp[40], temp1[40], temp2[40], temp3[40];

FILE *fp;

int searchPNT(char *s)
{
 int i;
 for(i=0;i<pnt_ptr;i++)
    if(strcmp(pnt[i],s)==0)
       return i;

 return -1;
}

int searchKPDT(char *s)
{
 int i;
 for(i=0;i<kpdt_ptr;i++)
    if(strcmp(kpdt[i].pname,s)==0)
       return i;

 return -1;
}

int searchMNT(char *s)
{
 int i;
 for(i=0;i<mnt_ptr;i++)
    if(strcmp(mnt[i].mname,s)==0)
       return i;

 return -1;
}

void displayPNT()
{
 int i;
 printf("\n---PNT TABLE---");
 printf("\n#\tPName");
 printf("\n-------------------------------------");
 for(i=0;i<pnt_ptr;i++)
     printf("\n%d    %s",i,pnt[i]);
 printf("\n-------------------------------------");
 getch();
}

void displayMNT()
{
 int i;
 printf("\n----------MACRO NAME TABLE--------------------------");
 printf("\n#\tMName\t#PP\t#KP\t#MDTP\tKPDTP\tPNTP");
 printf("\n----------------------------------------------------");
 for(i=0;i<mnt_ptr;i++)
    printf("\n%d\t%s\t%d\t%d\t%d\t%d\t%d",
    i,mnt[i].mname,mnt[i].pp,mnt[i].kp,mnt[i].mdtp,mnt[i].kpdtp,mnt[i].pntp);
 printf("\n----------------------------------------------------");
 getch();
}

void displayKPT()
{
 int i;
 printf("\n---KEYWORD PARAMETER DEFAULT TABLE---");
 printf("\n#\tPName\tDef");
 printf("\n-------------------------------------");
 for(i=0;i<kpdt_ptr;i++)
     printf("\n%d\t%s\t%s",i,kpdt[i].pname,kpdt[i].def);
 printf("\n-------------------------------------");
 getch();
}

void printMDT()
{
 int i;
 printf("\n-----------MACRO DEFINITION TABLE--------------");
 printf("\n#\tOpcode\tOperand");
 printf("\n-----------------------------------------------");
 for(i=0;i<mdt_ptr;i++)
     printf("\n%d\t%s\t%s",i,mdt[i].opcode,mdt[i].value);
 printf("\n-----------------------------------------------");
 getch();
}

void printAPT()
{ 
 int i;
 printf("\n Actual Parameter name table");
 printf("\n------------------------");
 for(i=0;i<pnt_ptr;i++)
     printf("\n %s",apt[i]);
 printf("\n");
 printf("-----------------------\n");
 getch();
}

void makeMDT()
{
 m=0;
 if(tok1[0]=='&')
   {
    while(m<strlen(tok1))
		 {
		  tok1[m]=tok1[m+1];  //left shift to remove &
		  m++;
		 }
   }
 k=searchPNT(tok1);
 if(k==-1)
    sprintf(temp3,"%s",tok1);
 else
    {
     sprintf(temp3,"(P,%d)",k+1);
     //sprintf(temp3,"%s",kpdt[m].def);
    }

 m=0;
 while(m<strlen(tok2))
      {
       tok2[m]=tok2[m+1];  //left shift to remove &
       m++;
      }

 m=0;
 while(m<strlen(tok3))
      {
       tok3[m]=tok3[m+1]; //left shift to remove &
       m++;
      }

 k=searchPNT(tok2);
 if(k==-1)
   {
    printf("\nError: Parameter %s not found",tok2);
    exit(0);
   }
 sprintf(temp,"(P,%d)",k+1);

 k=searchPNT(tok3);
 if(k==-1)
   {
    printf("\nError: Parameter %s not found",tok3);
    exit(0);
   }
 sprintf(temp1,"%s, (P,%d)",temp,k+1);

 strcpy(mdt[mdt_ptr].opcode,temp3);
 strcpy(mdt[mdt_ptr++].value,temp1);
}

void makeAPT(int n)
{
 int i=0,j=0;

 apt_ptr=mnt[n].pntp;

 strcat(tok2,",");
 while(tok2[j] && tok2[j]!='=')
      {
       if(tok2[j]==',')
		 {
		  temp[i]='\0';
		  i=0;
		  strcpy(apt[apt_ptr],temp);
		  apt_ptr++;
		 }
       else
		  temp[i++] = tok2[j];
		  j++;
      }
 /*
 if(apt_ptr!=mnt[k].pp)
   {
	printf("\nPosition Parameters Missing");
	exit(0);
   }
 */
 while(tok2[j])
      {
       if(tok2[j]=='=')
		 {
		  temp[i]='\0';  //end of temp
		  i=0; //location of temp
		  apt_ptr=searchPNT(temp);
		 }
       else if(tok2[j]==',')
			  {
			   temp[i]='\0';
			   i=0;
			   strcpy(apt[apt_ptr++],temp);
			   }
			else
			   temp[i++]=tok2[j];
		   j++;
      }
// printAPT();
}

void expand(int n)
{
 int a,b,c,MEC,x,p;
 char t[20];
 MEC=mnt[n].mdtp;

 while(strcmp(mdt[MEC].opcode,"MEND")!=0)
      {
       strcpy(temp3,mdt[MEC].opcode);
       strcpy(tok3,temp3);
       if(tok3[0]=='(')
		 {
		  tok3[strlen(tok3)-1]='\0';
		  c=atoi(strstr(tok3,",")+1);
		  if(strcmp(apt[c-1],"")==0)
			{
			 strcpy(t,pnt[c-1]);
			 x=searchKPDT(t);
			 strcpy(temp3,kpdt[x].def);
			}
		  else
			 sprintf(temp3,apt[c-1]);
	 }

       sscanf(mdt[MEC].value,"%s %s",tok1,tok2);
       tok2[strlen(tok2)-1]='\0';
       a=atoi(strstr(tok2,",")+1);
       tok1[strlen(tok1)-2]='\0';
       b=atoi(strstr(tok1,",")+1);

       if(strcmp(apt[b-1],"")==0)
		 {
		  strcpy(t,pnt[b-1]);
		  x=searchKPDT(t);
		  sprintf(temp,"%s %s",kpdt[x].def,apt[a-1]);
		 }
       else
		  sprintf(temp,"%s %s",apt[b-1],apt[a-1]);

       printf("%s\t%s\n",temp3,temp);
       getch();

       MEC++;
      }
}

void makeKPDT_PNT(char *s)
{
 int i=0,j=0,k=0;
 strcat(s,",");
 while(*s && *s!='=')  //for all positional parameter
      {
       if(*s==',')
		 {
		  temp[i]='\0';  //end of temp
		  j++;  //count number of positional parameter
		  i=0;  //location of temp
		  k=searchPNT(temp);
		  if(k==-1)
			 strcpy(pnt[pnt_ptr++],temp);
		  else
			{
			 printf("\nError: Multiple Declaration of Symbol %s in Argument List",temp);
			 exit(0);
			}
		 }
       else if(*s!='&')  //donot copy &
			   temp[i++]=*s;
       s++;
      }
 mnt[mnt_ptr].pp = j;
 j=0;  //initialize counter again now it will count keyword parameter

 while(*s)  //for all keyword parameter
      {
       if(*s=='=')
		 {
		  temp[i]='\0';  //end of temp
		  i=0; //location of temp
		  k=searchPNT(temp);
		  if(k==-1)
			{
			 strcpy(pnt[pnt_ptr++],temp);
			 strcpy(kpdt[kpdt_ptr].pname,temp);
			}
		  else
			{
			 printf("\nError: Multiple Declaration of Symbol %s in Argument List",temp);
			 exit(0);
			}
		 }
       else if(*s==',')
			  {
			   temp[i]='\0';
			   j++; //count number of keyword parameter
			   i=0;
			   strcpy(kpdt[kpdt_ptr++].def,temp);
			  }
	    else if(*s!='&')	//do not copy &
				temp[i++]=*s;
       s++;
      }
 mnt[mnt_ptr].kp=j;
}

void separate()
{
 while(fgets(buffer,80,fp))
      {
       n=sscanf(buffer,"%s %s %s",tok1,tok2,tok3);
       if(strcmp(tok1,"MACRO")==0 && n==1)
		 {
		  fgets(buffer,80,fp);
		  sscanf(buffer,"%s %s",tok1,tok2);
		  strcpy(mnt[mnt_ptr].mname,tok1); //copy macro name
		  mnt[mnt_ptr].kpdtp=kpdt_ptr;
		  mnt[mnt_ptr].mdtp = mdt_ptr;
		  mnt[mnt_ptr].pntp=pnt_ptr;

		  makeKPDT_PNT(tok2);
		 }
       else if(strcmp(tok1,"MEND")==0 && n==1)
			  {
			   strcpy(mdt[mdt_ptr].opcode,"MEND");
			   strcpy(mdt[mdt_ptr++].value,"");
			   mnt_ptr++;
			  }
	   else if(tok3[0]=='&' && n==3)  //creation of macro definition table
			   makeMDT();
	   else
		   {
		    k = searchMNT(tok1);
		    if(k==-1)
		       printf("%s",buffer);
		    else
		       {
				makeAPT(k);
				expand(k);
		       }
		    }
      }
}

void main(int argc,char *argv[])
{
 clrscr();
 if(argc==2)
    strcpy(fname,argv[1]);
 else
   {
    printf("\nEnter filename:");
    scanf("%s",fname);
   }
 fp=fopen(fname,"r");

 separate();
 displayMNT();
 displayPNT();
 displayKPT();
 printMDT();
 fclose(fp);
}
