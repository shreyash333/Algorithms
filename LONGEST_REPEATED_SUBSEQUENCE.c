
#include <stdio.h>
#include <string.h>

int print_lrs(char b[50][50], char x[50], int i, int j )
{
	if(i ==0 || j ==0)
		return 	0;
	if(b[i][j] == 'd')
	{
		print_lrs(b,x,i-1,j-1);
		printf("%c",x[i-1]);
	}
	else if(b[i][j] == 'u')
	{	
		print_lrs(b,x,i-1,j);
	}
	else if(b[i][j] == 'l')
	{
		print_lrs(b,x,i,j-1);
	}
	
}
int LRS(char str[50])
{
    int n = strlen(str);
    int M[n + 1][n + 1];
    char D[n+1][n+1];
    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++)
            M[i][j] = 0;

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++)
            D[i][j] = '-';

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (str[i - 1] == str[j - 1] && i != j)
            {
                M[i][j] = 1 + M[i - 1][j - 1];
                D[i][j] = 'd';
            }
            else if(M[i][j - 1] > M[i - 1][j] )
            {
                M[i][j] = M[i][j - 1];
                D[i][j] = 'l';
            }
            else if(M[i][j - 1] <= M[i - 1][j])
            {
                M[i][j] = M[i - 1][j];
                D[i][j] = 'u';
            }
        }
    }

    printf("\nCost matrix is : \n");
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            printf("%d\t",M[i][j]);
        }
        printf("\n");
    }
char b[50][50];
    printf("\nDirection Matrix is : \n");
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            printf("%c\t",D[i][j]);
            b[i][j] = D[i][j];
        }
        printf("\n");
    }
    
    printf(" \nThe Longest Repeated Subsequence is : ");
    print_lrs(b,str,n,n);
    printf("\n");
    return M[n][n];
}

void main()
{
    char x[50];
    int n;
    printf("Enter the string ");
    scanf("%s", x);
    n = LRS(x);
    printf(" Lenght of Subsequence is : %d ", n);
}
