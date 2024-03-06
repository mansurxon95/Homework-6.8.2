package com.mansurdev.homework_682

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mansurdev.homework_682.databinding.FragmentSpleshBinding
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpleshFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpleshFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentSpleshBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSpleshBinding.inflate(inflater,container,false)


        asentask().execute()

        return binding.root
    }

    inner class asentask:AsyncTask<Void,Void,Void>(){

        override fun onPreExecute() {
            super.onPreExecute()
            binding.textProgress.text = "Ma'lumotlar yuklanmoqda"
        }

        override fun doInBackground(vararg params: Void?): Void? {

            try {
                for (i in 1..20){

                    binding.progressBar.progress = i
                    TimeUnit.MILLISECONDS.sleep(100)
                }

            }catch (e:Exception){
                Toast.makeText(requireContext(), "$e", Toast.LENGTH_SHORT).show()
            }

            return  null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            binding.textProgress.text = "Yuklash tugallandi"
            TimeUnit.SECONDS.sleep(1)
            findNavController().navigate(R.id.action_spleshFragment_to_homFragment)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SpleshFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpleshFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}