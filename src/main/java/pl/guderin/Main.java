package pl.guderin;

import com.typesafe.config.*;
import java.io.File;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        String configFileName = args[0];
        System.out.println("configFileName: " + configFileName);

        File configFile = new File(configFileName);

        Config conf = ConfigFactory.parseFile(configFile).resolve();

        ConfigRenderOptions options = ConfigRenderOptions.defaults()
                .setFormatted(true)
                .setComments(true)
                .setOriginComments(false);


        //conf.checkValid(ConfigFactory.defaultReference());

        System.out.println(conf.root().render(options));

//        System.out.println("The answer is: " + conf.getString("simple-lib.foo"));


    }
}
