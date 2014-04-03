reverse = { text ->
    if (text.length() == 1) {
        return text
    } 
    return reverse(text[1..-1]) + text[0]
}

reverseIter = { text1, text2 ->
    text2 = text2 + text1[-1]
    if (text1.length() == 1) {
        return text2;
    }
    return reverseIter(text1[0..-2],text2)        
}

reverseTail = { text ->
    reverseIter (text, "")
}

println reverse ("novi")
println reverseTail ("novi")

