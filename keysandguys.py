def second_smallest(numbers):
    m1, m2 = float('inf'), float('inf')
    for x in numbers:
        if x <= m1:
            m1, m2 = x, m1
        elif x < m2:
            m2 = x
    return m2

days = int(input())
for i in range(0,days):
  pko = [int(x) for x in input().split()]
  office = pko[2]
  peoplePos = [int(z) for z in input().split()]
  keyPos = [int(c) for c in input().split()]
  differentDis = []
  for j in range(0,len(peoplePos)):
    differentDis.append([])
    for w in range(0,len(keyPos)):
      differentDis[j].append(abs(peoplePos[j]-keyPos[w]) + abs(office - keyPos[w]))
  minlists = []
  indexes = []
  for p in range(0,len(differentDis)):
    minlists.append(min(differentDis[p]))
    current = differentDis[p].index(min(differentDis[p]))
    indexes.append(current)
    for t in range(0,len(indexes)-1):
      if current == indexes[t]:
        checkedOne = second_smallest(differentDis[t])
        thisOne = second_smallest(differentDis[p])
        if thisOne < checkedOne:
          minlists[p] = thisOne
          indexes[p] = differentDis[p].index(thisOne)
        else:
          minlists[t] = checkedOne
          indexes[t] = differentDis[t].index(checkedOne)
  print(max(minlists))
