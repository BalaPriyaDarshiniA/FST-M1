choice1=input("Enter Player1's choice: ").lower()
choice2=input("Enter Player2's choice: ").lower()
if (choice1==choice2):
    print("It is a tie!")
elif(choice1=='rock'):
        if(choice2=='scissors'):
            print('Rock wins!')
        else:
            print('Paper wins!')
elif(choice1=='scissors'):
    if(choice2=='paper'):
        print('Scissors win!')
    else:
        print('Rock wins!')
elif(choice1=='paper'):
    if(choice2=='rock'):
        print('Paper wins!')
    else:
        print('Scissors wins')
else:
    print('You have entered an invalid input')