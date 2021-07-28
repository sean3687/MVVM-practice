package com.tassiecomp.roomdatabasepractice.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tassiecomp.roomdatabasepractice.R
import com.tassiecomp.roomdatabasepractice.model.User
import com.tassiecomp.roomdatabasepractice.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel:UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.firstName)
        view.updateAge_et.setText(args.currentUser.age.toString())

        view.update_button.setOnClickListener{
            updateItem()
        }

        //Add Menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){

//        변경된 값들을 editText에서 가져옵니다.
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())

        if (inputCheck(firstName,lastName,updateAge_et.text)){
            //updatedUser는 업데이트된 데이터입니다.
            val updatedUser = User(args.currentUser.id, firstName, lastName,age)
            //updateUser쿼리를 만들어서 database에 추가해줘야합니다.
            //쿼리는 DAO에서 추가해야합니다. 지금은 구현만 해두겠습니다.
            mUserViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(),"UpdatedSuccessfully",Toast.LENGTH_SHORT).show()
            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else{
            //EditText가 빈칸이면 토스트 메세지
            Toast.makeText(requireContext(),"Please fill out all field",Toast.LENGTH_SHORT).show()
        }
    }
    //editText가 비어있는 지확인
    private fun inputCheck(firstName:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yse"){ _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"Suscessfully removed: ${args.currentUser.firstName}",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ ->
        }

        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure to delete ${args.currentUser.firstName}")
        builder.create().show()
    }

}