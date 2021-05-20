fun countingNumbers(n: Int?) : List<Int>? {
    if(n == null){
        return null
    }
    
    val numbers : MutableList<Int> = mutableListOf()
    for(i in 1..n){
        numbers.add(i)
    }
    
    return numbers
}

fun evenNumbers(n: Int?) : List<Int>?{
    if(n == null){
        return null
    }
    
    return countingNumbers(n)?.filter {it%2 == 0}
}

fun isPrime(n : Int) : Boolean{
    if(n==1){
        return false
    }
    
    for(i in 2..(n/2)){
            if(n%i == 0){
                return false
            }
        }
        return true
}

fun primeNumbers(n: Int?) : List<Int>?{
    if(n == null){
        return null
    }
    
    return countingNumbers(n)?.filter {isPrime(it)}
}

fun<T : Comparable<T>> merge (a : List<T>?, b : List<T>?) : MutableList<T>?{
    if(a == null || b == null){
        return null
    }
    return wrapper(mutableListOf(), a, b)
}

fun<T : Comparable<T>> wrapper(list : MutableList<T>, a : List<T> , b : List<T>): MutableList<T>{
    //if a or b is empty then add the rest of the other list to the list and return
    if(a.isEmpty()){
        list.addAll(b)
        return list
    }
    if(b.isEmpty()){
        list.addAll(a)
        return list
    }
    
    if(a.get(0) < b.get(0)){
        list.add(a.get(0))
        return wrapper(list, a.drop(1), b)
        
    } else {
        list.add(b.get(0))
        return wrapper(list, a, b.drop(1))
    }
}

fun subLists(a : List<Int>?) : List<List<Int>>? {
    if(a == null){
        return null
    }
    
    val list : MutableList<MutableList<Int>> = mutableListOf()
    
    for(i in 0..a.size-1){
        val sub : MutableList<Int> = mutableListOf()
        for(j in 0..i){
            sub.add(a.get(j))
        }
        list.add(sub)
    }
    return list
}

fun countElements(a : List<List<Int?>?>?) : Int?{
    if(a.isNullOrEmpty()){
        return 0
    }
    
    var count : Int = 0
    
    for(i in 0..a.size-1){
        count += count(a.get(i))
    }
    return count
}

fun count(list : List<Int?>?) : Int{
    if(list == null || list.isEmpty()){
        return 0
    }
    var num : Int = 0
    for(i in 0..list.size-1){
        if(list.get(i) != null){
        	num++
        }
    }
    return num
}

fun add(x : Int, y : Int) : Int = x + y
fun add1(x : Int) : Int = x + 1
fun add2(x : Int) : Int = x + 2

fun listApply(f : (Int, Int) -> Int, a : List<List<Int>>?) : List<Int>?{
    if(a == null){
        return null
    }
    
    val list : MutableList<Int> = mutableListOf()
    
    for(i in 0..a.size-1){
        var value : Int = 0
        for(j in 0..a.get(i).size-1){
            value = f(value, a.get(i).get(j))
        }
        list.add(value)
    }
    return list
}

fun composeList(a : List<(Int) -> Int>) : (Int) -> (Int){
    return {
        x ->
        var number : Int = x
        for(i in 0..a.size-1){
            number = a.get(i)(number)
        }
        number
    }
}