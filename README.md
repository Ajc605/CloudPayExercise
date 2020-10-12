Thanks for applying to join the CloudPay Software Engineering group. We would like you to complete this exercise to demonstrate
some relevant knowledge of this area of Java development. The exercise is designed to give you the opportunity to demonstrate what
you can do in this field. Some guidelines:

1. Do as much as you can in 1-2 hours
2. If you need further clarification then please do get in contact with developers using the email addresses below
3. Most important: have fun doing this!

You will need this software:
Java : openjdk version "11.0.2"
Maven : Apache Maven 3.6.3
Git :  git version 2.24.0
An IDE of your choice : we use Eclipse as our standard IDE (use your preferred IDE)


The empty exercise containing:

.gitignore
pom.xml
README.md
/src/main/java/App.java
/src/main/java/resources/employees.json
/src/main/java/resources/payments.json


We want you to use this project as a framework Maven Java project to complete this exercise. You should do the following:

1. Create a free Bitbucket account (you can use Git repositories to Bitbucket if you prefer these: GitHub, GitLab, etc.)
2. Create a new private Git project and repository
3. Clone the repository to your local drive
4. Copy the exercise into your local repository
5. Perform the exercise and produce the expected results 
6. Add your email address in the section at bottom of this file
7. Commit the changes and push to your Bitbucket repository
8. Share your repository with the emails listed below READ ONLY (don't forget this or we cannot get to your code!!)
9. Send an email to developers with your Name and your git URL.


Senior Developers
-----------------
martin.brown@cloudpay.net
mike.adams@cloudpay.net

What we will do when we receive an share notification from Bitbucket:

1. Run "git clone {your_url.git}" into a folder
2. Run "mvn clean install"
3. Run "java -jar .\target\exercise1-1.0-SNAPSHOT-jar-with-dependencies.jar"
4. Advise you via email that we have received this

When run we expect to see the following:

1. List all payments showing Effective Date,Company No,Employee Name,Paycode,Amount
Sorted by Effective Date,Company No,Employee Name,Paycode ascending 
Example:

|Effective Date|Company No|Employee Name|Paycode|Amount|
|2020-01-01    |XYZ456    |Fred        |BONUS   | 80.22|
|2020-02-01    |ABC123    |Mary        |BONUS   | 80.22|
|2020-02-02    |XYZ456    |Jane        |BONUS   | 80.77|
|2020-03-01    |XYZ456    |Fred        |EXPENSES| 95.50|
|2020-03-02    |ABC123    |Bob         |BONUS   | 50.00|
|2020-03-02    |XYZ456    |Jane        |EXPENSES| 20.11|

2. List total payments for each employee (unsorted)
Example:

|CompanyNo |Employee Name|Total Amount|
|XYZ456    |Fred         |      175.72|
|ABC123    |Mary         |       80.22|
|XYZ456    |Jane         |      100.88|
|ABC123    |Bob          |       50.00|


FAQ:
Q - Can I use any Maven dependencies for this?
A - Yes, feel free to add any dependencies you need

Q - Its taking me much longer than 2 hours to complete, can I just stop there and submit it?
A - Yes, do what you can do and add something in comments below to explain

Q - Do I get credited with producing something far beyond this brief?
A - As long as you meet the brief and the timeframe, anything beyond that and outlined below is welcomed, but not expected

Q - I found this really simple and completed this in under 1 hour, can I tell you and be credited for this?
A - If you like, then let us know the time you took in comments below. Its optional,  but if you found it easy then please feedback

Q - Can I add other java files to the project
A - Yes, feel free to add packages and files to the project

Q - Can I change the contents in the json files
A - No, please use the content as provided


Please try to stick to the 1 - 2 hours and the brief. If you feel that you must stray from the the brief, then please add comments to
explain the rationale for your decisions as this will help us to understand you better. Example: "I used GitHub rather than Bitbucket
because I know GitHub and therefore it saved me some time". Please do add any comments/feedback on the exercise to help us get better.

-----------------------------------------------------------------------------------------------------------------------------------
Candidate email address (for acknowledgement that we accessed your repo): aidencooper15@gmail.com
Candidate comments and feedback:
I every much enjoyed this project, I feel that even although I have completed both tasks there might be a more effective solution that 
I haven't achieve, however I feel proud of the work I have completed. I build this application based on the size of the data, if there
was 1,000's of records then I would have taken a different approach that would have used search functions; such as binary search. I 
also learnt about Comparators to order array's. I haven't come across this before and found it every useful.    

I used GitHub to upload this project as I am familiar with this. I also used IntelliJ as my IDE.

If you could move into the exercise1 directory then complete your instructions when testing my code please.



