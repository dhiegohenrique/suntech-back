package br.com.suntech.utils;

public class FilterUtils {

	public static String getFilterLike(String name) {
		if (name == null) {
			return null;
		}
		
		String filterNormalize = name;
		filterNormalize = filterNormalize.replace("%20", " ");
		filterNormalize = filterNormalize.replace("\\", "\\\\");
		filterNormalize = filterNormalize.replace("'", "\\'");
		filterNormalize = filterNormalize.replace("\0", "\\0");
		filterNormalize = filterNormalize.replace("\n", "\\n");
		filterNormalize = filterNormalize.replace("\r", "\\r");
		filterNormalize = filterNormalize.replace("\"", "\\\"");
		filterNormalize = filterNormalize.replace("\\x1a", "\\Z");
		return "%" + filterNormalize.toUpperCase() + "%";
	}
}