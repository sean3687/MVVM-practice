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
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())

        if (inputCheck(firstName,lastName,updateAge_et.text)){
            val updatedUser = User(args.currentUser.id, firstName, lastName,age)
            //val update Current user
            mUserViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(),"UpdatedSuccessfully",Toast.LENGTH_SHORT).show()
            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else{
            Toast.makeText(requireContext(),"Please fill out all field",Toast.LENGTH_SHORT).show()
        }
    }
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