package pl.zabrze.zs10.quiz4p1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.os.Bundle;
import android.widget.TextView;

public class PodpowiedzActivity extends AppCompatActivity {
private TextView textViewPodpowiedz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podpowiedz);
        textViewPodpowiedz = findViewById(R.id.textView);
        String podpowiedz = getIntent().getStringExtra("PODPOWIEDZ");
        textViewPodpowiedz.setText(podpowiedz);
    }
}