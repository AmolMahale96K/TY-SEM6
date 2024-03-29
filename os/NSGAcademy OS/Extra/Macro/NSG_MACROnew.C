#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct MNT  //macro name table
{
 char MName[20];
 int PP,KP,MDTP,KPDTP,PNTP;
}mnt[5];

char PNT[15][15]; //all parameters name table
char APT[15][15]; //actual parameter table

struct KPDT		//keyword parameter default table
{
 char PName[15],Def[15];
}kpdt[15];

struct MDT  // macro definition table
{
 char Opcode[15],Value[35];
}mdt[30];


int  MNT_Ptr,PNT_Ptr,KPDT_Ptr,MDT_Ptr,APT_Ptr;

int  i,j,m,n,k=0;

char fname[20];
char buffer[80], tok1[35], tok2[35], tok3[35];
char temp[40], temp1[40], temp2[40], temp3[40];

FILE *fp;

int SearchPNT(char *s)
{
 for(m=0;m<PNT_Ptr;m++)
    if(strcmp(PNT[m],s)==0)
      return(m);

 return(-1);
}

int SearchKPDT(char *s)
{
 for(m=0;m<KPDT_Ptr;m++)
    if(strcmp(kpdt[m].PName,s)==0)
      return(m);

 return(-1);
}

int SearchMNT(char *s)
{
	for(m=0; m<MNT_Ptr; m++)
		if(strcmp(s,mnt[m].MName)==0)
			return(m);

	return(-1);
}

void displaypnt()
{
 printf("\n---PNT TABLE---");
 printf("\n#\tPName");
 printf("\n-------------------------------------");
 for(m=0;m<PNT_Ptr;m++)
    printf("\n%d    %s",m,PNT[m]);
 printf("\n-------------------------------------");
 getch();
}

void displaymnt()
{
 printf("\n----------MACRO NAME TABLE--------------------------");
 printf("\n#\tMName\t#PP\t#KP\t#MDTP\tKPDTP\tPNTP");
 printf("\n----------------------------------------------------");
 for(m=0;m<MNT_Ptr;m++)
    printf("\n%d\t%s\t%d\t%d\t%d\t%d\t%d",
	   m,mnt[m].MName,mnt[m].PP,mnt[m].KP,mnt[m].MDTP,mnt[m].KPDTP,mnt[m].PNTP);
 printf("\n----------------------------------------------------");
 getch();
}

void displaykpt()
{
 printf("\n---KEYWORD PARAMETER DEFAULT TABLE---");
 printf("\n#\tPName\tDef");
 printf("\n-------------------------------------");
 for(m=0;m<KPDT_Ptr;m++)
    printf("\n%d\t%s\t%s",m,kpdt[m].PName,kpdt[m].Def);
 printf("\n-------------------------------------");
 getch();
}

void Print_MDT()
{
 printf("\n-----------MACRO DEFINITION TABLE--------------");
 printf("\n#\tOpcode\tOperand");
 printf("\n-----------------------------------------------");
 for(m=0;m<MDT_Ptr;m++)
    printf("\n%d\t%s\t%s",m,mdt[m].Opcode,mdt[m].Value);
 printf("\n-----------------------------------------------");
 getch();
}

void Print_APT()
{
 printf("\n Actual Parameter name table");
 printf("\n------------------------");
 for(m=0;m<PNT_Ptr;m++)
	printf("\n %s",APT[m]);
 printf("\n");
 printf("-----------------------\n");
 getch();
}

void Clear_APT()
{
 for(m=0;m<PNT_Ptr;m++)
    strcpy(APT[m],"");
}

void Make_MDT()
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

 k = SearchPNT(tok1);
 if(k==-1)
   {
   sprintf(temp3,"%s",tok1);
   }
 else
   {
	sprintf(temp3,"(P,%d)",k+1);
	//sprintf(temp3,"%s",kpdt[m].Def);
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

 k = SearchPNT(tok2);
 if(k==-1)
   {
    printf("\nError: Parameter %s not found",tok2);
    exit(0);
   }
 sprintf(temp,"(P,%d)",k+1);

 k = SearchPNT(tok3);
 if(k==-1)
   {
    printf("\nError: Parameter %s not found",tok3);
    exit(0);
   }
 sprintf(temp1,"%s, (P,%d)",temp,k+1);

 strcpy(mdt[MDT_Ptr].Opcode,temp3);
 strcpy(mdt[MDT_Ptr++].Value,temp1);
}

void Make_APT(int n)
{
 i=j=0;
 APT_Ptr=mnt[n].PNTP;

 strcat(tok2,",");
 while(tok2[j] && tok2[j]!='=')
      {
	  if(tok2[j]==',')
		{
		 temp[i]='\0';
		 i=0;
		 strcpy(APT[APT_Ptr],temp);
		 APT_Ptr++;
		}
	 else
		temp[i++] = tok2[j];

	 j++;
 }
 /*
 if(APT_Ptr!=mnt[k].PP)
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
		  APT_Ptr=SearchPNT(temp);
		 }
	   else if(tok2[j]==',')
			  {
			   temp[i]='\0';
			   i=0;
			   strcpy(APT[APT_Ptr++],temp);

			  }
			else
			   temp[i++] = tok2[j];

			j++;
	  }
// Print_APT();
}

void Expand(int n)
{
 int a,b,c,MEC,x,p;
 char t[20];
 MEC = mnt[n].MDTP;
// p=mnt[n].MDTP;
 while(strcmp(mdt[MEC].Opcode,"MEND")!=0)
      {
		strcpy(temp3,mdt[MEC].Opcode);
		strcpy(tok3,temp3);
		if(tok3[0]=='(')
		  {
		   tok3[strlen(tok3)-1]='\0';
		   c = atoi(strstr(tok3,",")+1);
		   if(strcmp(APT[c-1],"")==0)
		     {
		      strcpy(t,PNT[c-1]);
		      x=SearchKPDT(t);
		      strcpy(temp3,kpdt[x].Def);
		     }
		   else
		     {
		      sprintf(temp3,APT[c-1]);
		     }
		  }

		sscanf(mdt[MEC].Value,"%s %s",tok1,tok2);

		tok2[strlen(tok2)-1]='\0';
		a = atoi(strstr(tok2,",")+1);
		tok1[strlen(tok1)-2]='\0';
		b = atoi(strstr(tok1,",")+1);

		if(strcmp(APT[b-1],"")==0)
		  {
		   strcpy(t,PNT[b-1]);
		   x=SearchKPDT(t);
		   sprintf(temp,"%s %s",kpdt[x].Def,APT[a-1]);
		  }
		else
		  sprintf(temp,"%s %s",APT[b-1],APT[a-1]);

		printf("%s\t%s\n",temp3,temp);
		getch();

		MEC++;
	  }
}

void Make_KPDT_PNT(char *s)
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
		  k = SearchPNT(temp);
		  if(k==-1)
			strcpy(PNT[PNT_Ptr++],temp);
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
 mnt[MNT_Ptr].PP = j;
 j=0;  //initialize counter again now it will count keyword parameter

 while(*s)  //for all keyword parameter
       {
		if(*s=='=')
		  {
		   temp[i]='\0';  //end of temp
		   i=0; //location of temp
		   k = SearchPNT(temp);
		   if(k==-1)
			 {
			  strcpy(PNT[PNT_Ptr++],temp);
			  strcpy(kpdt[KPDT_Ptr].PName,temp);
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
			 strcpy(kpdt[KPDT_Ptr++].Def,temp);
			}
		else if(*s!='&')	//do not copy &
			temp[i++]=*s;
		s++;
		}
 mnt[MNT_Ptr].KP = j;
}


void separate()
{
 while(fgets(buffer,80,fp))
      {
       n = sscanf(buffer,"%s %s %s",tok1,tok2,tok3);
       if(strcmp(tok1,"MACRO")==0 && n==1)
		 {
		  fgets(buffer,80,fp);
		  sscanf(buffer,"%s %s",tok1,tok2);
		  strcpy(mnt[MNT_Ptr].MName,tok1); //copy macro name
		  mnt[MNT_Ptr].KPDTP=KPDT_Ptr;
		  mnt[MNT_Ptr].MDTP = MDT_Ptr;
		  mnt[MNT_Ptr].PNTP=PNT_Ptr;

		  Make_KPDT_PNT(tok2);
		 }
       else if(strcmp(tok1,"MEND")==0 && n==1)
		 {
			  strcpy(mdt[MDT_Ptr].Opcode,"MEND");
		  strcpy(mdt[MDT_Ptr++].Value,"");
		  MNT_Ptr++;
		 }
	   else if(tok3[0]=='&' && n==3)  //creation of macro definition table
		       Make_MDT();
		     else
				{
				 k = SearchMNT(tok1);
				 if(k==-1)
					printf("%s",buffer);
				 else
				   {
					Make_APT(k);
					Expand(k);
				     //	Clear_APT();
					}
				}

	  }
}

void main(int argc,char *argv[])
{
 clrscr();
 if(argc==2)
   {
    strcpy(fname,argv[1]);
   }
 else
   {
    printf("\nEnter filename:");
    scanf("%s",fname);
   }
 fp=fopen(fname,"r");
 separate();
 displaymnt();
 displaypnt();
 displaykpt();
 Print_MDT();
// Print_APT();
 fclose(fp);
}
