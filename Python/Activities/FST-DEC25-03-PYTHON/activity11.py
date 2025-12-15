fruit_shop = {
    "apple": 20,
    "banana": 65,
    "orange": 70,
    "peaches": 75
}
checkingfruit = input("What are you looking for? ").lower()

if(checkingfruit in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")