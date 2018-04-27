// Do not remove or rename the package
package lists

/*
* The following functions are helper functions that I am providing
*/

/*
* Extend the List class with a "tail" getter to get the tail of a list.
* Below is an example of how you would use tail
*    val a = listOf(1,2,3)
*    val t = a.tail
*    println("tail of $a is $t") // prints [2,3]
*/
val <T> List<T>.tail: List<T>
    get() = drop(1)

/*
* Extend the List class with a "head" getter to get the head of a list.
* Below is an example of how you would use head
*    val a = listOf(1,2,3)
*    val h = a.head
*    println("head of $a is $h") // prints 1
*/
val <T> List<T>.head: T
    get() = first()

/*
* The isPrime function takes as input an Int
*      x : an Int object to test
* and returns a Boolean
*      true  if x is a prime
*      false if x is not a prime
*/
fun isPrime(x : Int) : Boolean {
    for (i in 2..(x-1)) {
        if (x % i == 0) {
            return false
        }
    }
    return true
}

/* The compose function takes as input
*     f - A function that takes as input a value of type T and returns a value of type T
*     g - A function that takes as input a value of type T and returns a value of type T
*  and returns as output the composition of the functions
*     f(g(x))
*/
fun<T> compose(f: (T)->T,  g:(T) -> T) : (T) -> T = { f(g(it)) }

/* Be sure to document
   your functions
   describing inputs and outputs and what the function does
*/
fun countingNumbers(limit : Int?) : List<Int>? {
    if(limit==0) return emptyList()
    if(limit==null)return null;
    // print (( 1..limit  ).toList());

    return (( 1..limit  ).toList())
}
fun evenNumbers(inputval : Int?):List<Int>?{
    if(inputval==0) return emptyList()
    if(inputval==null)return null;
    val EvenList=(1..inputval).toList()
    return EvenList.filter { it % 2==0 }
}
fun primeNumbers (inputval : Int?):List<Int>?{
    if(inputval==0) return emptyList()
    if(inputval==null)return null;
    val EvenList=(1..inputval).toList()
    return EvenList.filter { isPrime(it) }
}
fun<T : Comparable<T>> merge (a : List<T>?, b : List<T>?) : List<T>?{
    if(a==null)return null;
    if(b==null)return null;
    val fullList =  ArrayList<T>()
    fullList.addAll(a);
    fullList.addAll(b);
    fullList.sort();
    return fullList
}
fun <T : Comparable<T>> subLists (a : List<T>?):List<ArrayList<T>>?{
    if(a==null)return null;
    if(a.any()==false) return emptyList();
    val listsize=a.count();
    val FinalList= ArrayList< ArrayList<T>>();
    for(i in 1 .. listsize){
        val piecelist=ArrayList<T>(a.take(i));
        FinalList.add(piecelist)
    }
return  FinalList;
}
fun <T : Comparable<T>> countElements(a : List<List<T>>?) : Int {
    if(a==null)return 0;
    if(a.any()==false) return 0;
    return a.count()
}

