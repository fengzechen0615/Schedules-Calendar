package UI;

import java.time.LocalDate;
import java.util.Locale;

import javafx.scene.control.DatePicker;

public class Datepicker {
	public static DatePicker getDatepicker() {
		DatePicker datepicker = new DatePicker();
		datepicker.setValue(LocalDate.now());	
		
		Locale.setDefault(Locale.US);
		
		return datepicker;
	}

}
