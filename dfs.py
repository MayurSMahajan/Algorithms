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

#Defining the stack for dfs
s = queue.LifoQueue()

#Defining a visited list
visited_list =  ["A"]

def dfs(vertex):
    children = adj_list.get(vertex)
    for c in children:
        if not (c in visited_list):
            s.put(c)
            visited_list.append(c)

        if s.qsize() != 0:
            dfs(s.get())

print("BFS started")
dfs("A")

print(visited_list)