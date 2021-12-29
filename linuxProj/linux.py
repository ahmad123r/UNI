import os
from typing import overload

import datetime
from collections import Counter
######### classes that we need ##############
class info:
    def __init__(self,year,semester,courses_grades):
        self.year=year
        self.semester=semester
        self.courses_grades=courses_grades
    def tostring(self):
        line=""
        line+=(self.year+"/"+self.semester+" ;")
        for i in self.courses_grades:
            line+=(" "+i+",")
        
        return line[:-1]
class Student(info):
    def __init__(self,sid):
        self.sid=sid
        self.students_semesters=[]
    def addsemester(self,semester):
        self.students_semesters.append(semester)
    def printx(self):
        print(self.sid)
    def newgrade(self):
        subject = (input("Enter the subject you want to change it's grade : "))
        for i in self.students_semesters:
            for j in range(len(i.courses_grades)):
                split=i.courses_grades[j].split(" ")
                studentsub=split[0]
                if subject == studentsub:
                    grade = (input("Enter the new Grade for Subject "+subject+" : "))
                    i.courses_grades[j]=subject+" "+grade
                    fixfile(self.sid)
                    print("Grade has been changed")
                    return
        print("Make sure you entered the write subject.")
####################################################################################################################
############ Read students from student files and create objects of students  as global variables####################
path="students"
x=os.listdir(path)
studentsobject=[]
for i in x:
    gg=Student(i)
    with open('students/'+i) as f:
        contents = f.read()
        lines=contents.split("\n")
        for i in range(1,len(lines)):
            year=lines[i][0:9]
            semester=lines[i][10:11]
            coursestring=lines[i].split(";")
            courselist=coursestring[1].split(",")
            for i in range(len(courselist)):
                courselist[i]=courselist[i][1:]
            newinfo=info(year,semester,courselist)
            gg.addsemester(newinfo)
    studentsobject.append(gg)
students=[]
for i in studentsobject:
    students.append(i.sid)
############################################### Fix File update the grade on the file #####################
def fixfile(id):
    file = open("students/"+id, "w")
    file.write("Year/Semester ; Cources with grades")
    studentobject=[i for i in studentsobject if i.sid == id]
    student=studentobject[0]
    file = open("students/"+id, "a")
    for i in student.students_semesters:
        file.write("\n"+i.tostring())
    file.close()
#############################################################################################
def print_login_menu():
    menu_options = {
    1: 'Admin',
    2: 'User',
    }
    for key in menu_options.keys():
        print (key, '--', menu_options[key] )
def print_admin_menu():
    menu_options = {
        1: 'Add new Studnet ID.',
        2: 'Add new Semester with student courses and grades.',
        3: 'Update Student Grade.',
        4: 'Student statiscs',
        5: 'Global Statiscs',
        6: 'Search For Student',
        7: 'Exit'
    }
    for key in menu_options.keys():
        print (key, '--', menu_options[key] )
def print_user_menu():
    menu_options = {
        1: 'Print Student Statistics.',
        2: 'Print Global Statistics.',
        3: 'Exit'
    }
    for key in menu_options.keys():
        print (key, '--', menu_options[key] )
def print_search():
    menu_options = {
        1: 'Search for Students based on average',
        2: 'Search for Students based on hours taken',
    }
    for key in menu_options.keys():
        print (key, '--', menu_options[key] )
####### ADMIN OPTIONS ########
def addnewstudent():
    id = (input('Enter Student ID: '))
    if id in students:
        print("This ID is already taken .")
    else:
        newstudent=Student(id)
        studentsobject.append(newstudent)
        students.append(newstudent.sid)
        file = open("students/"+id, "w")
        file.write("Year/Semester ; Cources with grades")
        file.close()
        print("Student has been added successfully")
        
        
def addinfostudent():
    id = (input('Enter Student ID: '))
    if id in students:
        year=input('Enter Year format (YYYY-YYYY): ')
        semester=input('Enter semester : ')
        numofcourses=input('Enter number of courses : ')
        courseslist=[]
        for i in range(int(numofcourses)):
            course=input('Enter Course '+str(i+1)+' : ')
            mark=input('Enter Mark '+str(i+1)+' : ')
            courseslist.append(course+" "+mark)
        semesterinfo=info(year,semester,courseslist)
        studentobject=[i for i in studentsobject if i.sid == id]
        studentobject[0].addsemester(semesterinfo)
        file = open("students/"+id, "a")
        file.write("\n"+semesterinfo.tostring())
        file.close()
        print("info has been added.")
    else:
        print("please enter a student ID that exists in our database.")
def updategrades():
    id = (input('Enter Student ID you want to update: '))
    if id in students:
        studentobject=[i for i in studentsobject if i.sid == id]
        newinfostudent=studentobject[0]
        newinfostudent.newgrade()
    else:
        print("please enter a student ID that exists in our database.")
        
def studentStatistics(x):
    courselist=["ENEE2103","ENEE2302","ENEE2304","ENEE2307","ENEE236","ENEE3302","ENEE339","ENEE4103",
            "ENCS211","ENCS234","ENCS238","ENCS311","ENCS313","ENCS333","ENCS338","ENCS339","ENCS411","ENCS412",
            "ENCS413","ENCS4300","ENCS431","ENCS434","ENCS436","ENCS437","ENCS438","ENCS514","ENCS515","ENCS520","ENCS521",
            "ENCS530","ENCS531","ENCS532","ENCS533","ENCS5311","ENCS5312"]
    if x==None:
        id = (input('Enter Student ID : '))
    else:
        id=x
    print("************************************************")
    studentobject=[i for i in studentsobject if i.sid == id]
    student=studentobject[0]
    takenhours=0
    overalaverage=0
    leftcourses=[]
    takencourses=[]
    for i in student.students_semesters:
        for j in i.courses_grades:
            takencourse=j.split(" ")[0]
            takencourses.append(takencourse)
    for i in courselist:
        if i not in takencourses:
            leftcourses.append(i)
    for i in student.students_semesters:
        semesteravg=0
        for j in i.courses_grades:
            line=j.split(" ")
            grade=line[1]
            semesteravg+=int(grade)
            takenhours+=3
        semesteravg/=len(i.courses_grades)
        overalaverage+=semesteravg
        print("the average for  "+str(i.year)+"/"+str(i.semester)+" semester "+str(semesteravg))
    print("The student has taken "+str(takenhours)+" hours")
    overalaverage/=len(student.students_semesters)
    print("the overale average for all semesters is "+str(overalaverage))
    print("this student has "+str(len(leftcourses))+" courses left :")
    for i in range(len(leftcourses)):
        print(str(i+1)+". "+leftcourses[i])
    print("************************************************")
################overall students average, average hours per semester###################
def globalStatistics():
    studentAvg=[]
    avgHoursPerSemester=[]
    for i in studentsobject:
        overalaverage=0
        for j in i.students_semesters:
            semesteravg=0
            takenhours=0
            for k in j.courses_grades:
                line=k.split(" ")
                grade=line[1]
                semesteravg+=int(grade)
                takenhours+=3
            avgHoursPerSemester.append(takenhours)
            semesteravg/=len(j.courses_grades)
            overalaverage+=semesteravg
        overalaverage/=len(i.students_semesters)
        studentAvg.append(overalaverage)
    print("**************************************************************************")
    print("the Overall students Average is : "+str(sum(studentAvg)/len(studentAvg)))
    print("the Average hours per semester for all students is : "+str(sum(avgHoursPerSemester)/len(avgHoursPerSemester)))
    print("**************************************************************************")
    ########## histogram###################
    freqs = Counter(studentAvg)
    # Counter({1: 2, 3: 6, 10: 2, 8: 2, 9: 2, 5: 2, 7: 4})

    plt.bar(freqs.keys(), freqs.values())
    plt.ylabel('Count')
    plt.title('Histogram Grades')
    plt.show()
#######################################
########### based on average, taken hours#############
def searchForStudent():
    print_search()
    option = ''
    option = (input('Enter your choice: '))
    if option == "1":
        basedOnAvg()
    elif option == "2":
        basedOnHours()
    else:
            print('Invalid option. Please enter a number between 1 and 7')
################### based on average############################################# 1
def basedOnAvg():
    mark=input('Enter the average you want the marks to be more than or equal to : ')
    students=[]
    for i in studentsobject:
        overalaverage=0
        for j in i.students_semesters:
            semesteravg=0
            for k in j.courses_grades:
                line=k.split(" ")
                grade=line[1]
                semesteravg+=int(grade)
            semesteravg/=len(j.courses_grades)
            overalaverage+=semesteravg
        overalaverage/=len(i.students_semesters)
        if overalaverage>=float(mark):
            
            students.append(i.sid)
    print("there are "+str(len(students))+" that have average above "+str(mark))
    for i in range(len(students)):
        print(str(i)+". "+(students[i]))
############################################### based on hours ################################ 2
def basedOnHours():
    hours=input('Enter the number of taken hours you want the students to have : ')
    students=[]
    for i in studentsobject:
        takenhours=0
        for j in i.students_semesters:
            for k in j.courses_grades:
                takenhours+=3
        if takenhours >= int(hours):
            students.append(i.sid)
    print("there are "+str(len(students))+" that have taken hours above "+str(hours))
    for i in range(len(students)):
        print(str(i)+". "+(students[i]))
################################
def admin():
    while(True):
        print_admin_menu()
        option = ''
        option = (input('Enter your choice: '))


        #Check what choice was entered and act accordingly
        if option == "1":
            addnewstudent()
        elif option == "2":
            addinfostudent()
        elif option == "3":
            updategrades()
        elif option == "4":
            studentStatistics(None)
        elif option =="5":
            globalStatistics()
        elif option=="6":
            searchForStudent()
        elif option == "7":
            exit()
        else:
            print('Invalid option. Please enter a number between 1 and 7')
###################################################################################################
#############################User options ###########################################################
def user(id):
     while(True):
        print_user_menu()
        option = ''
        option = (input('Enter your choice: '))


        #Check what choice was entered and act accordingly
        if option == "1":
            studentStatistics(id)
        elif option == "2":
            globalStatistics()
        elif option == "3":
            exit()
        else:
            print('Invalid option. Please enter a number between 1 and 3')
#####################################################################################################  
def main():
    while(True):
        print_login_menu()
        option = ''
        option = (input('Enter your choice: '))


        #Check what choice was entered and act accordingly
        if option == "1":
            password=(input('Enter admin password : '))
            if password=="admin":
                admin()
            else:
                print("wrong password")
        elif option == "2":
            stid = (input('Please Enter Your id : '))
            if stid in students:
                user(stid)
            else:
                print("this id does not exist")
        else:
            print('Invalid option. Please enter a number between 1 and 2')
        
        
        

        
main()
