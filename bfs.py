import queue;

# Defining the graph with an adj matrix
adj_list = {
    "A":["B","S"],
    "B":["A"],
    "C":["D","E","F","S"],
    "D":["C"],
    "E":["C","H"],
    "F":["G","C"],
    "G":["S","F","H"],
    "H":["G","E"],
    "S":["G","C","A"],
}

# Defining the queue with a size double that of v
q = queue.Queue()

# Defining a list visited
visited_list = ["A"] 

def bfs(vertex):
    #we will put the children of vertex into our q
        #first of all we will get the children of vertex
    children = adj_list.get(vertex)
    
        #now we will traverse through the list of children 
    for c in children:
        
        if not (c in visited_list):
            q.put(c)
            visited_list.append(c)

    if q.qsize() != 0:
        bfs(q.get())
        
   
    #I will call bfs method for the remaining children

print("BFS started")
bfs("A")

print(visited_list)
# print("\n")
# print(q.get())
# print(q.get())


    




