package Utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatData {

	
	public String formatarData(String dataStr) {
		SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date data = formatoEntrada.parse(dataStr);

			return formatoSaida.format(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
