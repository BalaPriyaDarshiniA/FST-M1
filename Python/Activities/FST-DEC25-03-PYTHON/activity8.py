nums = [int(x) for x in input("Enter numbers separated by commas: ").split(",")]
print("Given list is ", nums)

firstnum = nums[0]
lastnum = nums[-1]

if (firstnum == lastnum):
    print('True, the first and last numbers of the list are the same.')
else:
    print('False, the first and last numbers of the list are not the same.')