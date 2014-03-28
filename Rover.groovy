dirs = ['N','E','S','W']
moves = [[x:0,y:1],[x:1,y:0],[x:0,y:-1],[x:-1,y:0]]

m = { rover ->
    move = moves[position(rover['o'])]
    x = rover['x']+move['x']
    y = rover['y']+move['y']
    o = rover['o']
    return [x:x, y:y, o:o]
}

l = { rover -> 
    o = dirs[(position(rover['o'])-1)%4]    
    return [x:rover['x'],y:rover['y'], o:o] 
}

r = {rover ->
    o = dirs[(position(rover['o'])+1)%4]    
    return [x:rover['x'],y:rover['y'], o:o]
}

position = {o ->
    return dirs.findIndexOf{ it == o}
}

process = { initialRover, instructions ->
    instructions.inject(initialRover) { rover, command ->
        "$command"(rover)
    }
}

rover = [x:1, y:2, o:'N']
instructions = "LMLMLMLMM".toLowerCase()
println process(rover, instructions)



