package activity

import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

fun main() {
//    println("Application for Employment")
    var position:String = "Software Engineer"
    var desiredSalary:IntRange = 30000..50000 //It can be optional to use by range.
    var parsedateAvialbility = LocalDate.parse("2022-10-06")
    var formatdateAvialbility = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateAvialbility = parsedateAvialbility.format(formatdateAvialbility)

//    Personal Information
    var firstName:String = "Ebrahim";
    var middleName:String = "Escabarte";
    var lastName:String = "Diangca";
    var age:Int = 18;
    var agelimit:IntRange = 15..50;
    var address:String = "Prk. Islam, Mankilam";
    var city:String = "Tagum";
    var state:String = "Davao del Norte";
    var zipcode:Int = 8100;
    var homenumber:Int? = null;
    var cellnumber: Long = 9978251816;
    var email:String? = "ediangca22@gmail.com";
    var sss:Long = 9123456789;
    var isUScitizen:Boolean = true;
    var hasfelony:Boolean = true;
    var pedst:Boolean = true;

//Educational Background

    var school:String = "USEP";
    var location:String = "Davao";
    var year:Int = 2014;
    var degree:String = "BSIT";
    var major:String? = "";

    var other_tcl:String? = ""

//    ----------------------------------
    println("Application for Employment");
//    ----------------------------------
    println("Position you are applying for : $position");
    println("Desired Salary : $desiredSalary");
    println("Date Availability : $dateAvialbility");

//    ----------------------------------
    println("Personal Information");
//    ----------------------------------
    println("Lastname : $lastName");
    println("Firstname : $firstName");
    println("Middlename : $middleName");

    println("Age must be 18+ above");
    println("Age : $age");

    var teens = agelimit.filter { it >= 18 }

    var isonlist:Boolean = false;

    for(value in teens){
//        println("Value : $value");
        if(age == value){
            isonlist =true;
        }
    }
    if(!isonlist){
        print("not Eligible.")
    }else{
        print("Eligible.")
    }

    println("Address : $address");
    println("City : $city");
    println("State : $state");
    println("Zip : $zipcode");

    println("Home Phone : $homenumber");
    println("Cell Phone :  $cellnumber");
    println("Email :  $email");

    println("Social Security Number :  $sss");
    println("Are you a U.S Citizen : $isUScitizen");
    println("Have you ever been convicted of felony : $hasfelony");
    println("If you selected for employement are you willing to submit to pre-employementd drug screening test? :  $pedst");

    println("School : $school")
    println("Location : $location")
    println("Year Attended : $year")
    println("Degree Received : $degree")
    println("Major : "+ major?.let { "None" })

    println("other training, certifications or license held : "+ other_tcl?.let { "None" })

}