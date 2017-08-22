rightTurn = ['N':'E','E':'S','S':'W','W':'N']
leftTurn = ['N':'W','E':'N','S':'E','W':'S']
moves = ['N':[x:0,y:1],'E':[x:1,y:0],'S':[x:0,y:-1],'W':[x:-1,y:0]]

m = { rover ->
    move = moves[rover['o']]
    x = rover['x']+move['x']
    y = rover['y']+move['y']
    o = rover['o']
    return [x:x, y:y, o:o]
}

l = { rover ->
    o = leftTurn[rover['o']]
    return [x:rover['x'],y:rover['y'], o:o]
}

r = {rover ->
    o = rightTurn[rover['o']]
    return [x:rover['x'],y:rover['y'], o:o]
}

process = { initialRover, instructions ->
    instructions.inject(initialRover) { rover, command ->
        "$command"(rover)
    }
}

rover = [x:1, y:2, o:'N']
instructions = "LMLMLMLMM".toLowerCase()

assert [x:1, y:3, o:'N'] ==  process(rover, instructions)
