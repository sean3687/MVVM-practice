package com.tassiecomp.roomdatabasepractice.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tassiecomp.roomdatabasepractice.R
import com.tassiecomp.roomdatabasepractice.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //레이아웃 연결
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //리사이클러뷰
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //뷰모델 연결
            //뷰모델을 불러옵니다.
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->
            //ViewModel 함수인 observe를 이터가 바뀌었을때 adapter에서 만들어준 setData함수를 실행시키게됩니다.
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment) //플로팅 버튼을 누르면 addFragment로 화면전환합니다.
        }


        //add menue
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId ==R.id.menu_delete){
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yse"){ _, _ ->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),"Suscessfully removed everything ",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ ->
        }

        builder.setTitle("Delete delete everything?")
        builder.setMessage("Are you sure to delete everything?")
        builder.create().show()
    }

}