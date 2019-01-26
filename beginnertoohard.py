start = int(input())
for i in range(0,start):
  useless = int(input())
  usefulsequence = [int(x) for x in input().split()]
  deletedterms = 0
  if len(usefulsequence) == 1:
    print("1")
  else:
    for k in range(0,len(usefulsequence)):
      for j in range(0,len(usefulsequence)):
        has = False
        dank = False
        if j == k:
          continue
        binary = str(bin(usefulsequence[k] + usefulsequence[j])) 
        once = False
        for m in range(2,len(binary)):
          if binary[m] == "1":
            if once == False:
              once = True
            else:
              once = False
              dank == True
              break
        if dank == True:
          continue
        elif once == True:
          has = True
          break
      if has != True:
        deletedterms += 1
    print(deletedterms)
