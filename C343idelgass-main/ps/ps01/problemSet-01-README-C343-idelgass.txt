B)
	1. 	a = b + c; // Const
		d = a + e; // Const

		Theta(1), the running time of an assignment is constant.


	2.	sum = 0; // Const
		for (i=0; i<9; i++) // Const
    			for (j=0; j<n; j++) // Runs n times (technically 9n but just analyzing individual components here)
      			sum++; //Const

		Theta(n), the running time of the i loop has a constant stopping condition while the j loop varies with n.


	3.	sum=0; // Const
		for (i=0; i<n*n; i++) //Runs n^2 times
  			sum++; //Const

		Theta(n^2), the for loop has a stopping condition of n*n = n^2 and so will vary with n^2.
	

	4.	for (i=0; i < n-1; i++) // Runs approx. n times
    			for (j=0; j < i; j++) { // Runs n times at max i
        				tmp = AA[i][j]; // Const
        				AA[i][j] = AA[j][i]; // Const
        				AA[j][i] = tmp; // Const
   		 	}

		Theta(n^2), outer loop times inner loop is n*n = n^2


	5.	sum = 0; // Const
		for (i=1; i<=n; i++) // Runs n times
    			for (j=1; j<=n; j*=2) // Runs log_2(n) times
       	 			sum++; // Const

		Theta(nlogn), outer loop times inner loop is n*log(n) (the base of the log is unimportant for time complexity analysis)


	6.	sum = 0; // Const
		for (i=1; i<=n; i*=2) // Runs log_2(n) times
    			for (j=1; j<=i; j++) // Runs max log_2(n) times (outer loop)
        				sum++; // Const
		
		Theta((logn)^2), outer loop times inner loop is logn * logn}


C)
	2.	// Assuming list = {2, 23, 15, 5, 9}
		list.moveToPos(2);
		list.remove();

	3.	a. The data field is two bytes, a pointer is four bytes, and the array holds 30 elements.
		
			Array will take (data field) * (array size) = 2 * 30 = 60 bytes
			Linked list node will take (data field) + (pointer) = 4 + 2 = 6 bytes
			Break even point will happen at n * 6 = 60 -> n = 10 nodes
			So if n < 10 we should use linked list

		b. The data field is one byte, a pointer is four bytes, and the array holds 30 elements.

			Array will take 1*30 = 30 bytes
			Linked list node will take 1 + 4 = 5 bytes
			Break even point will happen at n * 5 = 30 -> n = 6 nodes
			So if n < 6 we should use linked list

		c. The data field is 32 bytes, a pointer is four bytes, and the array holds 40 elements.

			Array will take 32*40 = 1280 bytes
			Linked list node will take 32 + 4 = 36 bytes
			Break even point will happen at n * 36 = 1280 -> n = 35.56 nodes
			So if n < 36 we should use linked list 
D)
	1. Arrange the following expressions by the growth rate, from slowest to fastest

		2, log_3(n), log_2(n), x^(2/3), 20n, 4n^2, 3^n, n!

	2. Using the definitions of Big-O, find the upper bound for the following expressions
		
		c_1 * n : O(n)
		c_2 * n^3 + c_3 : O(n^3)
		c_4 * n * log_2(n) + c_5 * n : O(nlogn)
		c_6 * 2^n + c_7 * n^6 : 2^n

			