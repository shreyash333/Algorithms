#include<stdio.h>
#include<string.h>

int print_lcs(char b[50][50], char x[50], int i, int j)
{
	if(i==0 || j ==0)
		return 	0;
	if(b[i][j] == 'd')
	{
		print_lcs(b,x,i-1,j-1);
		printf("%c",x[i-1]);
	}
	else if(b[i][j] == 'u')
	{	
		print_lcs(b,x,i-1,j);
	}
	else
	{
		print_lcs(b,x,i,j-1);
	}
	
}

lcs_length(char x[50], char y[50])
{
	int m,n,i,j;
	
	m = strlen(x)+1;
	n = strlen(y)+1;
	int c[50][50];
	char b[50][50];
	for(i=0; i<n; i++)
	{
		c[i][0] = 0;
		b[i][0] = '-';
	}
	for(j=0; j<n; j++)
	{
		c[0][j] = 0;
		b[0][j] = '-';
	}
	for(i=1; i<m; i++)
	{
		for(j=1; j<n; j++)
		{
			if(x[i-1] == y[j-1])
			{
				c[i][j] = c[i-1][j-1]+1;
				b[i][j] = 'd';
			}
			else if(c[i-1][j] >= c[i][j-1])
			{
				c[i][j] = c[i-1][j];
				b[i][j] = 'u';
			}
			else
			{
				c[i][j] = c[i][j-1];
				b[i][j] = 'l';
			}
		}
	}
	printf("The cost matrix is \n");
	for(i=0; i<m; i++)
	{
		for(j=0; j<n; j++)
		{
			printf("%d\t",c[i][j]);
		}
		printf("\n");
	}
	printf("The direction matrix is \n");
	for(i=0; i<m; i++)
	{
		for(j=0; j<n; j++)
		{
			printf("%c\t",b[i][j]);
		}
		printf("\n");
	}
	printf("The Longest common subsequence is \n");
	//printf("m and n = %d\t%d\n",m,n);
	print_lcs(b,x,m-1,n-1);
	printf("\n");
}
		
void main()
{
	char x[50],y[50];
	printf("Enter the first string ");
	scanf("%s",x);
	printf("Enter the second string ");
	scanf("%s",y);
	lcs_length(x,y);
}






