Example 1:
n = 10      instrCounter = 100   (instrCounter / n) = 10
n = 100     instrCounter = 10000   (instrCounter / n) = 100
n = 1000    instrCounter = 1000000   (instrCounter / n) = 1000
n = 10000   instrCounter = 100000000   (instrCounter / n) = 10000

From this table I would estimate the example 1 program to be O(n^2). We can clearly see that instrCounter is  given by n^2 as when n = 10, instrCounter = 10^2 = 100. This relationship continues for increasing values of n.


Example 2:
n = 10      instrCounter = 55   (instrCounter / n) = 5
n = 100     instrCounter = 5050   (instrCounter / n) = 50
n = 1000    instrCounter = 500500   (instrCounter / n) = 500
n = 10000   instrCounter = 50005000   (instrCounter / n) = 5000

From this table I would estimate example 2 to also be O(n^2). We can see that instrCounter is given by approximately 0.5n^2. While this is not purely n^2, it is still quadratic in nature and so is considered O(n^2)

