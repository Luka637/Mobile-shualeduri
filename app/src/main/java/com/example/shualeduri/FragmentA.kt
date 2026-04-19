package com.example.shualeduri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shualeduri.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ltBtnCalculate.setOnClickListener {
            val salary = binding.ltEditSalary.text.toString().toDoubleOrNull() ?: 0.0
            val rent = binding.ltEditRent.text.toString().toDoubleOrNull() ?: 0.0
            val meals = binding.ltEditMeals.text.toString().toDoubleOrNull() ?: 0.0

            // შევქმნათ Bundle რომ გადავცეთ ჩვენი მნიშვნელობები ფრაგმენტ ბ-ს
            val bundle = Bundle()
            bundle.putDouble("lt_salary", salary)
            bundle.putDouble("lt_rent", rent)
            bundle.putDouble("lt_meals", meals)

            val fragmentB = FragmentB()
            fragmentB.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.lt_main_fragment_container, fragmentB)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
