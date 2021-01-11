import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="postgres",
  password="Andrew9449",
  database="MovieDatabase",
  port="7777"
)

mycursor = mydb.cursor()
# val = ("John", "Highway 21")
mycursor.execute("select * from \"Movie\"")

# mydb.commit()

# print(mycursor.rowcount, "record inserted.")

myresult = mycursor.fetchall()

for x in myresult:
  print(x)

mydb.close()