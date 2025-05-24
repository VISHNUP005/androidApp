package com.example.vwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vwork.R
import com.example.vwork.adapters.NoteAdapter
import com.example.vwork.models.Note
import java.util.UUID

class TechNotesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private val techNotes = mutableListOf<Note>() // You can load this from storage or Firebase later

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tech_notes, container, false)

        recyclerView = view.findViewById(R.id.techNotesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        noteAdapter = NoteAdapter(techNotes)
        recyclerView.adapter = noteAdapter

        // Sample data
        techNotes.add(Note(
            id = UUID.randomUUID().toString(),
            title = "Kotlin Basics",
            content = "Learn about variables, loops, and classes.",
            timestamp = System.currentTimeMillis(),
            category = "tech"
        ))

        techNotes.add(Note(
            id = UUID.randomUUID().toString(),
            title = "RecyclerView",
            content = "Used to display scrollable lists efficiently.",
            timestamp = System.currentTimeMillis(),
            category = "tech"
        ))
        noteAdapter.notifyDataSetChanged()

        return view
    }
}