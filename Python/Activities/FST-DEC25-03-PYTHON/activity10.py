mytuple = (78, 10, 35, 46, 55, 789, 32)
print("Given list is ", mytuple)

print("Numbers that are divisible by 5 are:")
for num in mytuple:
    if (num % 5 == 0):
        print(num)