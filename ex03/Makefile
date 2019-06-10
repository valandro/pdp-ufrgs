CPP = /usr/local/opt/llvm/bin/clang
LDFLAGS = -L/usr/local/opt/llvm/lib

clean: clean-pi clean-matrix

matrix:
	$(CPP) -fopenmp $(LDFLAGS) matrix.c -o matrix
clean-matrix:
	rm matrix 
pi: 
	$(CPP) -fopenmp $(LDFLAGS) pi.c -o pi
clean-pi:
	rm pi
