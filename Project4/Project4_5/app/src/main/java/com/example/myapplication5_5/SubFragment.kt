package com.example.myapplication5_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication5_5.R

class SubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, container, false)

        // 데이터 생성, item 개수는 20개
        val datas = mutableListOf<String>()
        for(i in 1..20){ datas.add("Item $i") }

        // RecyclerView 가져오기
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // RecyclerView의 layout manager, adapter, item decoration 설정
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(datas)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

        return view
    }


}
