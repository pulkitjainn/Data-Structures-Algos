Dynamic Programming

Dated : July 18

//Fibonacci

void _initialize()
  {
    for (int i = 0; i < MAX; i++)
        lookup[i] = -1;
  }
 
  int fib(int n)
  {
    if (lookup[n] == -1)
    {
      if (n <= 1)
          lookup[n] = n;
      else
          lookup[n] = fib(n-1) + fib(n-2);
    }
    return lookup[n];
  }