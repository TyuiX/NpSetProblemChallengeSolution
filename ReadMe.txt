To create test file follow format on this site https://www3.cs.stonybrook.edu/~skiena/373/setcover/ or use these to test.

My solution at start was to use the set that contained the least appeared element as the foundation of the building blocked. Reason for this is because
if an element appeared once then you must have the subset inside your combination as that the only subset that has it. Same argument if there was 
two subset that has that least element appeared then one of those two must be in the solution for least appeared time. I use this method as building block
for my code where I use the least then find missing element then look at which element that missing appeared least then repeat.

Few Pruning techinque i used is having an counter to counter where if next recursion call return in combination size of k which is current number it on. Then
there no point go even further as the is the least out of all the possible combination. Another trick is have do with the combination size.
If the combination size that being built exceed the best solution that is currently stored then no point go even furthur to make combination. Last trick
was stored the set it alreadly vist, this reduce the time by a lot and the reason I do this is because it is eliminate dups because in the new picked subset
it may give an already tried combination but in different order.

Another unique thing I did was having U as an linkedlist and have the set as an hashmap to get the constant lookup time see if that element in U is in the set
if it not then I add it to the missing list. This help with reducing the check what missing in long run as U decrease in size. Last thing I did was create an object
that store the element and return what subset has that element. This allow me to know what subset has it already without checking it everytime.