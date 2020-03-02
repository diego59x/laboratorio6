package com.example.laboratori4

import android.content.Intent
import android.text.TextUtils
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.laboratori4.databinding.FragmentComentarioBinding
import com.example.laboratori4.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_comentario.*
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass.
 */
class Comentario : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var binding : FragmentComentarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comentario, container, false)
        // Inflate the layout for this fragment
        return binding.root
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //view.findViewById<TextView>(R.id.textView).text = recipient
        //super.onViewCreated(view, savedInstanceState)
        //navController = Navigation.findNavController(view)
        (activity as MainActivity).supportActionBar?.title = "Resultados"
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button2 -> {
                if(!TextUtils.isEmpty(edit_Comentario.text.toString())){
                    val bundle = bundleOf("recipient" to edit_Comentario.text.toString())
                    navController!!.navigate(
                        R.id.action_comentario_to_resultados,
                        bundle
                    )
                }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.share){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val sharedbody = "Comment"
            val sharedsub: String = binding.textView.text.toString()
            intent.putExtra(Intent.EXTRA_SUBJECT, sharedbody)
            intent.putExtra(Intent.EXTRA_TEXT, sharedsub)
            startActivity(Intent.createChooser(intent, "Share Using"))
        }
        return super.onOptionsItemSelected(item)
    }

}
