package com.example.helpiui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    boolean isMine = true;
    private EditText editText;
    private List<ChatBubble> chatMessages;
    private ArrayAdapter<ChatBubble> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatMessages = new ArrayList<>();

        ListView listView = findViewById(R.id.messages_view);
        View btnSend = findViewById(R.id.btnSend);
        editText = findViewById(R.id.editText);

        adapter = new MessageAdapter(this, R.layout.send_message, chatMessages);
        listView.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(ChatActivity.this, "Plese enter a query!!", Toast.LENGTH_SHORT).show();
                } else {
                    String mess = editText.getText().toString();
                    String rep = answer(mess);
                    ChatBubble chatMessage = new ChatBubble(mess, isMine);
                    chatMessages.add(chatMessage);
                    chatMessage = new ChatBubble(rep, !isMine);
                    chatMessages.add(chatMessage);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }

            String answer(String m) {
                String rep = "";
                m = m.toLowerCase();
                if (m.contains("head") || m.contains("hod")) {
                    if (m.contains("computer")) {
                        rep = "Miss Bhavini Bhatt is the head of computer engineering Department.";
                    } else if (m.contains("civil")) {
                        rep = "professor Sejal Patel is the head of civil engineering department.";
                    } else if (m.contains("chemical")) {
                        rep = "The head of chemical engineering department is Doctor Jaydeepsinh Barad.";
                    } else if (m.contains("mechanical")) {
                        rep = "Professor Kantibhai Rathod is the head of mechanical engineering department.";
                    } else if (m.contains("electrical")) {
                        rep = "The head of electrical engineering department is professor Chinmay Desai.";
                    } else if (m.contains("science")) {
                        rep = "Professor Dinesh Dadhania is the head of science and humanity department.";
                    }
                } else if (m.contains("principal")) {
                    rep = "Dr. Latesh B. Chaudhri is the principal of R N G Patel Institute of Technology.";
                } else
                    rep = "Sorry! I do not get it as I'm in development phase.";
                return rep;
            }

        });
    }
}
