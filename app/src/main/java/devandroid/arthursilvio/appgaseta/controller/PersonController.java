package devandroid.arthursilvio.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.arthursilvio.appgaseta.model.Person;
import devandroid.arthursilvio.appgaseta.view.MainActivity;

public class PersonController {

    SharedPreferences preferences;
    SharedPreferences.Editor listVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public void save(Person person) {
        listVip.putString("firstName", person.getFirstName());
        listVip.putString("surname", person.getSurname());
        listVip.putString("course", person.getCourse());
        listVip.putString("tell", person.getTell());
        listVip.apply();
    }

    public PersonController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listVip = preferences.edit();
    }

    public Person search(Person person) {
        person.setFirstName(preferences.getString("firstName", ""));
        person.setSurname(preferences.getString("surname", ""));
        person.setCourse(preferences.getString("course", ""));
        person.setTell(preferences.getString("tell", ""));

        return person;
    }

    public void clean() {
        listVip.clear();
        listVip.apply();

    }
}
