# DatePickerTextView

[![JitPack](https://jitpack.io/v/com.github.sagar1729sagar/DatePickerTextView.svg)](https://jitpack.io/#com.github.sagar1729sagar/DatePickerTextView)

A customizable Android library for date selection that allows you to set custom icons for the `CalendarImage` and supports flexible date formats. Perfect for developers looking to integrate a user-friendly date picker into their apps.

---

## Features

- Easy integration into any Android project.
- Customizable `ImageView` for the date picker icon.
- Flexible date format configuration.
- Lightweight and fully customizable.

---

## Installation

### Step 1: Add the JitPack repository to your project

Add the following in your root `settings.gradle`(Project settings) :

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the dependency to your project

Add the following to the `build.gradle` (Module:app):

```groovy
dependencies {
    implementation 'com.github.sagar1729sagar:DatePickerTextView:v1.0.3'
}
```

## Usage

### Basic Implementation

Add the `DatePickerTextView` to your XML layout:

```xml
<com.your.package.DatePickerTextView
    android:id="@+id/date_picker_text_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:hint="Select Date"
    app:icon="@drawable/ic_calendar"
    app:dateFormat="dd/MM/yyyy" />

```


###  Configure in Java/Kotlin

To use `DatePickerTextView` in your code, follow these steps:
In your Activity or Fragment

```Java
val datePickerTextView: DatePickerTextView = findViewById(R.id.date_picker_text_view)

// Set an icon programmatically
datePickerTextView.setIconResource(R.drawable.ic_calendar)

// Set a custom date format
datePickerTextView.setDateFormat("MM-dd-yyyy")

// Get selected date
val selectedDate = datePickerTextView.getSelectedDate()
```

###  Date Change Listener

To handle date changes programmatically, use the `setOnDateChangeListener` method:

```Java
datePickerTextView.setOnDateChangeListener(new DatePickerTextView.OnDateChangeListener() {
    @Override
    public void onDateChanged(String newDate) {
        // Handle the selected date
        Toast.makeText(context, "Selected date: " + newDate, Toast.LENGTH_SHORT).show();
    }
});

```

### Customization

| Attribute     | Description                                      | Default value         |
|---------------|--------------------------------------------------|-----------------------|
| `app:icon`    | Set a custom icon for the `ImageView`.           | `@drawable/ic_calendar`|
| `app:dateFormat` | Set the date format.                           | `"dd/MM/yyyy"`        |


## Contribution

Contributions, issues, and feature requests are welcome!  
Feel free to check the issues page.

## License

This project is licensed under the MIT License.

## Acknowledgments

This library was developed by Vidya Sagar to simplify date selection in Android apps.

