
package com.iftm.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;


@Deprecated
public class FileHelper extends HttpServlet {

    private Properties build_prop(String config_path) throws IOException {
        Properties prop = new Properties();
        prop.load(getServletContext().getResourceAsStream(config_path));
        return prop;
    }

    public static Properties getDatabaseProp() {
        FileHelper fh = null;
        Properties p = null;
        fh = new FileHelper();
        try {
            p = fh.build_prop("/WEB-INF/database.properties");
        } catch (IOException ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
