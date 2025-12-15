def sum(numbers):
	sum = 0
	for number in numbers:
		sum = sum+number
	return sum

mylist = [100, 244, 765]
result = sum(mylist)

print("The sum is: " + str(result))