package pl.guderin;

import com.typesafe.config.*;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

public class Main
{
    public static void main( String[] args )
    {
        String configFileName = args[0];
        System.out.println("configFileName: " + configFileName);

        File configFile = new File(configFileName);

        Config conf = ConfigFactory.parseFile(configFile);

        ConfigRenderOptions options = ConfigRenderOptions.defaults()
                .setFormatted(false)
                .setComments(false)
                .setOriginComments(false);

        Set<Map.Entry<String, ConfigValue>> entries = conf.entrySet();
        Map<String, String> map = new TreeMap<String, String>();

        for (Map.Entry<String, ConfigValue> entry : conf.entrySet()) {
            map.put(entry.getKey(), entry.getValue().render(options));
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();        }
    }
}
