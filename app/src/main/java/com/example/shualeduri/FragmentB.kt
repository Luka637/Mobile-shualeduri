package com.example.shualeduri

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shualeduri.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!
    private val financeManager = FinanceManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ამოვიღოთ ჩვენი რიცხვითი მნიშვნელობები Arguments საშუალებით
        val salary = arguments?.getDouble("lt_salary") ?: 0.0
        val rent = arguments?.getDouble("lt_rent") ?: 0.0
        val meals = arguments?.getDouble("lt_meals") ?: 0.0

        // შემდეგ შევქმნათ ობიექტი და შევინახოთ მონაცემები
        val financeModel = FinanceModel(salary, rent, meals)

        // გამოვიყენოთ ფინანსის მენეჯერი გამოთვლებისთვის FinanceModel-ის ობიექტით.
        // შემდეგ ფრაგმენტ ბ-ში გამოვაჩინოთ გამოთვლილი ინფრომაცია და შესაბამისი ფერით
        val savings = financeManager.calculateSavings(financeModel.salary)
        val expenses = financeManager.calculateTotalExpenses(financeModel.rent, financeModel.meals)
        val remaining = financeManager.calculateRemaining(
            financeModel.salary,
            financeModel.rent,
            financeModel.meals
        )
        val isEnough = financeManager.isSalaryEnough(
            financeModel.salary,
            financeModel.rent,
            financeModel.meals
        )

        val resultText = """
            Salary: ${financeModel.salary}
            Rent: ${financeModel.rent}
            Meals: ${financeModel.meals}
            Savings (11%): $savings
            Total Expenses: $expenses
            Remaining: $remaining
        """.trimIndent()

        binding.ltTxtResult.text = resultText

        if (isEnough) {
            binding.ltTxtResult.setTextColor(Color.GREEN)
        } else {
            binding.ltTxtResult.setTextColor(Color.RED)
        }

        // Dynamic Identity: დინამიურად კოტლინით გამოვაჩინოთ სახელი გვარი დაბადების წელი ფრაგმენტ ბ-ში
        val firstName = "Luka"
        val lastName = "Tchikadze"
        val yearOfBirth = 2006

        // ეს დროებით რაც გვაქვს ფრაგმენტ ბ-ში იმას შეცვლის ნამდვილი მნიშვნელობებით (სახელი, გვარი, წელი)
        binding.ltTxtIdentity.text = "$firstName $lastName, $yearOfBirth"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
