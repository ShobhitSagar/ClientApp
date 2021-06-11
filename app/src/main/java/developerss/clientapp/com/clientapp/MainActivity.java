package developerss.clientapp.com.clientapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private static Socket s;
    private static PrintWriter printWriter;
    String msg="";
    private static String ip = "192.168.0.102";
    EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = findViewById(R.id.et_message);
        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    toast("Entered in try");
                    s = new Socket("192.168.0.102", 6666);
                    Toast.makeText(MainActivity.this, "Connected!", Toast.LENGTH_SHORT).show();
                    s.close();

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Not Connected!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

//                msg = etMessage.getText().toString();
//                MyTask mt = new MyTask();
//                mt.execute();
//                toast("Data sent!");
            }
        });
    }

    //  Database
//    class MyTask extends AsyncTask<Void, Void, Void>
//    {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//                toast("Entered in try");
//                s = new Socket(ip, 6666);
//                Toast.makeText(MainActivity.this, "Connected!", Toast.LENGTH_SHORT).show();
//                printWriter = new PrintWriter(s.getOutputStream());
//                printWriter.flush();
//                printWriter.close();
//                s.close();
//
//            } catch (IOException e) {
//                Toast.makeText(MainActivity.this, "Not Connected!", Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

    // Toast
    public void toast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();;
    }
}



//                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//                    msg = etMessage.getText().toString();
//                    dos.writeUTF("Hello");
//                    dos.flush();
//                    dos.close();