package com.tassiecomp.roomdatabasepractice.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tassiecomp.roomdatabasepractice.R
import com.tassiecomp.roomdatabasepractice.model.User
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.firstName)
        view.updateAge_et.setText(args.currentUser.age.toString())

        view.update_button.setOnClickListener{

        }
        return view
    }

    private fun updateItem(){
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())

        if (inputCheck(firstName,lastName,updateAge_et.text)){
            val updatedUser = User(args.currentUser.id, firstName, lastName,age)
            //val update Current user
            mUserViewModel.
        }
    }
    private fun inputCheck(firstName:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

}