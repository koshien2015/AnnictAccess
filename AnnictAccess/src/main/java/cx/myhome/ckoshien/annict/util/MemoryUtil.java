package cx.myhome.ckoshien.annict.util;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

public class MemoryUtil {
	private static Logger logger = Logger.getLogger("rootLogger");
	public static String getMemoryInfo() {
		String info = "";

		DecimalFormat format_mem =   new DecimalFormat("#,###KB");
		DecimalFormat format_ratio = new DecimalFormat("##.#");
		long free =  Runtime.getRuntime().freeMemory() / 1024;
		long total = Runtime.getRuntime().totalMemory() / 1024;
		long max =   Runtime.getRuntime().maxMemory() / 1024;
		long used =  total - free;
		double ratio = (used * 100 / (double)total);
		double ratio2=(total*100/(double)max);

		info += "Total   = " + format_mem.format(total);
		info += "\n";
		info += "Free    = " + format_mem.format(total);
		info += "\n";
		info += "use     = " + format_mem.format(used) + " (" + format_ratio.format(ratio) + "%)";
		info += "\n";
		info += "can use = " + format_mem.format(max)+"("+format_ratio.format(ratio2)+"%)";
		return info;
	}

	public static void viewMemoryInfo() {
	    //logger.info("---------- MemoryInfo --------");
	    logger.info(getMemoryInfo());
	    //logger.info("------------------------------");
	}

}
