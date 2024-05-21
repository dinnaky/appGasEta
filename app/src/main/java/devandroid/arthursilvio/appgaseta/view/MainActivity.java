package devandroid.arthursilvio.appgaseta.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import devandroid.arthursilvio.appgaseta.R;
import devandroid.arthursilvio.appgaseta.controller.PersonController;
import devandroid.arthursilvio.appgaseta.model.Person;
import devandroid.arthursilvio.appgaseta.controller.courseController;

public class MainActivity extends AppCompatActivity {

    courseController courseController;
    List<String> nameCourses;
    PersonController controller;
    EditText editFirstName;
    EditText editSurname;
    EditText editCourse;
    EditText editTell;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;
    Person person;

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controller = new PersonController(MainActivity.this);

        person = new Person();
        controller.search(person);

        courseController = new courseController();
        nameCourses = courseController.dataSpinner();

        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editCourse = findViewById(R.id.editCourse);
        editTell = findViewById(R.id.editTell);
        spinner = findViewById(R.id.spinner);

        editFirstName.setText(person.getFirstName());
        editSurname.setText(person.getSurname());
        editCourse.setText(person.getCourse());
        editTell.setText(person.getTell());

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        // Adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseController.dataSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        buttonClean.setOnClickListener(v -> {
            editFirstName.setText("");
            editSurname.setText("");
            editCourse.setText("");
            editTell.setText("");
            controller.clean();
        });

        buttonFinish.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Sucesso ao mandar as informações", Toast.LENGTH_LONG).show();
            finish();
        });

        buttonSave.setOnClickListener(v -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setCourse(editCourse.getText().toString());
            person.setTell(editTell.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Salvo com sucesso " + person.toString(), Toast.LENGTH_LONG).show();
            editFirstName.setText("");
            editSurname.setText("");
            editCourse.setText("");
            editTell.setText("");

            controller = new PersonController(MainActivity.this);
            controller.save(person);
        });
    }
}