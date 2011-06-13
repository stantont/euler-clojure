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
[solution](http://www.joaoff.com/2008/01/20/a-square-grid-path-problem/)
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

## Problem 16
Problem 16 was adding up all the digits in 2 to 1000th power. The easy
way would have been to convert it to a string and just pull the
individual characters. But I wanted to do it mathematically, so I
created a function that incrementally takes the modulo of a power of
10.

I was poking around and found a function to get the number of digits
in a number using the log10, which I thought I might use, but it
wasn't necessary. I'll keep it around in case I need it in the
future. 

## Problem 17
I changed tactics on this one part way through. I created a function
to take the parts of a number including all the zeroes for the tens
places, but then it seemed silly that I was then going to have to then
reduce it to remove the parts of ten. I initially was going to do a
simple look-up for the numbers above one hundred, but I changed it to
make it more general purpose and work for numbers above one hundred. I
reused the function that breaks the number into individual digits, but
reversed it so the digits are in their correct 10 to the "x" place going left
to right. So for the number 12, you get (2, 1), which is 
(2 * (10 ** 0)) + (1 * (10 ** 1)). I broke the digits into groups of three
so you get the hundreds, thousands, millions, etc., groups. 

The function to convert each group of three digits to words seems to
not be very "functional" to me since I was having to refer to the next
or previous digit.

I used map-indexed to return the placement of each group of three in
the number, then join them together with "and". Not sure that's really
correct for the words, but since I only needed to go up to one
thousand anyway, I figure I'll modify it in the future if I need to.

I was starting to think I should make tests for the solutions so if I
wind up having to change one of the "core" functions, it could affect
several solutions using that function.

I'm also not using the correct words for some of the terms in my
code. So many things I've forgotten about basic mathematics. I'll
hopefully correct them as I go along and find the correct terminology
in my reading.
