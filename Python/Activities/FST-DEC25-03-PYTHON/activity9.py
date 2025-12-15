list1 = [50, 21, 22, 91, 17, 49]
list2 = [73, 67, 20, 32, 67, 456]

print("First List is: ", list1)
print("Second List is: ", list2)

list3 = []

for num in list1:
    if (num % 2 != 0):
        list3.append(num)
        
# Iterate through first list to get even elements
for num in list2:
    if (num % 2 == 0):
        list3.append(num)

# Print result
print("result List is:")
print(list3)