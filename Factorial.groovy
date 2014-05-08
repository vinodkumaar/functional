fact = { i ->
    if(i==0) {
        return 1
    }
    return i * fact(i-1)
} 

factTail = { i ->
   return factIter (1, 1, i) 
}

factIter = { product, iteration, maxCount ->
    if (iteration > maxCount) {
        return product
    }
    return factIter(product * iteration , iteration + 1, maxCount)
}

assert fact(4) == 24
assert factTail(4) == 24