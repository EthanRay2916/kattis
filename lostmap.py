def find(parents, node):
    # find the representative of the set to which 'node' belongs
    # helpful for cycle prevention
    if parents[node] < 0: #-1 from set
        return node
        #if no sets contain this village, return this village
    parents[node] = find(parents, parents[node])
    return parents[node]

def unite(parents, a, b):
    # merge the sets  'a' and 'b'
    a = find(parents, a)
    b = find(parents, b)
    if a == b: 
        return
    if parents[a] > parents[b]:
        a, b = b, a
    parents[a] += parents[b]
    parents[b] = a

class VillageDistance: # edge object
    def __init__(self, village1, village2, distance):
        self.village1 = village1
        self.village2 = village2
        self.distance = distance

def main():
    num_villages = int(input())
    distances = [] 

    # read distances between villages from input
    #creates list of edge objects
    for i in range(num_villages):
        row = list(map(int, input().split()))
        for j in range(i):
            distances.append(VillageDistance(i, j, row[j]))

    # sort distances in ascending order
    distances.sort(key=lambda x: x.distance)

    # initialize disjoint set data structure for villages. Each value starts with -1 value
    parents = [-1] * num_villages

    # Process edges in sorted order and output the minimum spanning tree
    for edge in distances:
        n1 = find(parents, edge.village1)
        n2 = find(parents, edge.village2)
        if n1 != n2:
            # Output the edge of the minimum spanning tree
            #+1 necessary because index starts at 0
            print(f"{edge.village1 + 1} {edge.village2 + 1}")
            unite(parents, n1, n2)

if __name__ == "__main__":
    main()
