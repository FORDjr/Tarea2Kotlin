package com.example.productosdiegopozas.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productosdiegopozas.R

class HomeFragment : Fragment(), CustomAdapter.OnItemClickListener {

    private val elements = mutableListOf(
        ListElement("#775447", "Papas Fritas", "Crujientes", "3990", "Papas fritas caseras hechas con aceite de oliva."),
        ListElement("#607d8b", "Completo", "Italiano", "2500", "Completo con palta, tomate y mayonesa."),
        ListElement("#009688", "Tallarines", "Carozzi", "3090", "Tallarines de trigo duro, perfectos para tus pastas."),
        ListElement("#3f51b5", "Lechuga", "Fresca", "990", "Lechuga hidropónica fresca y crujiente."),
        ListElement("#ff4081", "Tomate", "Fresco", "990", "Tomates orgánicos cultivados localmente.")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomAdapter(elements, requireContext(), this)

        return rootView
    }

    override fun onItemClick(item: ListElement) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }
}
