package com.example.shualeduri

class FinanceManager {
    // ანუ რადგან პროგრამაში ინგლისურად მაქვს სახელი გვარი გამოყენებული და კოტლინიდანაც გამოჩენილი ფრაგმენტ ბ-ზე,
    // აქაც ინგლისურად გვარის რაოდენობას გამოვიყენებ.
    // ჩემი გვარი "Tchikadze" (9 ასო), თებერვალი (2).
    // პროცენტი = 9 + 2 = 11%
    private val savingsPercent = 11.0

    //ხელფასის მიერ დანაზოგის პოვნა, ანუ რომელსაც გამოვაკლებთ ჩვენ კალკულაციაში რადგან მომავლისთვის ვინახავთ დანაზოგს.
    fun calculateSavings(salary: Double): Double {
        return salary * (savingsPercent / 100.0)
    }

    //ჯამი რაზეც უნდა დაიხარჯოს ხელფასი
    fun calculateTotalExpenses(rent: Double, meals: Double): Double {
        return rent + meals
    }

    //რაც დაგვრჩა ფული დახარჯვების შემდეგ, იმის გამოთვლა
    fun calculateRemaining(salary: Double, rent: Double, meals: Double): Double {
        val savings = calculateSavings(salary)
        val expenses = calculateTotalExpenses(rent, meals)
        return salary - savings - expenses
    }

    //ტექსტი მწვანეა მაშინ, როცა დასახარჯს და დანაზოგსის პროცენტსაც გავითვალისწინებთ, და შემდეგ ფული თუ დაგვრჩება >=0
    fun isSalaryEnough(salary: Double, rent: Double, meals: Double): Boolean {
        return calculateRemaining(salary, rent, meals) >= 0
    }
}
