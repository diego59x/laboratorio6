package com.example.laboratori4

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.laboratori4.databinding.FragmentMainBinding
import com.example.laboratori4.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment(), View.OnClickListener{
    var preguntas: List<String> = listOf("¿Tiene algun comentario/sugerencia?","¿Que le parecio nuestro servicio?")
    var contador = 0
    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var binding : FragmentSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Aqui deberia de mostrar la pregunta seleccionada pero no sale :/
        binding.Titulo2.text = preguntas[contador]
        contador += 1


        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.comentar).setOnClickListener(this)
        (activity as MainActivity).supportActionBar?.title = "Encuesta"

    }



    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.comentar -> {
                if(!TextUtils.isEmpty(edit_Comentario.text.toString())){
                    val bundle = bundleOf("recipient" to edit_Comentario.text.toString())
                    navController!!.navigate(
                        R.id.action_secondFragment_to_comentario,
                        bundle
                    )
                }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.biografia){
            navController!!.navigate(
                R.id.action_mainFragment_to_biografia2)
        }
        return super.onOptionsItemSelected(item)
    }
}
