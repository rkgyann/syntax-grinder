num=int(input("Enter number: "))
if num%2==0:
   if num%3==0:
      print("Divisible by 2 and 3")
   else:
      print("Divisible by 2")
else:
   if num%3==0:
      print("Divisible by 3 not by 2")
   else:
      print("Not divisible by 2 & 3")