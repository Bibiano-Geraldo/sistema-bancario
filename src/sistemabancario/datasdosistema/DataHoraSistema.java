package sistemabancario.datasdosistema;

import java.text.DateFormat;
import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class DataHoraSistema {

    public static String getDataPadrao() {
        Calendar calendar = Calendar.getInstance();
        Locale locale = new Locale("pt","MZ");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        return df.format(calendar.getTime());
    }

    public static String getHoraPadrao() {
        LocalTime localTime = LocalTime.now(Clock.system(ZoneId.systemDefault().normalized()));
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
