nums = input("Enter a sequence of comma separated values: ").split(",")
sum = 0
for num in nums:
  sum = int(sum)+int(num)
print(sum)