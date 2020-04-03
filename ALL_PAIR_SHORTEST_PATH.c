#include<stdio.h>
void main()
{
	int a[50][50],n,i,j,k,b[50][50];
	printf("Entered the No. of Vertices : \n");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("Entering the path between the vertices %d and %d : \n",i,j);
			scanf("%d",&a[i][j]);
		}
	}
	printf("The adjacent Matrix is : \n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%d \t",a[i][j]);
		}
		printf("\n");
	}
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			b[i][j]=a[i][j];
		}
	}
	for(k=1;k<=n;k++)
	{
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(b[i][j]>(b[i][k]+b[k][j]))
				{
					b[i][j]=(b[i][k]+b[k][j]);
				}
			}
		}
	}
	printf("The final matrix is : \n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%d \t",b[i][j]);
		}
		printf("\n");
	}
}
