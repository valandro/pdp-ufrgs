#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#define MAX_THREADS 3

void mm_omp(double *A, double *B, double *C, int n) 
{	
	{
		int i, j, k;
        #pragma omp parallel for private(i,j,k) shared(A,B,C)
		for (i = 0; i < n; i++) { 
			for (j = 0; j < n; j++) {
				double dot  = 0;
				#pragma omp parallel for reduction(+:dot) private(k)
				for (k = 0; k < n; k++) {
					dot += A[i*n+k]*B[k*n+j];
				} 
				C[i*n+j] = dot;
			}
		}
		
	}
}

int main() {
	int i, n;
	double *A, *B, *C, dtime;

	n = 750;
	A = (double*)malloc(sizeof(double)*n*n);
	B = (double*)malloc(sizeof(double)*n*n);
	C = (double*)malloc(sizeof(double)*n*n);

	for(i=0; i<n*n; i++) { 
        A[i] = rand()/RAND_MAX; 
        B[i] = rand() / RAND_MAX;
    }

	dtime = omp_get_wtime();
    omp_set_num_threads(MAX_THREADS);
	mm_omp(A,B,C, n);
	dtime = omp_get_wtime() - dtime;
	printf("%f\n", dtime);

    return 0;

}