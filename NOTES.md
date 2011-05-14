# Project Euler Notes


## Problem 14
This problem was the toughest so far. A potential solution wasn't that
difficult when the numbers were small. Once I started searching the
Collatz numbers up to 1,000,000 though, I started getting "Out of
Memory" errors and the time taken went up dramatically. I found
a write-up for the solution on a blog that used a loop to keep track
of the longest Collatz sequence rather than generating all of the
sequences and then finding the longest. So I did that and it worked
like a charm. 

Took from 28 to 35 seconds on the MacBook Air.

## Problem 15
This problem was resolving the number of paths along the edges of a
20x20 grid from the top left to the lower right. You can only go right
or down. I'm sure there's a way to brute force this, but it seemed
like the sort of problem that lends itself well to a mathematical
solution. I was searching for a general solution to the problem, not
something Project Euler-specific, but the first good result I got was
exactly that, someone's mathematical solution to this problem. 

But this person's
[solution[(http://www.joaoff.com/2008/01/20/a-square-grid-path-problem/)
had the insight to view it as a series of R(ight) and D(own) elements
in a string, or sequence, with an equal number of each element due to
it being a square. 

I'm sorry I managed to find an almost tailor-made solution, but it did
cause me to write a factorial function. For this function I decided to
use one of Clojure's features, preconditions for a function, to make
sure the input is a positive number. And doing Project Euler in
Clojure has two goals: learn more about functional programming and
Clojure and re-familiarize myself with mathematics, in some cases
learning entirely new concepts.  
