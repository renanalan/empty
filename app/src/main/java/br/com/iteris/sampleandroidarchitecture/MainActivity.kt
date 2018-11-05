package br.com.iteris.sampleandroidarchitecture

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = UserAdapter()
        rv_user.adapter = adapter
        rv_user.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.getUsers().observe(this, Observer<ArrayList<User>> { users ->
            users?.let { adapter.setUsers(it) }
        })
    }
}
