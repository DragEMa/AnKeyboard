package com.ankeyboard.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * Simple debug screen that allows the user to send an issue report via a webhook.
 *
 * The webhook is expected to forward the JSON payload to GitHub (or any other
 * issue tracker) securely.  See the repository README or the accompanying
 * server code for a minimal Node/Express webhook implementation.
 */
public class DebugActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etBody;
    private Button btnSend;

    private static final String WEBHOOK_URL = "https://ankeyboard.anerysrynz.rf.gd/webhook/create-issue";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        etTitle = findViewById(R.id.etTitle);
        etBody = findViewById(R.id.etBody);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String body = etBody.getText().toString().trim();
                if (title.isEmpty()) {
                    Toast.makeText(DebugActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }
                postIssue(title, body);
            }
        });
    }

    private void postIssue(String title, String body) {
        OkHttpClient client = new OkHttpClient();
        JSONObject payload = new JSONObject();
        try {
            payload.put("title", title);
            payload.put("body", body);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to build payload", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestBody requestBody = RequestBody.create(payload.toString(), JSON);
        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .post(requestBody)
                .addHeader("User-Agent", "AnKeyboard/Debug")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> {
                    Toast.makeText(DebugActivity.this, "Failed to send issue", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String msg;
                if (response.isSuccessful()) {
                    msg = "Issue sent (status " + response.code() + ")";
                } else {
                    msg = "Error: " + response.code();
                }
                runOnUiThread(() -> Toast.makeText(DebugActivity.this, msg, Toast.LENGTH_SHORT).show());
                response.close();
            }
        });
    }
}
