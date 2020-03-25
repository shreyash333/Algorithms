#include<stdio.h>
void main(){
	int i,p[50],a[50],n,m,t,s,j;
	float r[50],f=0,w[50],W;
	printf("Enter the capacity of knapsack ");
	scanf("%f",&W);
	printf("Enter the number of elements ");
	scanf("%d",&n);
	float x[n];
	for(i=0; i<n; i++)
	{
		x[i] = 0.000;
	}
	printf("Enter the sequence number of elements ");
	for(i=0; i<n; i++)
	{
		scanf("%d",&a[i]);
	}
	printf("Enter the weights of elements ");
	for(i=0; i<n; i++)
	{
		scanf("%f",&w[i]);
	}
	printf("Enter the profit of elements ");
	for(i=0; i<n; i++)
	{
		scanf("%d",&p[i]);
	}
	for(i=0; i<n; i++)
	{
		r[i] = p[i]/w[i];
	}
	for(i=0; i<n; i++)
	{
		s=0;
		t = s+1;
		for(j=0; j<n-i; j++)
		{
			if(r[s] < r[t])
			{
				m = r[s];
				r[s] = r[t];
				r[t] = m;
				m = w[s];
				w[s] = w[t];
				w[t] = m;
				m = p[s];
				p[s] = p[t];
				p[t] = m;
				m = a[s];
				a[s] = a[t];
				a[t] = m;
			}
			s++;
			t++;
		}
	}
	float q =0;
	int d = 0;
	for(i=0; i<n; i++)
	{
		if(w[i] < W)
		{
			x[a[i]] = 1.00;
			d++;
			W = W - w[i];
			q = q + p[i];
		}
		else if(W<w[i] && W!=0)
		{	
			f = W/w[i];
			//printf("%f\t%f\t%f",W,w[i],f);
			x[a[i]] = f ;
			W = W - f*w[i];
 			q = q + f*p[i];
		}
			
	}
	printf("\n");
	printf("Solution vector is ");
	for(i=1; i<n+1; i++)
	{
		printf("%f\t",x[i]);
	}
	printf("\n");
	printf("Total profit = %f ",q);
	printf("\n");
	printf("Knapsack capacity = %f ",W);
}
		

















