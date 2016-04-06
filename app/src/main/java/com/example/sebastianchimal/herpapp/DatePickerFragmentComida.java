package com.example.sebastianchimal.herpapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by sebastianchimal on 21/02/16.
 */
public class DatePickerFragmentComida  extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public EditText fechaCambioComida;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        poblarEstado(year,month,day);
    }

    private void poblarEstado(int year, int month, int day) {
        fechaCambioComida = (EditText)getActivity().findViewById(R.id.cambioComida);
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(c.getTime());
        fechaCambioComida.setText(formattedDate);
    }
}
