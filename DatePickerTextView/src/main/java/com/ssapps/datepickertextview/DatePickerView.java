package com.ssapps.datepickertextview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ssapps.datepickertextview.databinding.DatePickerViewBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerView extends LinearLayout {
    private final @NonNull DatePickerViewBinding binding;

    private SimpleDateFormat dateFormat;
    private OnDateChangedListener OnDateChangedListener;
    public DatePickerView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        binding = DatePickerViewBinding.inflate(LayoutInflater.from(context), this, true);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DatePickerView, 0, 0);
        try {
            int iconResId = attributes.getResourceId(R.styleable.DatePickerView_icon, -1);
            if (iconResId != -1){
                binding.datePickerActions.setImageResource(iconResId);
            }

            String format = attributes.getString(R.styleable.DatePickerView_dateFormat);
            setDateFormat(format==null?"dd/MM/yyyy":format);

            int textColor = attributes.getColor(R.styleable.DatePickerView_textColor, -1);
            if (textColor != -1){
                binding.dateText.setTextColor(textColor);
            }
        } finally {
            attributes.recycle();
        }
        Calendar calendar = Calendar.getInstance();

        binding.dateText.setText(dateFormat.format(calendar.getTime()));

        binding.datePickerActions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener listener  = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        String new_date = dateFormat.format(calendar.getTime());
                        binding.dateText.setText(new_date);

                        if (OnDateChangedListener != null){
                            OnDateChangedListener.onDateChanged(new_date);
                        }
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }

    public void setDateFormat(String format){
        dateFormat = new SimpleDateFormat(format, Locale.getDefault());
    }

    public void setIcon(Drawable drawable){
        binding.datePickerActions.setImageDrawable(drawable);
    }

    public String getSelectedDate() {
        return binding.dateText.getText().toString();
    }
    /**
     * Sets the date using a string and a specific format.
     */
    public void setDate(String date, String format) {
        try {
            SimpleDateFormat customDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(customDateFormat.parse(date));
            binding.dateText.setText(dateFormat.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid date or format provided");
        }
    }

    /**
     * Sets the date using a string in the default format.
     */
    public void setDate(String date) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(date));
            binding.dateText.setText(dateFormat.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid date provided for the default format");
        }
    }

    public void setOnDateChangedListener(OnDateChangedListener listener){
        this.OnDateChangedListener = listener;
    }

}

